package wah.apiclient.aliyun.message.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

import wah.apiclient.aliyun.message.MessageApi;

public class AipTest {
	
	@Ignore
	@Test
	public void sendMessageTest() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("code", "18259480903");
		
		SendSmsResponse result = MessageApi.sendMessage("18259480903", JSONObject.toJSONString(param), "好房子", "SMS_139226475");
		System.out.println(JSONObject.toJSONString(result));
		
	}
	
	@Ignore
	@Test
	public void MapToJsonStringTest(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("code", "123");
		
		System.out.println(JSONObject.toJSONString(param));
	}
}
