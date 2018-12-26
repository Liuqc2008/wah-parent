package wah.weixinapi.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;

import wah.infrastructure.extend.ObjectExtension;
import wah.infrastructure.extend.StringExtensions;

public class PropertiesUpdateTest {
	public static Properties prop;   
	static{
		prop = new Properties();
		try {
			InputStream in = new BufferedInputStream (new FileInputStream("src/main/resources/weixin.properties"));
			prop.load(in);
			in.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}     
	}
		
	public static void SetProperties(String key, String value) throws Exception{
		FileOutputStream oFile = new FileOutputStream("src/main/resources/weixin.properties", false);//true表示追加打开
		prop.setProperty(key, value);
		prop.store(oFile, "The New properties file");
		oFile.close();
	}
	
	@Ignore
	@Test
	public void test() throws Exception {
		PropertiesUpdateTest.SetProperties("AccessTokenCreateTime", "2018-10-16 12:12:13");
		
		//prop.list(System.out);
		System.out.println(prop.get("AccessTokenCreateTime"));
		Date d1= (ObjectExtension.StringToDate(prop.get("AccessTokenCreateTime").toString(), "yyyy-MM-dd HH:mm:ss"));
		
		System.out.println(StringExtensions.DateFormat(d1, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Ignore
	@Test
	public void DateTime() throws Exception {
		PropertiesUpdateTest.SetProperties("AccessTokenCreateTime", "2018-10-16 12:12:13");
		PropertiesUpdateTest.SetProperties("AppId", "");
		PropertiesUpdateTest.SetProperties("AppSecret", "");
		PropertiesUpdateTest.SetProperties("AccessToken", "");
		
	}
}
