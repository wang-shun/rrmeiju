package com.caizhukui.rrmeiju.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * File Model
 * 
 * @author caizhukui
 * @date 2017年1月25日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UploadFile extends BaseModel {

	private static final long serialVersionUID = -3581733757256159077L;
	
	/** 文件名 */
	private String fileName;
	
	/** 文件大小 */
	private long fileSize;
	
	/**  */
	private String fileObjectKey;
	
	/** 本地存储URL */
	private String fileLocalUrl;
	
	/**  */
	private String fileBosUrl;
	
	/** 阿里云对象存储URL */
	private String fileOssUrl;
	
	/**  */
	private String fileCosUrl;
	
	/** 七牛云存储URL */
	private String fileQiniuUrl;
	
	/** 又拍云存储URL */
	private String fileUpyunUrl;
	
	/** 上传时间 */
	private Date createTime;

}
