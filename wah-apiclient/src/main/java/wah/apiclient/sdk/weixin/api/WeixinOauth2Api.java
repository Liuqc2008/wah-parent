package wah.apiclient.sdk.weixin.api;

import java.util.Map;

import wah.apiclient.sdk.util.JSONObjectToHashMap;
import wah.apiclient.sdk.util.WebUtil;

public class WeixinOauth2Api {
	/**
	 *网页授权请求
	 */
	public static String GetUrl(String redirect_uri, String scope){
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=AppId&redirect_uri=Redirect_Uri&response_type=code&scope=Scope&state=STATE#wechat_redirect";
		
		return url.replace("AppId", Config.AppId).replace("Redirect_Uri", redirect_uri).replace("Scope", scope);
	}
	
	/*
	 * 返回数据格式：{"access_token":"12_P6F4y9ISrzXmoqT2eVDVCvwEBBWOCtQCgPMtgk13pfkk5G2Rw2kcTcd34saLPMZzY4I1KlcagAQkwBEIVU6BgQ","expires_in":7200,"refresh_token":"12_zVCxFgTNwM4mpN0OdMLO46l3mjvWoaI7MregGJg1W0kNHlQUcADxQhLjGJ-zClYBObcGDWA_h6WpftMPxtrXJQ","openid":"oOaWMty6ZXxCEr967bKp9NUH5hSU","scope":"snsapi_userinfo"}
	 * */
	public static Map<String, Object> GetOpenIdByCode(String code){
		String token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=AppId&secret=AppSecret&code=Code&grant_type=authorization_code";
		
		token_url = token_url.replace("AppId", Config.AppId).replace("AppSecret", Config.AppSecret).replace("Code", code);
		String jsonString = WebUtil.httpsRequest(token_url, "GET", null);
		
		Map<String, Object> hashMap = JSONObjectToHashMap.toHashMap(jsonString);
		return hashMap;
	}
	
	/*
	 *网页授权方式  获取用户信息与基础Token获取用户信息接口不一样
	 *返回数据接口：
	 *{"openid":"oOaWMty6ZXxCEr967bKp9NUH5hSU","nickname":"x","sex":1,"language":"zh_CN","city":"","province":"","country":"冰岛","headimgurl":"http:\/\/thirdwx.qlogo.cn\/mmopen\/vi_32\/4l1fGSUsSj8IuuUdbK3uQqMlCuxfPZSANW8ZvQ63A405j4L3h2m68C2sic8KSXafib7bPT67juwM8S1XgUv315icg\/132","privilege":[]}
	 **/
	public static Map<String, Object> GetUserInfoByCode(String code) throws Exception{
		Map<String, Object> hashMap = null;
		
		Map<String, Object> openId = GetOpenIdByCode(code);
		if(! openId.containsKey("openid"))
			System.out.print("获取openid失败，错误码：" + openId.get("errcode"));
		else{
			String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + openId.get("access_token") + "&openid=" + openId.get("openid") + "&lang=zh_CN";
			String jsonString = WebUtil.httpsRequest(url, "GET", null);
			
			hashMap = JSONObjectToHashMap.toHashMap(jsonString);
		}
		
		return hashMap;
	}
	
	/*
	 *基础Token获取用户信息
	 *数据格式：
	 *"country":"冰岛","qr_scene":0,"subscribe":1,"city":"","openid":"oOaWMty6ZXxCEr967bKp9NUH5hSU","tagid_list":[],"sex":1,"groupid":0,"language":"zh_CN","remark":"","subscribe_time":1533880823,"province":"","subscribe_scene":"ADD_SCENE_QR_CODE","nickname":"x","headimgurl":"http://thirdwx.qlogo.cn/mmopen/F5pYbOced8eD0OvfnRWsflGJu5QALJslfujcg8fsuUIuSykXf42AzIzKia7CmRVN7HG4UUUcVoUM5FFgicluibMoAY9p6COFjAC/132","qr_scene_str":""}
	 **/
	public static Map<String, Object> GetUserInfoByOpenId(String openId) throws Exception{
		Map<String, Object> result = null;
		
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=AccessToken&openid=OpenId&lang=zh_CN";
		url = url.replace("AccessToken", Config.AccessToken()).replace("OpenId", openId);
		String jsonString = WebUtil.httpsRequest(url, "GET", null);
		result = JSONObjectToHashMap.toHashMap(jsonString);
		return result;
	}
}
