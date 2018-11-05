package com.caizhukui.rrmeiju.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.MobileLocaleMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.MobileLocale;
import com.caizhukui.rrmeiju.service.MobileLocaleService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年7月3日
 */
@Service
public class MobileLocaleServiceImpl extends BaseServiceImpl<MobileLocale> implements MobileLocaleService {
	
	private static final Logger logger = LoggerFactory.getLogger(MobileLocaleServiceImpl.class);
	
	@Autowired
	private MobileLocaleMapper mobileLocaleMapper;
	
	@Override
    protected MobileLocale preProcess(MobileLocale mobileLocale) {
        // 根据mobileArea生成province和city
        String province = "", city = "";
        String mobileArea = mobileLocale.getMobileArea();
        if (StringUtils.isNotEmpty(mobileArea)) {
            int index = mobileArea.indexOf(" ");
            if (index > 0) {
                province = mobileArea.substring(0, index);
                city = mobileArea.substring(index + 1, mobileArea.length());
                if (city.endsWith("市")) {
                    city = city.substring(0, city.length() - 1);
                } else if (city.endsWith("地区")) {
                    city = city.substring(0, city.length() - 2);
                }
            } else {
                province = city = mobileArea;
            }
        }
        mobileLocale.setProvince(province);
        mobileLocale.setCity(city);
        // 根据mobileType生成operator
        String operator = "";
        String mobileType = mobileLocale.getMobileType();
        if (StringUtils.isNotEmpty(mobileType)) {
            if (mobileType.indexOf("电信") >= 0) {
                operator = "电信";
            } else if (mobileType.indexOf("移动") >= 0) {
                operator = "移动";
            } else if (mobileType.indexOf("联通") >= 0) {
                operator = "联通";
            }
        }
        mobileLocale.setOperator(operator);
        return mobileLocale;
    }
	
    @Override
    protected TableEnum getTable() {
        return TableEnum.MOBILE_LOCALE;
    }

    @Override
    protected BaseMapper<MobileLocale> getMapper() {
        return mobileLocaleMapper;
    }

}
