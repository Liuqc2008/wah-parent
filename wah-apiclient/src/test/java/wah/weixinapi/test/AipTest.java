package wah.weixinapi.test;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import wah.apiclient.sdk.weixin.api.WeixinOauth2Api;

public class AipTest {
	
	@Ignore
	@Test
	public void GetUserInfoByOpenId() throws Exception {
		Map<String, Object> resule = WeixinOauth2Api.GetUserInfoByOpenId("oOaWMty6ZXxCEr967bKp9NUH5hSU");
		
		System.out.println(JSON.toJSONString(resule));
	}
}
