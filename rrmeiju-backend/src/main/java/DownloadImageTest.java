import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownloadImageTest {
	
	// 资源所在的网页地址  
    private static final String RESOURCE_URL = "http://subhd.com/zu/";// "http://www.cbs.com/shows/";
    
    // 资源下载之后，保存在本地的文件路径  
    private static String downloadFilePath = "E:/DOWNLOAD_IMG/SUB_HD/subt/";
    
    /** 
     * 根据图片的外网地址下载图片到本地硬盘
     * 
     * @param filePath 本地保存图片的文件路径
     * @param imgUrl 图片的外网地址
     * @throws UnsupportedEncodingException
     *  
     */  
    public static void downloadImage(String filePath, String imgUrl) {
        // 图片url中的前面部分，例如"http://images.csdn.net/"
        // String beforeUrl = imgUrl.substring(0, imgUrl.lastIndexOf("/") + 1);
        // 图片url中的后面部分：例如“20150529/PP6A7429_副本1.jpg”
    	String fileName = null;
    	int beginIndex = imgUrl.lastIndexOf("/") + 1;
    	int endIndex = imgUrl.indexOf("?");
    	if (endIndex != -1) {
    		fileName = imgUrl.substring(beginIndex, endIndex);
    	} else {
    		fileName = imgUrl.substring(beginIndex);
    	}
        // 编码之后的fileName，空格会变成字符"+"
        // String newFileName = URLEncoder.encode(fileName, "UTF-8");
        // 把编码之后的fileName中的字符"+"，替换为UTF-8中的空格表示："%20"
        // newFileName = newFileName.replaceAll("\\+", "\\%20");
        // 编码之后的url
        // imgUrl = beforeUrl + newFileName;
        // 创建文件，fileName为编码之前的文件名
        File file = new File(filePath + fileName);
        if (file.exists()) {
        	System.out.println("文件" + fileName + "已存在，跳过");
        	return;
        }
        try {
            // 创建文件目录
            // File file = new File(filePath);  
            // if (!file.exists()) {
                // file.mkdirs();
            // }
            // 获取下载地址
            URL url = new URL(imgUrl);
            // 链接网络地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 获取链接的输出流
            InputStream is = connection.getInputStream();
            //根据输入流写入文件
            FileOutputStream out = new FileOutputStream(file);
            int i = 0;
            while ((i = is.read()) != -1) {
                out.write(i);
            }
            out.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  

	public static void main(String[] args) {
		for (int i = 1; i < 30; i++) {
			try {
				// 从一个网站获取和解析一个HTML文档
		        Document document = Jsoup.connect(RESOURCE_URL + i).get();
		        // 获取所有的img标签
		        Elements elements = document.getElementsByTag("img");
		        System.out.println("一共" + elements.size() + "张图片待下载");
		        int index = 1;
		        for (Element element : elements) {
		        	System.out.println("正在下载第" + index++ + "张图片");
		            // 获取每个img标签的src属性的内容，即图片地址，加"abs:"表示绝对路径 
		            String imgSrc = element.attr("abs:src");
		            // 下载图片文件到电脑的本地硬盘上  
		            downloadImage(downloadFilePath, imgSrc);
		        }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
