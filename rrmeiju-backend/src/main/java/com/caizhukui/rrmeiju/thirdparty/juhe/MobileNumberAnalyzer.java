package com.caizhukui.rrmeiju.thirdparty.juhe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Analyze Mobile Numbers
 * 
 * @author caizhukui
 * @date 2017年2月28日下午3:31:13
 */
public class MobileNumberAnalyzer {
	
	private static final Logger logger = LoggerFactory.getLogger(MobileNumberAnalyzer.class);
	
	/** 调用聚合数据手机号码归属地接口的AppKey */
	private static final String APP_KEY = "2f10eefd42bbe5a8c5847910be08c886";
	
	/**
	 * 从Excel读取手机号码
	 * 
	 * @param excelPath Excel文件路径
	 * @return Set<String> 手机号码
	 * @throws IOException
	 * @author caizhukui
	 * @date 2017年2月28日下午4:38:32
	 */
	public static Set<String> readPhonesFromExcel03(String excelPath) throws IOException {
		Set<String> phones = new HashSet<String>();
		File excelFile = new File(excelPath);
		FileInputStream is = new FileInputStream(excelFile);
		POIFSFileSystem fs = new POIFSFileSystem(is); 
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        // 第一行为表头，从第二行开始读取数据
        for (int i = 1; i <= rowNum; i++) {
        	HSSFRow row = sheet.getRow(i);
        	String phone = row.getCell(0).getStringCellValue().trim();
        	if (StringUtils.isNoneBlank(phone)) {
        		phones.add(phone);
        	}
        }
        wb.close();
        fs.close();
        is.close();
        return phones;
	}
	
	/**
	 * 从Excel读取手机号码
	 * 
	 * @param excelPath Excel文件路径
	 * @return Set<String> 手机号码
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @author caizhukui
	 * @date 2017年2月28日下午5:18:04
	 */
	public static Set<String> readPhonesFromExcel07(String excelPath) throws IOException, EncryptedDocumentException, InvalidFormatException {
		Set<String> phones = new HashSet<String>();
		File excelFile = new File(excelPath);
		FileInputStream is = new FileInputStream(excelFile);
        Workbook wb = WorkbookFactory.create(is);
        Sheet sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        // 第一行为表头，从第二行开始读取数据
        for (int i = 1; i <= rowNum; i++) {
        	Row row = sheet.getRow(i);
        	String phone = row.getCell(0).getStringCellValue().trim();
        	if (StringUtils.isNoneBlank(phone)) {
        		phones.add(phone);
        	}
        }
        wb.close();
        is.close();
		return phones;
	}
	
	/**
	 * 调用聚合数据的接口查询手机号码归属地
	 * 
	 * @param phone 需要查询的手机号码或手机号码前7位
	 * @return MobileNumber
	 * @throws IOException
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @author caizhukui
	 * @date 2017年2月28日下午3:53:42
	 */
	public static MobileNumber analyzeMobileNumber(String phone) throws ClientProtocolException, IOException, URISyntaxException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		URI uri = new URIBuilder()    
		        .setScheme("http")    
		        .setHost("apis.juhe.cn")    
		        .setPath("/mobile/get")
		        .setParameter("phone", phone)
		        .setParameter("key", APP_KEY)
		        .build();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		HttpEntity httpEntity = httpResponse.getEntity();
		String strResult = EntityUtils.toString(httpEntity);
		httpResponse.close();
		httpClient.close();
		ObjectMapper mapper = new ObjectMapper();
		MobileNumberResponse response = mapper.readValue(strResult, MobileNumberResponse.class);
		MobileNumber mobileNumber = response.getResult();
		mobileNumber.setPhone(phone);
		return mobileNumber;
	}
	
	/**
	 * 调用聚合数据的接口查询手机号码归属地
	 * 
	 * @param phones 需要查询的手机号码或手机号码前7位
	 * @return Set<MobileNumber>
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @author caizhukui
	 * @date 2017年2月28日下午4:11:30
	 */
	public static Set<MobileNumber> analyzeMobileNumber(Set<String> phones) throws ClientProtocolException, IOException, URISyntaxException {
		Set<MobileNumber> mobileNumbers = new HashSet<MobileNumber>();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		ObjectMapper mapper = new ObjectMapper();
		for (String phone : phones) {
			URI uri = new URIBuilder()    
			        .setScheme("http")    
			        .setHost("apis.juhe.cn")    
			        .setPath("/mobile/get")
			        .setParameter("phone", phone)
			        .setParameter("key", APP_KEY)
			        .build();
			HttpGet httpGet = new HttpGet(uri);
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			String strResult = EntityUtils.toString(httpEntity);
			httpResponse.close();
			MobileNumberResponse response = mapper.readValue(strResult, MobileNumberResponse.class);
			if ("200".equals(response.getResultCode()) && "0".equals(response.getErrorCode())) {
				MobileNumber mobileNumber = response.getResult();
				mobileNumber.setPhone(phone);
				// System.out.println(mobileNumber);
				mobileNumbers.add(mobileNumber);
			} else {
				// System.out.println(response);
			}
		}
		httpClient.close();
		return mobileNumbers;
	}
 
	public static void main(String[] args) {
		try {
			String excelPath = "D:/AA.xlsx";
			Set<String> phones = readPhonesFromExcel07(excelPath);
			System.out.println("一共" + phones.size() + "个号码");
			Set<MobileNumber> mobileNumbers = analyzeMobileNumber(phones);
			System.out.println("一共" + mobileNumbers.size() + "个有效号码");
			Map<String, Integer> provinceCountMap = new HashMap<String, Integer>();
			for (MobileNumber mobileNumber : mobileNumbers) {
				String province = mobileNumber.getProvince();
				int count = 1;
				if (provinceCountMap.containsKey(province)) {
					count = provinceCountMap.get(province);
					count++;
				}
				provinceCountMap.put(province, count);
			}
			for (Map.Entry<String, Integer> entry : provinceCountMap.entrySet()) {
				System.out.println(entry.getKey() + "的手机号码有" + entry.getValue() + "个");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("{}", e);
		}
	}

}
