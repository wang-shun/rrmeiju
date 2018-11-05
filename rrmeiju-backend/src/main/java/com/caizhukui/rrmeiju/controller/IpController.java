package com.caizhukui.rrmeiju.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caizhukui.rrmeiju.bo.IpLocation;
import com.caizhukui.rrmeiju.dto.IpBlacklistDTO;
import com.caizhukui.rrmeiju.dto.IpLocationDTO;
import com.caizhukui.rrmeiju.model.IpBlacklist;

/**
 * IP控制类
 * 
 * @author caizhukui
 * @date 2017年3月21日
 */
@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IpController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(IpController.class);
	
	/**
	 * 根据IP地址查询地理位置
	 * 
	 * @param ip IP地址
	 * @return IpLocationDto
	 * @author caizhukui
	 * @date 2017年3月21日下午2:17:09
	 */
	@RequestMapping(value = "/ips/{ip:.+}", method = RequestMethod.GET)
	public IpLocationDTO get(@PathVariable String ip) {
		logger.info("get - ip = {}", ip);
		IpLocation ipLocation = commonServiceFacade.getIpService().getLocationByIp(ip);
		return convertIpLocation(ipLocation);
	}
	
	/**
	 * 查询所有被加入黑名单的IP地址
	 * 
	 * @return List<IpBlacklistDto>
	 * @author caizhukui
	 * @date 2017年6月14日下午8:31:51
	 */
	@RequestMapping(value = "/ips/blacklist", method = RequestMethod.GET)
	public List<IpBlacklistDTO> getAll() {
		List<IpBlacklist> ips = serviceFacade.getIpBlacklistService().getAll();
		return convertIpBlacklist(ips);
	}
	
	/**
	 * 把IpBlacklist从Model转换成DTO
	 * 
	 * @param ipBlacklist
	 * @return IpBlacklistDto
	 * @author caizhukui
	 * @date 2017年6月14日下午8:29:30
	 */
	private IpBlacklistDTO convertIpBlacklist(IpBlacklist ipBlacklist) {
		IpBlacklistDTO ipBlacklistDto = new IpBlacklistDTO();
		ipBlacklistDto.setIpId(ipBlacklist.getIpId());
		ipBlacklistDto.setIp(ipBlacklist.getIp());
		return ipBlacklistDto;
	}
	
	/**
	 * 把IpBlacklist从Model转换成DTO
	 * 
	 * @param ipBlacklists
	 * @return List<IpBlacklistDto> 
	 * @author caizhukui
	 * @date 2017年6月14日下午8:31:39
	 */
	private List<IpBlacklistDTO> convertIpBlacklist(List<IpBlacklist> ipBlacklists) {
		List<IpBlacklistDTO> ipBlacklistDtos = new ArrayList<IpBlacklistDTO>();
		for (IpBlacklist ipBlacklist : ipBlacklists) {
			ipBlacklistDtos.add(convertIpBlacklist(ipBlacklist));
		}
		return ipBlacklistDtos;
	}
	
	/**
	 * 把IpLocation从Model转换成DTO
	 * 
	 * @param ipLocation
	 * @return IpLocationDto
	 * @author caizhukui
	 * @date 2017年3月21日下午2:22:26
	 */
	private IpLocationDTO convertIpLocation(IpLocation ipLocation) {
		IpLocationDTO ipLocationDto = new IpLocationDTO();
		ipLocationDto.setIp(ipLocation.getIp());
		ipLocationDto.setCity(ipLocation.getCity());
		ipLocationDto.setProvince(ipLocation.getProvince());
		return ipLocationDto;
	}

    @Override
    protected String getName() {
        // TODO Auto-generated method stub
        return null;
    }

}
