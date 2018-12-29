package wah.apiclient.sdk.weixin.api;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import com.alibaba.fastjson.JSONObject;

import wah.infrastructure.extend.ObjectExtend;
import wah.infrastructure.extend.StringExtend;
import wah.apiclient.sdk.util.*;

public class Config {
	public static Properties prop;   
	static{
		prop = new Properties();
		try {
			InputStream in = new BufferedInputStream (new FileInputStream("D:/project/MavenSSM/src/main/resources/weixin.properties"));
			//InputStream in = Config.class.getClassLoader().getResourceAsStream("weixin.properties"); //web启动下使用
			//InputStream in = new BufferedInputStream (new FileInputStream("src/main/resources/weixin.properties"));  //junit调试使用
			prop.load(in);
			in.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}     
	}
	
	public static void SetProperties(String key, String value) throws Exception{
		FileOutputStream oFile = new FileOutputStream("D:/project/MavenSSM/src/main/resources/weixin.properties", false);
		//FileOutputStream oFile = new FileOutputStream(Config.class.getClassLoader().getResource("weixin.properties").getFile());
		//FileOutputStream oFile = new FileOutputStream("src/main/resources/weixin.properties", false);//true表示追加打开
		prop.setProperty(key, value);
		prop.store(oFile, "The New properties file");
		oFile.close();
	}
	
	public static final String AppId= prop.getProperty("AppId");
	
	public static final String AppSecret = prop.getProperty("AppSecret");
	
	public static final String PayKey = prop.getProperty("PayKey");
	
	public static final String MchId = prop.getProperty("MchId");
	
	public static String AccessToken() throws Exception{
		Date now = new Date();
		String as = prop.getProperty("AccessTokenCreateTime");
		Date accessTokenCreateTime = ObjectExtend.StringToDate(as, "yyyy-MM-dd HH:mm:ss");
		
		if( (((now.getTime() - accessTokenCreateTime.getTime()) ) / ( 60*1000 )) > 160){
			/*
			 * 接受数据格式
			 * {"access_token":"12_2ITCbzLVAtV7wu0vlCE2mn5UoEm2RuM3LNPGbRTGnon70r42XQNApo0IAs3XSgQA_LJMn-tNlMuaSq9cHUUP3hgWWmqSOxjrj3hjb9neWGePslXwgNKi60RHvEHQeExDovHEKygiGpOjfOLjOCFfAAARFI",
			 * "expires_in":7200}
			 */
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
			url = url.replace("APPID", AppId).replace("APPSECRET", AppSecret);
			String accessToken = WebUtil.httpsRequest(url, "GET", null);
			
			JSONObject jsonObject = JSONObject.parseObject(accessToken);
			Config.SetProperties("AccessToken", jsonObject.getString("access_token"));
			Config.SetProperties("AccessTokenCreateTime", StringExtend.DateFormat((new Date()), "yyyy-MM-dd HH:mm:ss"));
		}
		
		return prop.getProperty("AccessToken");
	}
}
