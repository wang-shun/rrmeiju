package com.caizhukui.rrmeiju.task;

import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.model.Fansub;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.model.Subtitle;
import com.caizhukui.rrmeiju.model.Television;
import com.caizhukui.rrmeiju.redis.RedisService;
import com.caizhukui.rrmeiju.redis.consts.RedisConstant;
import com.caizhukui.rrmeiju.service.ServiceFacade;

/**
 * 定时把数据库的数据同步到Redis
 * 
 * @author caizhukui
 * @date 2017年7月25日
 */
//@Component
public class SyncRedisTask implements ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(SyncRedisTask.class);
	
	@Autowired
	private RedisService redisService;
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	/**
	 * 将电视台信息从数据库同步到Redis
	 * 
	 * @author caizhukui
	 * @date 2017年7月25日
	 */
	@Scheduled(fixedDelayString = "${fixedDelay.syncRedis}", initialDelayString = "${initialDelay.syncRedis}")
	public void syncTelevision() {
		Set<String> hashKeys = redisService.getAllHashKeys(RedisConstant.TELEVISION_KEY);
		if (CollectionUtils.isEmpty(hashKeys)) return;
		for (String hashKey : hashKeys) {
			Television television = serviceFacade.getTelevisionService().getByUuid(hashKey);
			if (television != null) {
				redisService.put(RedisConstant.TELEVISION_KEY, hashKey, television);
			} else { // 数据库已删除
				redisService.delete(RedisConstant.TELEVISION_KEY, hashKey);
			}
		}
	}
	
	/**
	 * 将系列信息从数据库同步到Redis
	 * 
	 * @author caizhukui
	 * @date 2017年7月25日
	 */
	@Scheduled(fixedDelayString = "${fixedDelay.syncRedis}", initialDelayString = "${initialDelay.syncRedis}")
	public void syncSerial() {
		Set<String> hashKeys = redisService.getAllHashKeys(RedisConstant.SERIAL_KEY);
		if (CollectionUtils.isEmpty(hashKeys)) return;
		for (String hashKey : hashKeys) {
			Serial serial = serviceFacade.getSerialService().getByUuid(hashKey);
			if (serial != null) {
				redisService.put(RedisConstant.SERIAL_KEY, hashKey, serial);
			} else { // 数据库已删除
				redisService.delete(RedisConstant.SERIAL_KEY, hashKey);
			}
		}
	}
	
	/**
	 * 将季度信息从数据库同步到Redis
	 * 
	 * @author caizhukui
	 * @date 2017年7月25日
	 */
	@Scheduled(fixedDelayString = "${fixedDelay.syncRedis}", initialDelayString = "${initialDelay.syncRedis}")
	public void syncSeason() {
		Set<String> hashKeys = redisService.getAllHashKeys(RedisConstant.SEASON_KEY);
		if (CollectionUtils.isEmpty(hashKeys)) return;
		for (String hashKey : hashKeys) {
			logger.debug("syncSeason - hashKey = {}", hashKey);
			Season season = serviceFacade.getSeasonService().getByUuid(hashKey);
			if (season != null) {
				redisService.put(RedisConstant.SEASON_KEY, hashKey, season);
			} else { // 数据库已删除
				redisService.delete(RedisConstant.SEASON_KEY, hashKey);
			}
		}
	}
	
	/**
	 * 将集信息从数据库同步到Redis
	 * 
	 * @author caizhukui
	 * @date 2017年7月25日
	 */
	@Scheduled(fixedDelayString = "${fixedDelay.syncRedis}", initialDelayString = "${initialDelay.syncRedis}")
	public void syncEpisode() {
		Set<String> hashKeys = redisService.getAllHashKeys(RedisConstant.EPISODE_KEY);
		if (CollectionUtils.isEmpty(hashKeys)) return;
		for (String hashKey : hashKeys) {
			Episode episode = serviceFacade.getEpisodeService().getByUuid(hashKey);
			if (episode != null) {
				redisService.put(RedisConstant.EPISODE_KEY, hashKey, episode);
			} else { // 数据库已删除
				redisService.delete(RedisConstant.EPISODE_KEY, hashKey);
			}
		}
	}
	
	/**
	 * 将字幕信息从数据库同步到Redis
	 * 
	 * @author caizhukui
	 * @date 2017年7月25日
	 */
	@Scheduled(fixedDelayString = "${fixedDelay.syncRedis}", initialDelayString = "${initialDelay.syncRedis}")
	public void syncSubtitle() {
		Set<String> hashKeys = redisService.getAllHashKeys(RedisConstant.SUBTITLE_KEY);
		if (CollectionUtils.isEmpty(hashKeys)) return;
		for (String hashKey : hashKeys) {
			Subtitle subtitle = serviceFacade.getSubtitleService().getByUuid(hashKey);
			if (subtitle != null) {
				redisService.put(RedisConstant.SUBTITLE_KEY, hashKey, subtitle);
			} else { // 数据库已删除
				redisService.delete(RedisConstant.SUBTITLE_KEY, hashKey);
			}
		}
	}
	
	/**
	 * 将字幕组信息从数据库同步到Redis
	 * 
	 * @author caizhukui
	 * @date 2017年7月25日
	 */
	@Scheduled(fixedDelayString = "${fixedDelay.syncRedis}", initialDelayString = "${initialDelay.syncRedis}")
	public void syncFansub() {
		Set<String> hashKeys = redisService.getAllHashKeys(RedisConstant.FANSUB_KEY);
		if (CollectionUtils.isEmpty(hashKeys)) return;
		for (String hashKey : hashKeys) {
			Fansub fansub = serviceFacade.getFansubService().getByUuid(hashKey);
			if (fansub != null) {
				redisService.put(RedisConstant.FANSUB_KEY, hashKey, fansub);
			} else { // 数据库已删除
				redisService.delete(RedisConstant.FANSUB_KEY, hashKey);
			}
		}
	}

}
