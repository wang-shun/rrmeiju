package com.caizhukui.rrmeiju.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.common.service.SmsService;
import com.caizhukui.rrmeiju.service.thirdparty.DoubanService;
import com.caizhukui.rrmeiju.service.thirdparty.EpguidesService;
import com.caizhukui.rrmeiju.service.thirdparty.TvmazeService;

import lombok.Data;

/**
 * 服务门面类
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
@Data
@Service
public class ServiceFacade {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserOauthService userOauthService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private TelevisionService televisionService;
	
	@Autowired
    private SerialService serialService;
	
	@Autowired
	private SeasonService seasonService;
	
	@Autowired
	private EpisodeService episodeService;
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private SubtitleService subtitleService;
	
	@Autowired
	private SubtitleFileService subtitleFileService;
	
	@Autowired
	private SubtitleDownloadService subtitleDownloadService;
	
	@Autowired
	private FansubService fansubService;
	
	@Autowired
	private IndexSearchRecordService indexSearchRecordService;
	
	@Autowired
	private SmsSendRecordService smsSendRecordService;
	
	@Autowired
	private UserLoginRecordService userLoginRecordService;
	
	@Autowired
	private UserRegisterRecordService userRegisterRecordService;
	
	@Autowired
	private MetaDataService metaDataService;
	
	@Autowired
	private FileService uploadFileService;
	
	@Resource
	private SmsService aliyunSmsService;
	
	@Autowired
	private IdxBgPicService idxBgPicService;
	
	@Autowired
	private DoubanService doubanService;
	
	@Autowired
    private TvmazeService tvmazeService;
	
	@Autowired
    private EpguidesService epguidesService;
	
	@Autowired
	private IpBlacklistService ipBlacklistService;
	
	@Autowired
    private UserSerialService userSerialService;
	
	@Autowired
	private SequenceService sequenceService;

}
