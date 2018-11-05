package com.caizhukui.rrmeiju.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件下载控制类
 * 
 * @author caizhukui
 * @date 2017年1月17日
 */
@RestController
public class FileDownloadController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
	
	/**
	 * 
	 * 
	 * @return ResponseEntity<InputStreamResource>
	 * @throws IOException
	 * @author caizhukui
	 * @date 2017年7月25日
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> downloadPDFFile() throws IOException {
		logger.info("hahaha");
	    ClassPathResource pdfFile = new ClassPathResource("Maven2基础教程.pdf");
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentDispositionFormData("attachment", new String("Maven2基础教程.pdf".getBytes("UTF-8"), "ISO8859-1"));
	    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	    headers.add("Pragma", "no-cache");
	    headers.add("Expires", "0");
	    return ResponseEntity
	    		.ok()
	    		.headers(headers)
	    		.contentLength(pdfFile.contentLength())
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(new InputStreamResource(pdfFile.getInputStream()));
	}

    @Override
    protected String getName() {
        return "文件下载";
    }

}
