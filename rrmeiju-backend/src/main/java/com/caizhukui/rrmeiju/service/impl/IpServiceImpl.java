package com.caizhukui.rrmeiju.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.caizhukui.common.util.HttpUtils;
import com.caizhukui.rrmeiju.bo.IpLocation;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.IpMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Ip;
import com.caizhukui.rrmeiju.service.IpService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

import net.sf.json.JSONObject;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月21日
 */
@Service
@PropertySource("classpath:properties/location.properties")
public class IpServiceImpl extends BaseServiceImpl<Ip> implements IpService {
	
    private static final Logger logger = LoggerFactory.getLogger(IpServiceImpl.class);
    
    @Autowired
    private IpMapper ipMapper;
    
    private static final String UNKNOWN = "未知";
    
    @Value("${sina.location.service.url}")
    private String sinaServiceUrl;

    @Value("${baidu.location.service.url}")
    private String baiduServiceUrl;
    
    @Value("${taobao.location.service.url}")
    private String taobaoServiceUrl;
    
    @Value("${ne126.location.service.url}")
    private String ne126ServiceUrl;
    
    /**
     * 接口调用优先级：IP138>新浪>淘宝>百度>网易126
     * @see com.caizhukui.rrmeiju.service.IpService#getLocation(java.lang.String)
     */
    @Override
	public IpLocation getLocationByIp(String ip) {
    	logger.info("根据IP查询地理位置：IP = {}", ip);
		if (StringUtils.isEmpty(ip) || isInner(ip)) {
            return new IpLocation(ip);
        }
		IpLocation ipLocation = null;
		try {
			ipLocation = getLocationFromIp138(ip);
			//logger.info("IP138服务查询结果：{}", ipLocation);
		} catch (Exception e) {
        	logger.error("IP138IP服务查询出错");
        }
		if (ipLocation != null && ipLocation.isKnown()) {
            return ipLocation;
        }
        // 新浪IP服务
        try {
            ipLocation = getLocationFromSina(ip);
            logger.info("新浪IP服务查询结果：{}", ipLocation);
        } catch (Exception e) {
        	logger.error("新浪IP服务查询出错");
        }
        if (ipLocation != null && ipLocation.isKnown()) {
            return ipLocation;
        }
        // 淘宝IP服务
        try {
        	ipLocation = getLocationFromTaobao(ip);
        	logger.info("淘宝IP服务查询结果：{}", ipLocation);
        } catch (Exception e) {
        	logger.error("淘宝IP服务查询出错");
        }
        if (ipLocation != null && ipLocation.isKnown()) {
            return ipLocation;
        }
        // 百度IP服务
        try {
            ipLocation = getLocationFromBaidu(ip);
            logger.info("百度IP服务查询结果：{}", ipLocation);
        } catch (Exception e) {
        	logger.error("百度IP服务查询出错");
        }
        if (ipLocation != null && ipLocation.isKnown()) {
            return ipLocation;
        }
        // 网易126IP服务
        try {
            ipLocation = getLocationFromNe126(ip);
            logger.info("网易126IP服务查询结果：{}", ipLocation);
        } catch (Exception e) {
        	logger.error("网易126IP服务查询出错");
        }
        if (ipLocation == null) {
            ipLocation = new IpLocation(ip);
        }
        return ipLocation;
	}
    
    /**
     * IP138地址查询服务（只返回国内IP地址的信息）
     * 
     * @param ip IP地址
     * @return IpLocation
     * @throws Exception
     * @author caizhukui
     * @date 2017年8月8日
     */
    private static IpLocation getLocationFromIp138(String ip) throws Exception {
    	String url = "http://www.ip138.com/ips1388.asp?ip=" + ip + "&action=2";
    	Connection connection = Jsoup.connect(url);
		Document document = connection.get();
		Elements uls = document.getElementsByClass("ul1");
		Elements lis = uls.get(0).getElementsByTag("li");
		String data = lis.get(0).text();
		int beginIndex = data.indexOf("：");
		data = data.substring(beginIndex + 1, data.length());
		int index = data.lastIndexOf(" ");
		if (index == -1) { // 香港特别行政区
			if (data.startsWith("香港")) {
				return new IpLocation(ip, "中国", "香港", "香港", "未知");
			} else if (data.startsWith("澳门")) {
				return new IpLocation(ip, "中国", "澳门", "澳门", "未知");
			} else {
				return null;
			}
		};
		// 省和市
		String area = data.substring(0, index).trim();
		// 运营商
		String operator = data.substring(index + 1, data.length()).trim();
		// 对运营商信息进行加工
		if (operator.contains("中华电信")) {
			operator = "中华电信";
		} else if (operator.contains("香港宽频")) {
			operator = "香港宽频";
		} else if (operator.contains("电讯盈科")) {
			operator = "电讯盈科";
		} else if (operator.contains("硕网网路")) {
			operator = "硕网网路";
    	} else if (operator.contains("亚太电信")) {
    		operator = "亚太电信";
    	} else if (operator.contains("远传电信")) {
			operator = "远传电信";
		} else if (operator.contains("大同电信")) {
			operator = "大同电信";
		} else if (operator.contains("台湾移动")) {
			operator = "台湾移动";
		} else if (operator.contains("新世纪资讯")) {
			operator = "新世纪资讯";
		} else if (operator.contains("新世纪资通")) {
			operator = "新世纪资通";
		} else if (operator.contains("台固媒体")) {
			operator = "台固媒体";
		} else if (operator.contains("台湾宽频")) {
			operator = "台湾宽频";
		} else if (operator.contains("威达云端")) {
			operator = "威达云端";
		} else if (operator.contains("台湾大哥大")) {
			operator = "台湾大哥大";
		} else if (operator.contains("大新店民主有线电视")) {
			operator = "大新店民主有线电视";
		} else if (operator.contains("中嘉宽频")) {
			operator = "中嘉宽频";
		} else if (operator.contains("凯擘股份")) {
			operator = "凯擘股份";
		} else if (operator.contains("大无畏宽频")) {
			operator = "大无畏宽频";
		}
		// 提取省市信息
		index = area.indexOf("省"); // 江苏省南通市
		if (index == -1) {
			index = area.indexOf("自治区"); // 广西壮族自治区南宁市
			if (index != -1) {
				index += 2;
			}
		}
		if (index == -1) {
			index = area.indexOf("特别行政区"); // 澳门特别行政区
			if (index != -1) {
				index += 4;
			}
		}
		if (index == -1) {
			index = area.indexOf("市"); // 北京市北京市，上海市浦东新区
		}
		if (index == -1) return null; // 马来西亚
		String province = area.substring(0, index).trim();
		String city = area.substring(index + 1, area.length()).trim();
		// 对省信息进行加工
		if (province.startsWith("香港")) {
			province = "香港";
		} else if (province.startsWith("澳门")) {
			province = "澳门";
		} else if (province.startsWith("广西")) {
			province = "广西";
		} else if (province.startsWith("新疆")) {
			province = "新疆";
		} else if (province.startsWith("宁夏")) {
			province = "宁夏";
		} else if (province.startsWith("内蒙古")) {
			province = "内蒙古";
		} else if (province.startsWith("西藏")) {
			province = "西藏";
		}
		// 对市信息进行加工
		if (city.length() == 0) {
			if (StringUtils.equals(province, "香港")) {
				city = "香港";
			} else if (StringUtils.equals(province, "澳门")) {
				city = "澳门";
			} else if (StringUtils.equals(province, "北京")) {
				city = "北京";
			} else if (StringUtils.equals(province, "上海")) {
				city = "上海";
			} else if (StringUtils.equals(province, "天津")) {
				city = "天津";
			} else if (StringUtils.equals(province, "重庆")) {
				city = "重庆";
			} else if (StringUtils.equals(province, "台湾")) {
				city = "台湾";
			} else {
				return null;
			}
		} else {
			index = city.indexOf(" ");
			if (index != -1) {
				city = city.substring(0, index).trim();
			}
			if (city.startsWith("（") || city.startsWith("(")) {
				city = city.substring(1, city.length());
			}
			if (city.endsWith("市") || city.endsWith("县") || city.endsWith("）") || city.endsWith(")")) {
				city = city.substring(0, city.length() - 1);
			}
			
		}
		return new IpLocation(ip, "中国", province, city, operator);
    }
	
	/**
	 * 新浪地址查询服务
	 * 
	 * @param ip IP地址
	 * @return IpLocation
	 * @throws Exception
	 */
    private IpLocation getLocationFromSina(String ip) throws Exception {
        String result = HttpUtils.sendHttpPost(sinaServiceUrl + ip);
        logger.info(result);
        if (StringUtils.isNotEmpty(result) && !"-2".equals(result.trim())&& result.indexOf("\"ret\":-1") == -1) {
            JSONObject jsonObject = JSONObject.fromObject(result);
            String country = jsonObject.getString("country");
            String province = jsonObject.getString("province");
            String city = jsonObject.getString("city");
            String operator = jsonObject.getString("isp");
            if (StringUtils.isEmpty(country)) {
            	country = UNKNOWN;
            }
            if (StringUtils.isEmpty(province)) {
                province = UNKNOWN;
            }
            if (StringUtils.isEmpty(city)) {
                city = UNKNOWN;
            }
            if (StringUtils.isEmpty(operator)) {
            	operator = UNKNOWN;
            }
            return new IpLocation(ip, country, province, city, operator);
        }
        return null;
    }
    
    /**
     * 百度地址查询服务
     * 
     * @param ip IP地址
     * @return IpLocation
     * @throws Exception
     */
    private IpLocation getLocationFromBaidu(String ip) throws Exception {
        String result = HttpUtils.sendHttpPost(baiduServiceUrl + ip);
        logger.info(result);
        if (StringUtils.isNotEmpty(result)) {
            JSONObject jsonObject = JSONObject.fromObject(result);
            String status = jsonObject.getString("status");
            if ("0".equals(status)) {
                JSONObject contentObject = jsonObject.getJSONObject("content");
                JSONObject addressDetailObject = contentObject.getJSONObject("address_detail");
                String province = addressDetailObject.getString("province");
                String city = addressDetailObject.getString("city");
                if (StringUtils.isEmpty(province)) {
                	province = UNKNOWN;
                } else {
                    province = province.replaceAll("-", "");
                }
                if (StringUtils.isEmpty(city)) {
                    city = UNKNOWN;
                }
                return new IpLocation(ip, province, city);
            }
        }
        return null;
    }
    
    /**
     * 淘宝地址查询服务
     * 
     * @param ip IP地址
     * @return IpLocation
     * @throws Exception
     */
    private IpLocation getLocationFromTaobao(String ip) throws Exception {
        String result = HttpUtils.sendHttpPost(taobaoServiceUrl + ip);
        logger.info(result);
        if (StringUtils.isNotEmpty(result)) {
        	JSONObject jsonObject = JSONObject.fromObject(result);
        	String code = jsonObject.getString("code");
        	if ("0".equals(code)) {
        		JSONObject dataObject = jsonObject.getJSONObject("data");
        		String country = dataObject.getString("country");
        		String province = dataObject.getString("region");
                String city = dataObject.getString("city");
                String operator = dataObject.getString("isp");
                if (StringUtils.isEmpty(country)) {
                	country = UNKNOWN;
                }
                if (StringUtils.isEmpty(province)) {
                    province = UNKNOWN;
                }
                if (StringUtils.isEmpty(city)) {
                    city = UNKNOWN;
                }
                if (StringUtils.isEmpty(operator)) {
                	operator = UNKNOWN;
                }
                return new IpLocation(ip, country, province, city, operator);
        	}
        }
        return null;
    }
    
    /**
     * 网易地址查询服务
     * 
     * @param ip IP地址
     * @return IpLocation
     * @throws Exception
     */
    private IpLocation getLocationFromNe126(String ip) throws Exception {
    	String result = HttpUtils.sendHttpGet(ne126ServiceUrl + ip);
    	logger.info(result);
        if (StringUtils.isNotEmpty(result)) {
        	int beginIndex = result.indexOf("{");
        	if (beginIndex != -1) {
        		String jsonStr = result.substring(beginIndex);
        		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        		String province = jsonObject.getString("province");
                String city = jsonObject.getString("city");
                if (StringUtils.isEmpty(province)) {
                    province = UNKNOWN;
                }
                if (StringUtils.isEmpty(city)) {
                    city = UNKNOWN;
                }
                return new IpLocation(ip, province, city);
        	}
        }
		return null;
    }
	
	/**
     * 判断是否内网IP
     * 以下几个网段的IP为内网IP
     * 10.0.0.0~10.255.255.255
     * 172.16.0.0~172.31.255.255
     * 192.168.0.0~192.168.255.255
     * 
     * @param ip
     * @return boolean
     */
    private boolean isInner(String ip) {
    	if ("0:0:0:0:0:0:0:1".equals(ip)) return true;
        String reg = "(10|127|192)\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})";
        Pattern p = Pattern.compile(reg);
        Matcher matcher = p.matcher(ip);
        return matcher.find();
    }
    
	@Override
	public Ip getByIp(String ip) {
		return ipMapper.getByIp(ip);
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.IP;
    }

    @Override
    protected BaseMapper<Ip> getMapper() {
        return ipMapper;
    }

}
