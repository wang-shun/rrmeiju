package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caizhukui.rrmeiju.dto.response.BooleanDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;

/**
 * 数据库元数据控制类
 * 
 * @author caizhukui
 * @date 2017年1月23日
 */
@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_UTF8_VALUE)
public class MetaDataController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(MetaDataController.class);
	
	/**
	 * 刷新所有数据表元数据缓存
	 * 
	 * @return BooleanDTO 刷新缓存结果
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/metadata", method = GET)
	public BooleanDTO refreshMetaDataCache() {
		logger.info("刷新所有数据表元数据缓存 ...");
		for (TableEnum tableEnum : TableEnum.values()) {
		    serviceFacade.getMetaDataService().refreshFieldsOfTable(tableEnum);
		    serviceFacade.getMetaDataService().refreshCommaSeparatedFieldsOfTable(tableEnum);
		}
		logger.info("刷新所有数据表元数据缓存完成");
		return new BooleanDTO(true);
	}
	
	/**
	 * 刷新电视台的数据表元数据缓存
	 * 
	 * @return BooleanDTO 刷新缓存结果
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/metadata/television", method = GET)
	public BooleanDTO refreshTelevisionCache() {
		logger.info("刷新电视台的数据表元数据缓存 ...");
		serviceFacade.getMetaDataService().refreshFieldsOfTable(TableEnum.TELEVISION);
		serviceFacade.getMetaDataService().refreshCommaSeparatedFieldsOfTable(TableEnum.TELEVISION);
		logger.info("刷新电视台的数据表元数据缓存完成");
		return new BooleanDTO(true);
	}
	
	/**
	 * 刷新serial的MetaData缓存
	 * 
	 * @return BooleanDTO 刷新缓存结果
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/metadata/serial", method = GET)
	public BooleanDTO refreshSerialCache() {
		logger.info("刷新serial的MetaData缓存 ...");
		serviceFacade.getMetaDataService().refreshFieldsOfTable(TableEnum.SERIAL);
		serviceFacade.getMetaDataService().refreshCommaSeparatedFieldsOfTable(TableEnum.SERIAL);
		logger.info("刷新serial的MetaData缓存完成");
		return new BooleanDTO(true);
	}
	
	/**
	 * 刷新season的MetaData缓存
	 * 
	 * @return BooleanDto 刷新缓存结果
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/metadata/season", method = GET)
	public BooleanDTO refreshSeasonCache() {
		logger.info("刷新season的MetaData缓存 ...");
		serviceFacade.getMetaDataService().refreshFieldsOfTable(TableEnum.SEASON);
		serviceFacade.getMetaDataService().refreshCommaSeparatedFieldsOfTable(TableEnum.SEASON);
		logger.info("刷新season的MetaData缓存完成");
		return new BooleanDTO(true);
	}
	
	/**
	 * 刷新episode的MetaData缓存
	 * 
	 * @return BooleanDTO 刷新缓存结果
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/metadata/episode", method = GET)
	public BooleanDTO refreshEpisodeCache() {
		logger.info("刷新episode的MetaData缓存 ...");
		serviceFacade.getMetaDataService().refreshFieldsOfTable(TableEnum.EPISODE);
		serviceFacade.getMetaDataService().refreshCommaSeparatedFieldsOfTable(TableEnum.EPISODE);
		logger.info("刷新episode的MetaData缓存完成");
		return new BooleanDTO(true);
	}
	
	/**
	 * 刷新subtitle的MetaData缓存
	 * 
	 * @return BooleanDTO 刷新缓存结果
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/metadata/subtitle", method = GET)
	public BooleanDTO refreshSubtitleCache() {
		logger.info("刷新subtitle的MetaData缓存 ...");
		serviceFacade.getMetaDataService().refreshFieldsOfTable(TableEnum.SUBTITLE);
		serviceFacade.getMetaDataService().refreshCommaSeparatedFieldsOfTable(TableEnum.SUBTITLE);
		logger.info("刷新subtitle的MetaData缓存完成");
		return new BooleanDTO(true);
	}
	
	/**
	 * 刷新video的MetaData缓存
	 * 
	 * @return BooleanDTO 刷新缓存结果
	 * @author caizhukui
	 * @date 2017年8月2日
	 */
	@RequestMapping(value = "/metadata/video", method = GET)
	public BooleanDTO refreshVideoCache() {
		logger.info("刷新video的MetaData缓存 ...");
		serviceFacade.getMetaDataService().refreshFieldsOfTable(TableEnum.VIDEO);
		serviceFacade.getMetaDataService().refreshCommaSeparatedFieldsOfTable(TableEnum.VIDEO);
		logger.info("刷新video的MetaData缓存完成");
		return new BooleanDTO(true);
	}
	
	/**
	 * 刷新fansub的MetaData缓存
	 * 
	 * @return BooleanDTO 刷新缓存结果
	 * @author caizhukui
	 * @date 2017年1月25日
	 */
	@RequestMapping(value = "/metadata/fansub", method = GET)
	public BooleanDTO refreshFansubCache() {
		logger.info("刷新fansub的MetaData缓存 ...");
		serviceFacade.getMetaDataService().refreshFieldsOfTable(TableEnum.FANSUB);
		serviceFacade.getMetaDataService().refreshCommaSeparatedFieldsOfTable(TableEnum.FANSUB);
		logger.info("刷新fansub的MetaData缓存完成");
		return new BooleanDTO(true);
	}
	
	/**
	 * 刷新user的MetaData缓存
	 * 
	 * @return BooleanDTO 刷新缓存结果
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/metadata/user", method = GET)
	public BooleanDTO refreshUserCache() {
		logger.info("刷新user的MetaData缓存 ...");
		serviceFacade.getMetaDataService().refreshFieldsOfTable(TableEnum.USER);
		serviceFacade.getMetaDataService().refreshCommaSeparatedFieldsOfTable(TableEnum.USER);
		logger.info("刷新user的MetaData缓存完成");
		return new BooleanDTO(true);
	}

    @Override
    protected String getName() {
        // TODO Auto-generated method stub
        return null;
    }

}
