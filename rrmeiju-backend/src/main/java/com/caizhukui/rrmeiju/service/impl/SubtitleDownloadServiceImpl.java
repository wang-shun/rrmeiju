package com.caizhukui.rrmeiju.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.bo.IpLocation;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.SubtitleDownloadMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Ip;
import com.caizhukui.rrmeiju.model.SubtitleDownload;
import com.caizhukui.rrmeiju.service.SubtitleDownloadService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 字幕下载记录服务实现类
 * 
 * @author caizhukui
 * @date 2017年5月10日
 */
@Service
public class SubtitleDownloadServiceImpl extends BaseServiceImpl<SubtitleDownload> implements SubtitleDownloadService {
	
	private static final Logger logger = LoggerFactory.getLogger(SubtitleDownloadServiceImpl.class);
	
	@Autowired
	private SubtitleDownloadMapper subtitleDownloadMapper;
	
    @Override
    public SubtitleDownload add(SubtitleDownload subtitleDownload) {
        serviceFacade.getSubtitleService().increaseDownloadCount(subtitleDownload.getSubtitleUuid());
        String remoteIp = subtitleDownload.getRemoteIp();
        // IP这块逻辑不应该在这里操作？
        Ip ip = commonServiceFacade.getIpService().getByIp(remoteIp);
        if (ip == null) {
            IpLocation ipLocation = commonServiceFacade.getIpService().getLocationByIp(remoteIp);
            commonServiceFacade.getIpService().add(ipLocation.convert());
        }
        return super.add(subtitleDownload);
    }
	
	@Override
	public Set<String> getAllIps() {
		Set<String> ips = subtitleDownloadMapper.getAllIps();
		return ips;
	}

	@Override
	public List<SubtitleDownload> getByUserUuid(String userUuid) {
		List<SubtitleDownload> subtitleDownloads = subtitleDownloadMapper.getByUserUuid(userUuid);
		return subtitleDownloads;
	}
	
	@Override
	public List<SubtitleDownload> getBySubtitleUuid(String subtitleUuid) {
		List<SubtitleDownload> subtitleDownloads = subtitleDownloadMapper.getBySubtitleUuid(subtitleUuid);
		return subtitleDownloads;
	}

	@Override
	public List<Map<String, Object>> getGeoData() {
		List<Map<String, Object>> subtitleDownloadGeoData = subtitleDownloadMapper.getGeoData();
		return subtitleDownloadGeoData;
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.SUBTITLE_DOWNLOAD;
    }

    @Override
    protected BaseMapper<SubtitleDownload> getMapper() {
        return subtitleDownloadMapper;
    }

}
