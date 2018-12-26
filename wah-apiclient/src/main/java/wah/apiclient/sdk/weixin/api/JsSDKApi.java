package wah.apiclient.sdk.weixin.api;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

import wah.apiclient.sdk.util.WebUtil;

public class JsSDKApi {
	
	public static Map<String, String> GetSign(String url) throws Exception{
		Map<String, String> result = new HashMap<String, String>();
		
		String jsapi_ticket = JsSDKApi.GetTicket();
		String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";
		
      //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
        
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(string1.getBytes("UTF-8"));
        signature = byteToHex(crypt.digest());
        
        result.put("url", url);
        result.put("jsapi_ticket", jsapi_ticket);
        result.put("nonceStr", nonce_str);
        result.put("timestamp", timestamp);
        result.put("signature", signature);
        
        return result;
	}
	
	public static String GetTicket() throws Exception{
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";// 全局accesstoken接口
		url = url.replace("ACCESS_TOKEN", Config.AccessToken());
		
		String webString = WebUtil.httpsRequest(url, "GET", null);
		JSONObject jsonObject = JSONObject.parseObject(webString);
		
		return jsonObject.getString("ticket");
	}
	
	
	
	
	private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
