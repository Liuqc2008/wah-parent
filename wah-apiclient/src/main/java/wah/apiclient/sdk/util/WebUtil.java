package wah.apiclient.sdk.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.ssl.SSLContexts;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;

public class WebUtil {
	/**
	 * 获取当前请求request
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
				.getRequestAttributes()).getRequest();
		
		return request;
	}	
	
	/**
	 * 获取当前请求session
	 * @return
	 */
	public static HttpSession getHttpSession(){
		return getHttpServletRequest().getSession();
	}
	
	/**
	 * @param urlparam 带分隔的url参数
	 * @return
	 */
	public static HashMap<String,String> GetRequestParam(String urlparam){
		HashMap<String,String> map = new HashMap<String,String>();
		String[] param =  urlparam.split("&");
		for(String keyvalue:param){
			String[] pair = keyvalue.split("=");
			if(pair.length==2){
				map.put(pair[0], pair[1]);
			}
	   }
	   return map;
	}
	
	public static String httpsRequest(String requestUrl, String requestMethod, Map<String, Object> param) {
		try {
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		  //conn.setSSLSocketFactory(ssf);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时向输出流写数据
			String outputStr = JSONObject.toJSONString(param);
			if (!outputStr.equals("") && param != null) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			//BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			
			return buffer.toString();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return "";
	}
	
	public static byte[] DownloadPicture(String requestUrl) {
		byte[] result = null;
		try {
			URL url = new URL(requestUrl);
			url = new URL(requestUrl);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            result=output.toByteArray();
            dataInputStream.close();
            
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return result;
	}
	
	public static String HttpRequestBySSL(String url, String str) throws Exception{
		RequestBody body = RequestBody.create(MediaType.parse("text/xml;charset=UTF-8"), str);
		 
		Request request = new Request.Builder().url(url).post(body).build();
       
       //为http请求设置证书
       SSLSocketFactory socketFactory = getSSL().getSocketFactory();
       X509TrustManager x509TrustManager = Platform.get().trustManager(socketFactory);
       OkHttpClient okHttpClient = new OkHttpClient.Builder().sslSocketFactory(socketFactory, x509TrustManager).build();
       //得到输出内容
       Response response = okHttpClient.newCall(request).execute();
       String content = response.body().string();
       
       return content;
	}
	
	public static SSLContext getSSL() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {
       KeyStore keyStore = KeyStore.getInstance("PKCS12");
       //证书位置自己定义
       FileInputStream instream = new FileInputStream(new File("D:/project/cert/apiclient_cert.p12"));
       try {
           keyStore.load(instream, "1491480322".toCharArray());
       } finally {
           instream.close();
       }
       SSLContext sslcontext = SSLContexts.custom()
               .loadKeyMaterial(keyStore, "1491480322".toCharArray())
               .build();
       
       return sslcontext;
   }
}
