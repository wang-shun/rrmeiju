package com.caizhukui.rrmeiju.thirdparty.juhe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Temp {
	
	public static Set<String> readFromExcel07(String excelPath) throws IOException, EncryptedDocumentException, InvalidFormatException {
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

	public static void main(String[] args) {
		Connection connection = Jsoup.connect("http://epguides.com/HawaiiFiveO_2010/");
		Document document;
		try {
			document = connection.get();
			System.out.println(document);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
