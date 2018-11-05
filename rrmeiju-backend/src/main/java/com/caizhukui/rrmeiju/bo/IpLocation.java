package com.caizhukui.rrmeiju.bo;

import java.io.Serializable;

import com.caizhukui.rrmeiju.model.Ip;

import lombok.Data;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月21日上午9:55:38
 */
@Data
public class IpLocation implements Serializable {

	private static final long serialVersionUID = -2077377647749557420L;
	
	/** 未知 */
	private static final String UNKNOWN = "未知";
	
	/** IP地址 */
	private String ip;
	
	/** 所属国家 */
	private String country;
	
	/** 所属省份 */
    private String province;
	
	/** 所属城市 */
    private String city;
    
    /** 运营商 */
    private String operator;
    
    public IpLocation(String ip) {
		this.ip = ip;
		this.country = UNKNOWN;
		this.province = UNKNOWN;
        this.city = UNKNOWN;
        this.operator = UNKNOWN;
	}
    
    public IpLocation(String ip, String province, String city) {
        this.ip = ip;
        this.country = UNKNOWN;
        this.setProvince(province);
        this.setCity(city);
        this.operator = UNKNOWN;
    }
    
    public IpLocation(String ip, String country, String province, String city) {
        this.ip = ip;
        this.country = country;
        this.setProvince(province);
        this.setCity(city);
        this.operator = UNKNOWN;
    }
	
	public IpLocation(String ip, String country, String province, String city, String operator) {
        this.ip = ip;
        this.country = country;
        this.setProvince(province);
        this.setCity(city);
        this.operator = operator;
    }
	
	/**
	 * 
	 * 
	 * @return boolean
	 * @author caizhukui
	 * @date 2017年7月21日下午5:36:18
	 */
	public boolean isUnknown() {
		return UNKNOWN.equals(this.country) && UNKNOWN.equals(this.province) && UNKNOWN.equals(this.city);
	}
	
	/**
	 * 
	 * 
	 * @return boolean
	 * @author caizhukui
	 * @date 2017年7月21日下午5:38:22
	 */
	public boolean isKnown() {
		return !isUnknown();
	}
	
	/**
	 * 
	 * 
	 * @param province
	 * @author caizhukui
	 * @date 2017年7月21日下午6:19:50
	 */
	public void setProvince(String province) {
		final String provinceSuffix = "省";
		if (province.endsWith(provinceSuffix)) {
			province = province.substring(0, province.length() - provinceSuffix.length());
		}
		this.province = province;
	}
	
	/**
	 * 
	 * 
	 * @param city
	 * @author caizhukui
	 * @date 2017年7月21日下午6:21:29
	 */
	public void setCity(String city) {
		final String citySuffix = "市";
		if (city.endsWith(citySuffix)) {
			city = city.substring(0, city.length() - citySuffix.length());
		}
		this.city = city;
	}
	
	/**
	 * 
	 * 
	 * @return Ip
	 * @author caizhukui
	 * @date 2017年7月25日下午3:30:09
	 */
	public Ip convert() {
		Ip ip = new Ip();
		ip.setIp(this.ip);
		ip.setCountry(this.country);
		ip.setProvince(this.province);
		ip.setCity(this.city);
		ip.setOperator(this.operator);
		return ip;
	}

}
