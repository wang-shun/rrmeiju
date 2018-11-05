package com.caizhukui.rrmeiju.test;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 * 需要JDK8运行
 * 
 * @author caizhukui
 * @date 2017年4月1日下午3:45:07
 */
public class LuceneTest {
	
	public static final String[] CHINESE_STOP_WORDS = {"啊", "着", "的", "之", "式"};
	
	public static CharArraySet ALL_STOP_WORDS_SET = new CharArraySet(CHINESE_STOP_WORDS.length, true);
	
	static {
		// 把数组赋值到CharArraySet里
        for (String value : CHINESE_STOP_WORDS) {
        	ALL_STOP_WORDS_SET.add(value);
        }
        // 把StandardAnalyzer默认的停用词加进来
        ALL_STOP_WORDS_SET.addAll(StandardAnalyzer.STOP_WORDS_SET);
        System.out.println(ALL_STOP_WORDS_SET);
	}
	
	/**
	 * 判断两个字符串是否含义相同
	 * 
	 * @param text1 字符串1
	 * @param text2 字符串2
	 * @return boolean
	 * @author caizhukui
	 * @throws IOException 
	 * @date 2017年4月1日下午4:01:32
	 */
	public static boolean isSameText(String text1, String text2) throws IOException {
		String tokenText1 = getTokenText(text1);
		String tokenText2 = getTokenText(text2);
		if (tokenText1.equals(tokenText2)) {
			System.out.println("相同");
			return true;
		}
		System.out.println("不同");
		return false;
	}
	
	/**
	 * 生成去除停用词之后的字符串
	 * 
	 * @param text 原字符串
	 * @return String 
	 * @author caizhukui
	 * @throws IOException 
	 * @date 2017年4月1日下午3:55:48
	 */
	public static String getTokenText(String text) throws IOException {
		Analyzer analyzer = new StandardAnalyzer(ALL_STOP_WORDS_SET);
        TokenStream stream = analyzer.tokenStream("", text);
        // 获取每个单词信息，获取词元文本属性
        CharTermAttribute cta = stream.addAttribute(CharTermAttribute.class);
        stream.reset();
        StringBuffer sb = new StringBuffer();
        while (stream.incrementToken()) {
            System.out.print("[" + cta + "]");
            sb.append(cta);
        }
        System.out.println();
        analyzer.close();
        return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		String text1 = "中秋be之夜，享受着月华的孤独，享受着爆炸式的思维跃迁";
        String text2 = "中秋之夜, 享受着月华的孤独,享受 着爆炸式的思维跃迁 ";
        isSameText(text1, text2);
	}

}
