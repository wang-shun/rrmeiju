package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.service.ServiceFacade;
import com.caizhukui.rrmeiju.service.thirdparty.EpguidesService;

/**
 * Epguides服务实现类
 * 
 * @author caizhukui
 * @date 2018年4月25日
 */
@Service
public class EpguidesServiceImpl implements EpguidesService {
    
    private static final Logger logger = LoggerFactory.getLogger(EpguidesServiceImpl.class);
    
    @Autowired
    protected ServiceFacade serviceFacade;

    @Override
    public List<String> getInsertScriptsOfAll() {
        List<String> allInsertScripts = new ArrayList<>();
        int pageSize = 50, pageIndex = 1;
        List<Serial> serials = null;
        do {
            serials = serviceFacade.getSerialService().getAllByPagination(pageSize, pageIndex++);
            serials.forEach(serial -> {
                List<String> insertScripts = getInsertScriptsBySerial(serial);
                allInsertScripts.addAll(insertScripts);
            });
        } while (CollectionUtils.isNotEmpty(serials));
        return allInsertScripts;
    }

    @Override
    public List<String> getEpisodeInfosBySerialUuid(String serialUuid) {
        Serial serial = serviceFacade.getSerialService().getByUuid(serialUuid);
        return getInsertScriptsBySerial(serial);
    }

    @Override
    public List<String> getInsertScriptsBySerial(Serial serial) {
        List<String> insertScripts = null;
        if (!serial.getFinished()) {
            List<Season> seasons = serviceFacade.getSeasonService().getBySerialUuid(serial.getUuid());
            if (CollectionUtils.isNotEmpty(seasons)) {
                logger.info("当前剧集<{}>", serial.getChineseName());
                Document document = getDocumentFromEpguides(serial.getEpguidesName());
                List<List<String>> episodeNames = getEpisodeNamesBySerialNameEnglish(document);
                insertScripts = generateInsertScripts(episodeNames, seasons);
                logger.info("剧集<{}>从Epguides获取信息完成", serial.getChineseName());
            }
        }
        return insertScripts;
    }

    /**
     * 获取Document
     * 
     * @param serialNameEpguides
     * @return Document
     * @author caizhukui
     * @date 2017年2月8日
     */
    private Document getDocumentFromEpguides(String serialNameEpguides) {
        final String BASE_URI = "http://epguides.com/";
        Document document = null;
        try {
            String url = BASE_URI + serialNameEpguides + "/";
            logger.info("请求URL为：{}", url);
            Connection connection = Jsoup.connect(url);
            document = connection.get();
        } catch (Exception e) {
            logger.error("获取{}出错，跳过", serialNameEpguides, e);
        }
        return document;
    }
    
    /**
     * 
     * 
     * @param serialNameEnglish
     * @return Document
     * @author caizhukui
     * @date 2017年6月8日
     */
    private Document getDocumentFromAddic7ed(String serialNameEnglish) {
        final String BASE_URI = "http://www.addic7ed.com/search.php";
        Document document = null;
        try {
            String[] keywords = serialNameEnglish.split(" ");
            StringBuffer sb = new StringBuffer();
            sb.append(BASE_URI);
            sb.append("?search=");
            for (String keyword : keywords) {
                sb.append(keyword);
                sb.append("+");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("&Submit=Search");
            String url = sb.toString();
            logger.info("请求URL为：{}", url);
            Connection connection = Jsoup.connect(url);
            document = connection.get();
        } catch (Exception e) {
            logger.error("获取{}出错，跳过", serialNameEnglish, e);
        }
        return document;
    }
    
    /**
     * 解析Document，提取出剧集名的列表
     * 
     * @param document
     * @return List<List<String>>
     * @author caizhukui
     * @date 2017年2月8日
     */
    private List<List<String>> getEpisodeNamesBySerialNameEnglish(Document document) {
        if (document == null) return null;
        Element content = document.getElementById("eplist");
        if (content == null) return null;
        Elements links = content.getElementsByTag("a");
        if (CollectionUtils.isEmpty(links)) return null;
        int currentSeasonIndex = 1, seasonIndex = 1;
        List<String> episodeNamesOfSeason = new ArrayList<String>();
        List<List<String>> episodeNames = new ArrayList<List<String>>();
        for (Element link : links) {
            String linkHref = link.attr("href");
            String regex = "\\S*-(\\d+)x\\d+-\\S*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(linkHref);
            if (matcher.find()) {
                seasonIndex = Integer.valueOf(matcher.group(1));
                if (seasonIndex != currentSeasonIndex) {
                    episodeNames.add(episodeNamesOfSeason);
                    episodeNamesOfSeason = new ArrayList<String>();
                    currentSeasonIndex = seasonIndex;
                }
                String linkText = link.text();
                if (StringUtils.isNotEmpty(linkText) && !linkText.equals("TBA")) {
                    episodeNamesOfSeason.add(linkText);
                }
            }
        }
        episodeNames.add(episodeNamesOfSeason);
        return episodeNames;
    }
    
    /**
     * 生成MySQL数据库脚本
     * 
     * @param episodeNames
     * @param seasons
     * @return List<String>
     * @author caizhukui
     * @date 2017年2月8日
     */
    private List<String> generateInsertScripts(List<List<String>> episodeNames, List<Season> seasons) {
        if (episodeNames == null || seasons == null) {
            logger.info("{} 数据不对", seasons.get(0).getChineseName());
            return null;
        }
        List<String> insertScripts = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        for (Season season : seasons) {
            int seasonIndex = season.getSeasonIndex();
            if (seasonIndex > 0 && seasonIndex <= episodeNames.size()) { // 有可能出现数据库里的季数比从epguides页面上获取到的季数多的情况
                List<String> episodeNamesBySeason = episodeNames.get(seasonIndex - 1);
                // 检查是否已经获取过
                List<Episode> episodesBySeason = serviceFacade.getEpisodeService().getBySeasonUuid(season.getUuid());
                if (episodesBySeason == null) {
                    episodesBySeason = new ArrayList<Episode>();
                } else if (CollectionUtils.isNotEmpty(episodesBySeason)) {
                    Collections.sort(episodesBySeason);
                    // 剔除episodeIndex为0的数据
                    if (episodesBySeason.get(0).getEpisodeIndex() == 0) {
                        episodesBySeason = episodesBySeason.subList(1, episodesBySeason.size());
                    }
                }
                if (episodesBySeason.size() >= episodeNamesBySeason.size()) {
                    logger.info("{} 已获取过，跳过", season.getChineseName());
                    continue;
                }
                insertScripts.add("-- " + season.getChineseName());
                episodeNamesBySeason = episodeNamesBySeason.subList(episodesBySeason.size(), episodeNamesBySeason.size());
                int episodeIndex = episodesBySeason.size() + 1;
                for (String episodeName : episodeNamesBySeason) {
                    sb.append("INSERT INTO episode(episode_uuid, episode_index, episode_name, season_uuid) VALUES(LOWER(REPLACE(UUID(), '-', '')), ");
                    sb.append(episodeIndex++);
                    sb.append(", '");
                    sb.append(episodeName.replaceAll("'", "\\\\'"));
                    sb.append("', '");
                    sb.append(season.getUuid());
                    sb.append("');");
                    insertScripts.add(sb.toString());
                    sb.setLength(0); // 清空StringBuffer
                }
            }
        }
        return insertScripts;
    }

}
