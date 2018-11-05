package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.IpDTO;
import com.caizhukui.rrmeiju.model.Ip;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年6月11日
 */
@Component
public class IpConvert implements Convert<Ip, IpDTO> {

    @Override
    public IpDTO model2Dto(Ip model) {
        IpDTO dto = null;
        if (model != null) {
            dto = new IpDTO();
            dto.setIpId(model.getUuid());
            dto.setIp(model.getIp());
            String country = model.getCountry();
            if (country == null) {
                country = "未知";
            }
            dto.setCountry(country);
            String province = model.getProvince();
            if (province == null) {
                province = "未知";
            }
            dto.setProvince(province);
            String city = model.getCity();
            if (city == null) {
                city = "未知";
            }
            dto.setCity(city);
            String operator = model.getOperator();
            if (operator == null) {
                operator = "未知";
            }
            dto.setOperator(operator);
        }
        return dto;
    }

    @Override
    public Ip dto2Model(IpDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
