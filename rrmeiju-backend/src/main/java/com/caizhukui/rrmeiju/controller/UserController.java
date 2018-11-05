package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.util.UriComponentsBuilder;

import com.caizhukui.common.util.EmailUtils;
import com.caizhukui.common.util.MobileUtils;
import com.caizhukui.common.util.StringUtils;
import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.bo.CriteriaBO;
import com.caizhukui.rrmeiju.consts.UserRegisterSource;
import com.caizhukui.rrmeiju.dto.CriteriaDTO;
import com.caizhukui.rrmeiju.dto.UserDTO;
import com.caizhukui.rrmeiju.dto.UserOauthDTO;
import com.caizhukui.rrmeiju.dto.response.BooleanDTO;
import com.caizhukui.rrmeiju.dto.response.Pagination;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.user.UserPaginatedDTO;
import com.caizhukui.rrmeiju.dto.response.user.UserStatDTO;
import com.caizhukui.rrmeiju.dto.response.user.UserStatPaginatedDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.User;
import com.caizhukui.rrmeiju.model.UserOauth;
import com.caizhukui.rrmeiju.model.UserRegisterRecord;
import com.caizhukui.rrmeiju.redis.RedisService;

/**
 * 用户控制器类
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
@RestController
@RequestMapping(value = "/v1", produces = { APPLICATION_JSON_UTF8_VALUE, APPLICATION_XML_VALUE })
public class UserController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private RedisService redisService;
	
	/**
	 * 发送用户注册验证码（未使用）
	 * 
	 * @param mobileNumber 手机号
	 * @author caizhukui
	 * @date 2017年6月7日
	 */
	@RequestMapping(value = "/users/captcha/register", method = GET)
	public void sendRegisterSms(@RequestParam String mobileNumber) {
		logger.info("sendRegisterSms - mobileNumber = {}", mobileNumber);
		
		RedirectAttributes attr = new RedirectAttributesModelMap();
	}
	
	/**
	 * 根据用户ID和第三方OAuth来源查询OAuth记录
	 * 
	 * @param userId 用户ID
	 * @param source 第三方OAuth来源
	 * @return UserOauthDTO
	 * @author caizhukui
	 * @date 2017年6月30日
	 */
	@RequestMapping(value = "/users/{userId}/oauth", method = GET)
	public UserOauthDTO getOauthByUserIdAndSource(@PathVariable String userId, @RequestParam String source) {
		logger.info("getOauthByUserIdAndSource - userId = {}, source = {}", userId, source);
		UserOauth userOauth = new UserOauth();
		try {
			userOauth = serviceFacade.getUserOauthService().getByUserUuidAndSource(userId, Integer.valueOf(source));
		} catch (NumberFormatException e) {
			logger.error("数值转换错误 - {}", e.getMessage());
			throw new RestControllerException(RestError.PARAMETER_ERROR.setMessage("第三方OAuth来源错"));
		}
		return convertUserOauth(userOauth);
	}
	
	/**
	 * 
	 * 
	 * @param criteriaDTO
	 * @return UserStatPaginatedDTO
	 * @author caizhukui
	 * @date 2017年5月10日
	 */
	@RequestMapping(value = "/users/stat", method = GET)
	public UserStatPaginatedDTO getUserStats(CriteriaDTO criteriaDTO) {
		logger.info("getUserStats - criteriaDTO = {}", criteriaDTO);
		checkCriteria(criteriaDTO, TableEnum.USER);
		CriteriaBO criteriaBO = convertCriteria(criteriaDTO, TableEnum.USER);
		List<User> users = serviceFacade.getUserService().get(criteriaBO);
		UserStatPaginatedDTO userStatPaginatedDTO = new UserStatPaginatedDTO();
		List<UserStatDTO> userStatDTOs = convertUserStat(users);
		// 根据上传字幕数倒序排序
		Collections.sort(userStatDTOs);
		userStatPaginatedDTO.setUserStats(userStatDTOs);
		int userCount = serviceFacade.getUserService().getCount(criteriaBO);
    	Pagination pagination = new Pagination(userCount, criteriaDTO.getPageSize(), criteriaDTO.getPageIndex());
    	userStatPaginatedDTO.setPagination(pagination);
		return userStatPaginatedDTO;
	}
	
	/**
	 * 分页查询用户
	 * 
	 * @return UserPaginatedDTO
	 * @author caizhukui
	 * @date 2016年10月27日
	 */
	@RequestMapping(value = "/users", method = GET)
	public UserPaginatedDTO get(CriteriaDTO criteriaDTO) {
		logger.info("get - criteriaDTO = {}", criteriaDTO);
		checkCriteria(criteriaDTO, TableEnum.USER);
		CriteriaBO criteriaBO = convertCriteria(criteriaDTO, TableEnum.USER);
		List<User> users = serviceFacade.getUserService().get(criteriaBO);
		UserPaginatedDTO userPaginatedDTO = new UserPaginatedDTO();
		userPaginatedDTO.setUsers(convertUser(users));
    	int userCount = serviceFacade.getUserService().getCount(criteriaBO);
    	Pagination pagination = new Pagination(userCount, criteriaDTO.getPageSize(), criteriaDTO.getPageIndex());
    	userPaginatedDTO.setPagination(pagination);
    	return userPaginatedDTO;
	}
	
	/**
	 * 根据UUID查询用户
	 * 
	 * @param uuid 用户UUID
	 * @return UserDto
	 * @author caizhukui
	 * @date 2016年10月27日
	 */
	@RequestMapping(value = "/users/{uuid}", method = GET)
	public UserDTO getByUserUuid(@PathVariable String uuid) {
		logger.info("getByUserUuid - uuid = {}", uuid);
		User user = serviceFacade.getUserService().getByUuid(uuid);
		if (user == null) {
			logger.info("User with id {} does not exist.", uuid);
			String developerMessage = "User with id " + uuid + " does not exist.";
			throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setDetail(developerMessage));
		}
		return convertUser(user);
	}
	
	/**
	 * 根据用户名查询用户信息（仅供SpringSecurity登录调用）
	 * 
	 * @param userName 用户名
	 * @param remoteIp 客户端IP地址
	 * @return UserDto 带有密码的用户信息
	 * @author caizhukui
	 * @date 2016年10月28日
	 */
	@RequestMapping(value = "/users", method = GET, params = {"userName", "remoteIp"})
	public UserDTO getByUserName(@RequestParam String userName, @RequestParam String remoteIp) {
		logger.info("getByUserName - userName = {}, remoteIp = {}", userName, remoteIp);
		// 异步新增用户登录记录
		serviceFacade.getUserLoginRecordService().addByUserName(userName, remoteIp);
		// 查询用户基本信息
		User user = serviceFacade.getUserService().getByUserName(userName);
		if (user == null) {
			logger.info("Unable to find user with name '{}'", userName);
			throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setMessage("该用户不存在"));
		}
		UserDTO userDto = convertUser(user);
		// 登录场景需要用户密码
		userDto.setPassword(user.getPassword());
		// 查询用户角色信息
		List<String> roleNames = serviceFacade.getRoleService().getRoleNamesByUserName(userName);
		userDto.setRoleNames(roleNames);
		return userDto;
	}
	
	/**
	 * 根据手机号查询用户信息（仅供SpringSecurity登录调用）
	 * 
	 * @param mobileNumber 手机号
	 * @param remoteIp 客户端IP地址
	 * @return UserDto 带有密码的用户信息
	 * @author caizhukui
	 * @date 2017年6月10日
	 */
	@RequestMapping(value = "/users", method = GET, params = {"mobileNumber", "remoteIp"})
	public UserDTO getByMobileNumber(@RequestParam String mobileNumber, @RequestParam String remoteIp) {
		logger.info("getByMobileNumber - mobileNumber = {}, remoteIp = {}", mobileNumber, remoteIp);
		// 异步新增用户登录记录
		serviceFacade.getUserLoginRecordService().addByMobileNumber(mobileNumber, remoteIp);
		// 校验手机号格式
		if (!MobileUtils.isValidMobile(mobileNumber)) {
			throw new RestControllerException(RestError.PARAMETER_ERROR.setMessage("手机号格式错误"));
		}
		// 查询用户基本信息
		User user = serviceFacade.getUserService().getByMobileNumber(mobileNumber);
		if (user == null) {
			logger.info("Unable to find user with mobile '{}'", mobileNumber);
			throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setMessage("该手机号未注册"));
		}
		UserDTO userDto = convertUser(user);
		// 登录场景需要用户密码
		userDto.setPassword(user.getPassword());
		// 查询用户角色信息
		String userName = user.getUserName();
		List<String> roleNames = serviceFacade.getRoleService().getRoleNamesByUserName(userName);
		userDto.setRoleNames(roleNames);
		return userDto;
	}
	
	/**
	 * 根据邮箱查询用户信息（仅供SpringSecurity登录调用）
	 * 
	 * @param email 邮箱
	 * @param remoteIp 客户端IP地址
	 * @return UserDto 带有密码的用户信息
	 * @author caizhukui
	 * @date 2017年6月10日
	 */
	@RequestMapping(value = "/users", method = GET, params = {"email", "remoteIp"})
	public UserDTO getByEmail(@RequestParam String email, @RequestParam String remoteIp) {
		logger.info("getByEmail - email = {}, remoteIp = {}", email, remoteIp);
		// 异步新增用户登录记录
		serviceFacade.getUserLoginRecordService().addByEmail(email, remoteIp);
		// 校验邮箱格式
		if (!EmailUtils.isValidEmail(email)) {
			throw new RestControllerException(RestError.PARAMETER_ERROR.setMessage("邮箱格式错误"));
		}
		// 查询用户基本信息
		User user = serviceFacade.getUserService().getByEmail(email);
		if (user == null) {
			logger.info("Unable to find user with email '{}'", email);
			throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setMessage("该邮箱未注册"));
		}
		UserDTO userDto = convertUser(user);
		// 登录场景需要用户密码
		userDto.setPassword(user.getPassword());
		// 查询用户角色信息
		String userName = user.getUserName();
		List<String> roleNames = serviceFacade.getRoleService().getRoleNamesByUserName(userName);
		userDto.setRoleNames(roleNames);
		return userDto;
	}
	
	/**
	 * 根据QQ的OpenID查询用户信息
	 * 
	 * @param qqOpenId QQ的OpenID
	 * @param remoteIp 客户端IP地址
	 * @return UserDto 用户信息
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	@RequestMapping(value = "/users", method = GET, params = {"qqOpenId", "remoteIp"})
	public UserDTO getByQqOpenId(@RequestParam String qqOpenId, @RequestParam String remoteIp) {
		logger.info("getByQqOpenId - qqOpenId = {}, remoteIp = {}", qqOpenId, remoteIp);
		// 异步新增用户登录记录
		serviceFacade.getUserLoginRecordService().addByQqOpenId(qqOpenId, remoteIp);
		// 查询用户基本信息
		User user = serviceFacade.getUserService().getByQqOpenId(qqOpenId);
		if (user == null) {
			user = new User();
			user.setQqOpenId(qqOpenId);
			user.setSource(UserRegisterSource.THIRD_PARTY_QQ);
			// 同步新增用户
			user = serviceFacade.getUserService().add(user);
		}
		// 使用OpenID登录不需要返回密码
		UserDTO userDto = convertUser(user);
		// 查询用户角色信息
		String userName = user.getUserName();
		List<String> roleNames = serviceFacade.getRoleService().getRoleNamesByUserName(userName);
		userDto.setRoleNames(roleNames);
		return userDto;
	}
	
	/**
	 * 根据微信的OpenID查询用户信息
	 * 
	 * @param weixinOpenId 微信的OpenID
	 * @param remoteIp 客户端IP地址
	 * @return UserDto 用户信息
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	@RequestMapping(value = "/users", method = GET, params = {"weixinOpenId", "remoteIp"})
	public UserDTO getByWeixinOpenId(@RequestParam String weixinOpenId, @RequestParam String remoteIp) {
		logger.info("getByWeixinOpenId - weixinOpenId = {}, remoteIp = {}", weixinOpenId, remoteIp);
		// 异步新增用户登录记录
		serviceFacade.getUserLoginRecordService().addByWeixinOpenId(weixinOpenId, remoteIp);
		// 查询用户基本信息
		User user = serviceFacade.getUserService().getByWeixinOpenId(weixinOpenId);
		if (user == null) {
			user = new User();
			user.setWeixinOpenId(weixinOpenId);
			user.setSource(UserRegisterSource.THIRD_PARTY_WEIXIN);
			// 同步新增用户
			user = serviceFacade.getUserService().add(user);
		}
		// 使用OpenID登录不需要返回密码
		UserDTO userDto = convertUser(user);
		// 查询用户角色信息
		String userName = user.getUserName();
		List<String> roleNames = serviceFacade.getRoleService().getRoleNamesByUserName(userName);
		userDto.setRoleNames(roleNames);
		return userDto;
	}

	/**
	 * 根据新浪微博的uid查询用户信息
	 * 
	 * @param weiboUid 新浪微博的uid
	 * @param remoteIp 客户端IP地址
	 * @return UserDto 用户信息
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	@RequestMapping(value = "/users", method = GET, params = {"weiboUid", "remoteIp"})
	public UserDTO getByWeiboUid(@RequestParam String weiboUid, @RequestParam String remoteIp) {
		logger.info("getByWeiboUid - weiboUid = {}, remoteIp = {}", weiboUid, remoteIp);
		// 异步新增用户登录记录
		serviceFacade.getUserLoginRecordService().addByWeiboUid(weiboUid, remoteIp);
		// 查询用户基本信息
		User user = serviceFacade.getUserService().getByWeiboUid(weiboUid);
		if (user == null) {
			throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setMessage("该新浪微博uid账号不存在"));
		}
		// 使用新浪微博uid登录不需要返回密码
		UserDTO userDto = convertUser(user);
		// 查询用户角色信息
		String userName = user.getUserName();
		List<String> roleNames = serviceFacade.getRoleService().getRoleNamesByUserName(userName);
		userDto.setRoleNames(roleNames);
		return userDto;
	}
	
	/**
	 * 根据百度的uid查询用户信息
	 * 
	 * @param baiduUid 百度的uid
	 * @param remoteIp 客户端IP地址
	 * @return UserDto 用户信息
	 * @author caizhukui
	 * @date 2017年7月6日
	 */
	@RequestMapping(value = "/users", method = GET, params = {"baiduUid", "remoteIp"})
	public UserDTO getByBaiduUid(@RequestParam String baiduUid, @RequestParam String remoteIp) {
		logger.info("getByBaiduUid - baiduUid = {}, remoteIp = {}", baiduUid, remoteIp);
		// 异步新增用户登录记录
		serviceFacade.getUserLoginRecordService().addByBaiduUid(baiduUid, remoteIp);
		// 查询用户基本信息
		User user = serviceFacade.getUserService().getByBaiduUid(baiduUid);
		if (user == null) {
			throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setMessage("该百度uid账号不存在"));
		}
		// 使用百度uid登录不需要返回密码
		UserDTO userDto = convertUser(user);
		// 查询用户角色信息
		String userName = user.getUserName();
		List<String> roleNames = serviceFacade.getRoleService().getRoleNamesByUserName(userName);
		userDto.setRoleNames(roleNames);
		return userDto;
	}
	
	/**
	 * 绑定QQ的OpenID
	 * 
	 * @param userId 用户ID
	 * @param qqOpenId QQ的OpenID
	 * @return BooleanDto
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	@RequestMapping(value = "/users/bind", method = GET, params = {"userId", "qqOpenId"})
	public BooleanDTO bindQqOpenId(@RequestParam String userId, @RequestParam String qqOpenId) {
		logger.info("bindQqOpenId - userId = {}, qqOpenId = {}", userId, qqOpenId);
		User user = serviceFacade.getUserService().getByUuid(userId);
		user.setQqOpenId(qqOpenId);
		serviceFacade.getUserService().updateByUuid(user);
		return new BooleanDTO(true);
	}
	
	/**
	 * 绑定微信的OpenID
	 * 
	 * @param userId 用户ID
	 * @param weixinOpenId 微信的OpenID
	 * @return BooleanDto
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	@RequestMapping(value = "/users/bind", method = GET, params = {"userId", "weixinOpenId"})
	public BooleanDTO bindWeixinOpenId(@RequestParam String userId, @RequestParam String weixinOpenId) {
		logger.info("bindWeixinOpenId - userId = {}, weixinOpenId = {}", userId, weixinOpenId);
		User user = serviceFacade.getUserService().getByUuid(userId);
		user.setWeixinOpenId(weixinOpenId);
		serviceFacade.getUserService().updateByUuid(user);
		return new BooleanDTO(true);
	}
	
	/**
	 * 绑定新浪微博的uid
	 * 
	 * @param userId 用户ID
	 * @param weiboUid 新浪微博的uid
	 * @return BooleanDto 绑定结果
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	@RequestMapping(value = "/users/bind", method = GET, params = {"userId", "weiboUid"})
	public BooleanDTO bindWeiboUid(@RequestParam String userId, @RequestParam String weiboUid) {
		logger.info("bindWeiboUid - userId = {}, weiboUid = {}", userId, weiboUid);
		User user = serviceFacade.getUserService().getByUuid(userId);
		user.setWeiboUid(weiboUid);
		serviceFacade.getUserService().updateByUuid(user);
		return new BooleanDTO(true);
	}
	
	/**
	 * 解绑QQ的OpenID
	 * 
	 * @param userId 用户ID
	 * @param qqOpenId QQ的OpenID
	 * @return BooleanDto
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	@RequestMapping(value = "/users/unbind", method = GET, params = {"userId", "qqOpenId"})
	public BooleanDTO unbindQqOpenId(@RequestParam String userId, @RequestParam String qqOpenId) {
		logger.info("unbindQqOpenId - userId = {}, qqOpenId = {}", userId, qqOpenId);
		User user = serviceFacade.getUserService().getByUuid(userId);
		if (StringUtils.equals(qqOpenId, user.getQqOpenId())) {
			user.setQqOpenId(null);
			serviceFacade.getUserService().updateByUuid(user);
		}
		return new BooleanDTO(true);
	}
	
	/**
	 * 解绑微信的OpenID
	 * 
	 * @param userId 用户ID
	 * @param weixinOpenId 微信的OpenID
	 * @return BooleanDto
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	@RequestMapping(value = "/users/unbind", method = GET, params = {"userId", "weixinOpenId"})
	public BooleanDTO unbindWeixinOpenId(@RequestParam String userId, @RequestParam String weixinOpenId) {
		logger.info("unbindWeixinOpenId - userId = {}, weixinOpenId = {}", userId, weixinOpenId);
		User user = serviceFacade.getUserService().getByUuid(userId);
		if (StringUtils.equals(weixinOpenId, user.getWeixinOpenId())) {
			user.setWeixinOpenId(null);
			serviceFacade.getUserService().updateByUuid(user);
		}
		return new BooleanDTO(true);
	}
	
	/**
	 * 解绑新浪微博的uid
	 * 
	 * @param userId 用户ID
	 * @param weiboUid 新浪微博的uid
	 * @return BooleanDto 解绑结果
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	@RequestMapping(value = "/users/unbind", method = GET, params = {"userId", "weiboUid"})
	public BooleanDTO unbindWeiboOpenId(@RequestParam String userId, @RequestParam String weiboUid) {
		logger.info("unbindWeiboOpenId - userId = {}, weiboUid = {}", userId, weiboUid);
		User user = serviceFacade.getUserService().getByUuid(userId);
		if (StringUtils.equals(weiboUid, user.getWeiboUid())) {
			user.setWeiboUid(null);
			serviceFacade.getUserService().updateByUuid(user);
		}
		return new BooleanDTO(true);
	}
	
	/**
	 * 新增用户
	 * 
	 * @param userDTO 待注册的用户信息
	 * @param remoteIp 客户端IP
	 * @param result
	 * @return UserDto 注册完成的用户信息
	 * @author caizhukui
	 * @date 2016年10月27日
	 */
	@RequestMapping(value = "/users", method = POST)
    public ResponseEntity<UserDTO> add(@Valid @RequestBody UserDTO userDTO, BindingResult result,
            @RequestParam String remoteIp, UriComponentsBuilder builder) {
        logger.info("add - userDTO = {}", userDTO);
		UserRegisterRecord record = convertUserRegisterRecord(userDTO, remoteIp);
		// 异步新增用户注册记录（只要有注册请求进来就记录，不管参数是否有效）
		serviceFacade.getUserRegisterRecordService().add(record);
		int count = serviceFacade.getUserRegisterRecordService().getTodayCountByRemoteIp(remoteIp);
		// 同一个IP一天最多调用注册接口100次（包含注册失败的请求）
		if (count > 100) {
			throw new RestControllerException(RestError.UNAUTHORIZED.setMessage("今日注册次数超上限"));
		}
		if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            List<String> errorMessages = convert(errors);
            logger.info(errorMessages.toString());
            throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setDetails(errorMessages));
		}
		boolean isFromThirdParty = UserRegisterSource.isFromThirdParty(userDTO.getSource());
		// 第三方注册时不需要校验手机号、验证码和用户名
		if (!isFromThirdParty) {
			String mobileNumber = userDTO.getMobileNumber();
			// 校验手机号格式
			if (!MobileUtils.isValidMobile(mobileNumber)) {
				throw new RestControllerException(RestError.PARAMETER_ERROR.setMessage("请输入正确的手机号"));
			}
			// 校验手机号
			if (mobileNumber != null && serviceFacade.getUserService().isMobileNumberExist(mobileNumber)) {
				logger.info("User with mobileNumber {} already exist.", mobileNumber);
				throw new RestControllerException(RestError.CONFLICT.setMessage("该手机号已被使用，请使用其它手机号注册"));
			}
			// 校验验证码
			String captcha = userDTO.getCaptcha();
			String savedCaptcha = (String) redisService.get(mobileNumber);
			// 用户未发送验证码或验证码已失效
			if (savedCaptcha == null) {
				logger.info("Captcha not exist.");
				throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setMessage("验证码已失效，请重新获取验证码"));
			}
			// 验证码错误
			if (!savedCaptcha.equals(captcha)) {
				logger.info("Captcha not match.");
				throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setMessage("验证码错误，请重新输入验证码"));
			}
			String userName = userDTO.getUserName();
			// 校验用户名格式
			if (!isValidUserName(userName)) {
				throw new RestControllerException(RestError.PARAMETER_ERROR.setMessage("用户名只能包含字母、数字、下划线和连字符，长度在6到10位之间"));
			}
			// 校验用户名
			if (serviceFacade.getUserService().isUserNameExist(userName)) {
				logger.info("User with userName {} already exists.", userName);
				throw new RestControllerException(RestError.CONFLICT.setMessage("该用户名已被使用，请使用其它用户名注册"));
			}
		}
		// 同步新增用户
		User user = serviceFacade.getUserService().add(convertUser(userDTO));
		// 系统启动时加载role表数据到内存
		userDTO = convertUser(user);
		// 第三方注册之后自动登录，需要用户角色信息
		if (isFromThirdParty) {
			// 查询用户角色信息
			String userName = user.getUserName();
			List<String> roleNames = serviceFacade.getRoleService().getRoleNamesByUserName(userName);
			userDTO.setRoleNames(roleNames);
		}
		HttpHeaders headers = new HttpHeaders();
		URI locationUri = builder.path("/users/{uuid}").buildAndExpand(user.getUuid()).toUri();
        headers.setLocation(locationUri);
        return new ResponseEntity<>(userDTO, headers, HttpStatus.CREATED);
	}
	
	/**
	 * 新增用户第三方OAuth授权
	 * 
	 * @param userOauthDTO
	 * @return UserOauthDTO
	 * @author caizhukui
	 * @date 2017年6月30日
	 */
	@RequestMapping(value = "/users/oauth", method = POST)
	public UserOauthDTO add(@RequestBody UserOauthDTO userOauthDTO) {
		logger.info("add - userOauthDTO = {}", userOauthDTO);
		UserOauth userOauth = serviceFacade.getUserOauthService().add(convertUserOauth(userOauthDTO));
		return convertUserOauth(userOauth);
	}
	
	/**
	 * 更新用户
	 * 
	 * @param userDTO
	 * @param result
	 * @author caizhukui
	 * @date 2016年10月28日
	 */
	@RequestMapping(value = "/users", method = PUT)
    public void update(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
		logger.info("update - userDTO = {}", userDTO);
		if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setDetails(convert(errors)));
		}
		// 异步更新
		serviceFacade.getUserService().updateByUuid(convertUser(userDTO));
	}
	
	/**
	 * 删除用户
	 * 
	 * @param userId 用户ID
	 * @author caizhukui
	 * @date 2016年10月28日
	 */
	@RequestMapping(value = "/users/{userId}", method = DELETE)
    public void deleteUser(@PathVariable String userId) {
        logger.info("delete - userId = {}", userId);
        boolean isExist = serviceFacade.getUserService().isUserUuidExist(userId);
        if (!isExist) {
        	logger.info("Unable to delete. User with id {} does not exist.", userId);
            throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setMessage(""));
        }
        // 异步删除
        serviceFacade.getUserService().deleteByUuid(userId);
	}
	
	/**
	 * 校验是否是有效的用户名
	 * 
	 * @param userName 用户名
	 * @return boolean 是否是有效的用户名
	 * @author caizhukui
	 * @date 2017年6月7日
	 */
	private boolean isValidUserName(String userName) {
		if (StringUtils.isBlank(userName)) return false;
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]{6,10}$");
		Matcher matcher = pattern.matcher(userName);
		return matcher.matches();
	}

	/**
	 * 把待注册的用户信息转换成用户注册记录
	 * 
	 * @param userDTO 待注册的用户信息
	 * @param remoteIp 客户端IP
	 * @return UserRegisterRecord 用户注册记录
	 * @author caizhukui
	 * @date 2017年6月8日
	 */
	private UserRegisterRecord convertUserRegisterRecord(UserDTO userDTO, String remoteIp) {
		UserRegisterRecord record = new UserRegisterRecord();
		record.setUuid(UuidUtils.getUuid());
		record.setUserName(userDTO.getUserName());
		record.setMobileNumber(userDTO.getMobileNumber());
		record.setQqOpenid(userDTO.getQqOpenId());
		record.setWeixinOpenid(userDTO.getWeixinOpenId());
		record.setWeiboUid(userDTO.getWeiboUid());
		record.setRemoteIp(remoteIp);
		return record;
	}
	
	/**
	 * 把UserOauth从Model转换成DTO
	 * 
	 * @param userOauth
	 * @return UserOauthDTO
	 * @author caizhukui
	 * @date 2017年6月30日
	 */
	private UserOauthDTO convertUserOauth(UserOauth userOauth) {
		UserOauthDTO userOauthDTO = new UserOauthDTO();
		userOauthDTO.setUserOauthId(userOauth.getUuid());
		userOauthDTO.setUserId(userOauth.getUserUuid());
		userOauthDTO.setAccessToken(userOauth.getAccessToken());
		userOauthDTO.setRefreshToken(userOauth.getRefreshToken());
		userOauthDTO.setExpiresIn(userOauth.getExpiresIn());
		userOauthDTO.setGrantTime(userOauth.getGrantTime());
		userOauthDTO.setExpireTime(userOauth.getExpireTime());
		userOauthDTO.setSource(userOauth.getSource());
		return userOauthDTO;
	}
	
	/**
	 * 把UserOauth从DTO转换成Model
	 * 
	 * @param userOauthDTO
	 * @return UserOauth
	 * @author caizhukui
	 * @date 2017年6月30日
	 */
	private UserOauth convertUserOauth(UserOauthDTO userOauthDTO) {
		UserOauth userOauth = new UserOauth();
		userOauth.setUuid(userOauthDTO.getUserOauthId());
		userOauth.setUserUuid(userOauthDTO.getUserId());
		userOauth.setAccessToken(userOauthDTO.getAccessToken());
		userOauth.setRefreshToken(userOauthDTO.getRefreshToken());
		userOauth.setExpiresIn(userOauthDTO.getExpiresIn());
		userOauth.setGrantTime(userOauthDTO.getGrantTime());
		userOauth.setExpireTime(userOauthDTO.getExpireTime());
		userOauth.setSource(userOauthDTO.getSource());
		return userOauth;
	}

    @Override
    protected String getName() {
        return "用户";
    }
	
}
