package com.caizhukui.rrmeiju.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.core.consts.CloudStorageConstant;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.UploadedFileDTO;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.UploadFile;

/**
 * 文件上传控制类
 * 
 * @author caizhukui
 * @date 2016年10月20日
 */
@RestController
@RequestMapping(value = "/v1")
public class FileUploadController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	/*@Autowired
	private JmsMessageSender jmsMessageSender;*/
	
	/*@Autowired
	private CloudServiceFacade cloudServiceFacade;*/
	
	// @RequestMapping(value = "/captcha", method = RequestMethod.GET)
	/*public void sendCaptcha(@RequestParam String mobileNumber) {
		final String freeSignName = "人人美剧";
		final String templateCode = "SMS_18765571";
		Map<String, String> params = new HashMap<String, String>();
		// 取当前时间戳的后6位作为验证码
		String captcha = String.valueOf(System.currentTimeMillis()).substring(7);
		params.put("captcha", captcha);
		serviceFacade.getSmsService().sendSms(mobileNumber, freeSignName, templateCode, params);
	}*/
	
	/**
	 * 文件上传
	 * 
	 * @param file
	 * @return UploadedFileDTO
	 * @author caizhukui
	 * @date 2016年10月18日
	 */
	@RequestMapping(value = "/files", method = RequestMethod.POST)
	public UploadedFileDTO uploadFile(@RequestParam("file") MultipartFile file) {
		/*jmsMessageSender.send("Hello JMS");
		// send to a code specified destination
	    Queue queue = new ActiveMQQueue("AnotherDest");
	    jmsMessageSender.send(queue, "Hello Another Message");*/
		UploadedFileDTO uploadedFileDto = new UploadedFileDTO();
		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize();
		uploadedFileDto.setFileName(fileName);
		uploadedFileDto.setFileSize(fileSize);
		String fileId = UuidUtils.getUuid();
		uploadedFileDto.setFileId(fileId);
		if (!file.isEmpty()) {
			try {
				// 本地保存的路径
				String filePath = "F:/WordNotebook/img/" + fileName;
				// 保存文件到本地
				saveLocalFile(file, filePath);
				// 生成存储到云端的文件名
				String objectKey = getObjectKey(fileName);
				// 上传到百度对象存储
				String bosUrl = null;
				/*bosUrl = cloudServiceFacade.getBosService().putObject(objectKey, filePath);*/
				// 上传到阿里巴巴对象存储
				String ossUrl = null;
				// ossUrl = cloudServiceFacade.getOssService().putObject(objectKey, filePath);
				// 上传到腾讯对象存储
				String cosUrl = null;
				// cosUrl = cloudServiceFacade.getCosService().putObject(objectKey, filePath);
				// 上传到七牛对象存储
				String qiniuUrl = null;
				/*qiniuUrl = cloudServiceFacade.getQiniuService().putObject(objectKey, filePath);*/
				// 上传到又拍对象存储
				String upyunUrl = null;
				// 对象存储使用优先级：百度>阿里巴巴>腾讯>七牛>又拍
				String fileUrl = getFileUrl(bosUrl, ossUrl, cosUrl, qiniuUrl, upyunUrl);
				uploadedFileDto.setFileUrl(fileUrl);
				UploadFile uploadFile = new UploadFile();
				uploadFile.setUuid(fileId);
				uploadFile.setFileName(fileName);
				uploadFile.setFileSize(fileSize);
				uploadFile.setFileObjectKey(objectKey);
				uploadFile.setFileLocalUrl(filePath);
				uploadFile.setFileBosUrl(bosUrl);
				uploadFile.setFileOssUrl(ossUrl);
				uploadFile.setFileCosUrl(cosUrl);
				uploadFile.setFileQiniuUrl(qiniuUrl);
				uploadFile.setFileUpyunUrl(upyunUrl);
				// 保存上传记录到数据库
				serviceFacade.getUploadFileService().add(uploadFile);
            } catch (Exception e) {
                logger.error("You failed to upload '" + fileName + "' => " + e.getMessage());
                throw new RestControllerException(RestError.RESOURCE_NOT_FOUND);
            }
		}
		return uploadedFileDto;
	}
	
	/**
	 * 保存文件到本地
	 * 
	 * @param file 待保存的文件
	 * @param filePath 保存的路径
	 * @author caizhukui
	 * @throws IOException 
	 * @date 2016年10月18日下午3:16:04
	 */
	private void saveLocalFile(MultipartFile file, String filePath) throws IOException {
		byte[] bytes = file.getBytes();
		File localFile = new File(filePath);
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(localFile));
		outputStream.write(bytes);
		outputStream.close();
	}
	
	/**
	 * 生成保存到云端的文件名
	 * 
	 * @param fileName 原文件名
	 * @return String 保存到云端的文件名
	 * @author caizhukui
	 * @date 2016年10月18日下午3:13:57
	 */
	private String getObjectKey(String fileName) {
		StringBuffer sb = new StringBuffer();
		sb.append("subtitle/");
		sb.append(getCurrentDate(CloudStorageConstant.DATE_FORMAT));
		sb.append("/");
		sb.append(fileName);
		return sb.toString();
	}
	
	/**
	 * 获取格式化的当前日期
	 * 
	 * @param dateFormat 格式化规则
	 * @return String 格式化后的当前日期
	 * @author caizhukui
	 * @date 2016年10月18日下午3:14:20
	 */
	private String getCurrentDate(String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(new Date());
	}
	
	/**
	 * 对象存储使用优先级：百度>阿里巴巴>腾讯>七牛>又拍
	 * 
	 * @param bosUrl 百度对象存储URL
	 * @param ossUrl 阿里巴巴对象存储URL
	 * @param cosUrl 腾讯对象存储URL
	 * @param qiniuUrl 七牛对象存储URL
	 * @param upyunUrl 又拍对象存储URL
	 * @return String
	 * @author caizhukui
	 * @date 2016年10月18日下午3:11:11
	 */
	private String getFileUrl(String bosUrl, String ossUrl, String cosUrl, String qiniuUrl, String upyunUrl) {
		String fileUrl = null;
		if (bosUrl != null) {
			fileUrl = bosUrl; 
		} else if (ossUrl != null) {
			fileUrl = ossUrl;
		} else if (cosUrl != null) {
			fileUrl = cosUrl;
		} else if (qiniuUrl != null) {
			fileUrl = qiniuUrl;
		} else if (upyunUrl != null) {
			fileUrl = upyunUrl;
		}
		return fileUrl;
	}

    @Override
    protected String getName() {
        return "文件上传";
    }

}
