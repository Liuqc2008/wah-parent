package wah.apiclient.sdk.weixin.api;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import wah.apiclient.sdk.util.WebUtil;

public class MenuApi {
	
	/*
	 * JSON数据格式：{"button":[{"name":"资讯服务","sub_button":[{"type":"view","name":"营业网点查询1","url":"http://www.soso.com/"},{"type":"view","name":"还款计算器","url":"http://v.qq.com/"}]},{"name":"业务中心","sub_button":[{"type":"view","name":"担保业务办理","url":"http://www.soso.com/"},{"type":"click","name":"公积金担保查询","key":"V1001_01"}]},{"name":"个人中心","sub_button":[{"type":"view","name":"优惠券管理","url":"http://www.soso.com/"},{"type":"view","name":"房产中心","url":"http://v.qq.com/"}]}]}
	 * */
	public static String CreateMenu(Map<String, Object> param) throws Exception{
		String setMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=AccessToken";
		
		setMenuUrl = setMenuUrl.replace("AccessToken", Config.AccessToken());
		String jsonString = WebUtil.httpsRequest(setMenuUrl, "POST", param);
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		
		String msg = "";
		if (null != jsonObject) {
			int errorCode = jsonObject.getIntValue("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			
			if (0 == errorCode) {

				msg = "creat menu is OK!";
			} else {
				msg = "creat menu is errcode:{} errmsg:{}"+ errorCode+ errorMsg;
			}
		}
		
		return msg;
	}
	
	public static String GetMenu() throws Exception{
		String getMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=AccessToken";

		getMenuUrl = getMenuUrl.replace("AccessToken", Config.AccessToken());
		String jsonString = WebUtil.httpsRequest(getMenuUrl, "POST", null);
        
        return jsonString;
	}

	public static String DeleteMenu() throws Exception{
		String deleteMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=AccessToken";
		
		deleteMenuUrl = deleteMenuUrl.replace("AccessToken", Config.AccessToken());
		String jsonString = WebUtil.httpsRequest(deleteMenuUrl, "POST", null);
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		
		String msg = "";
		if (null != jsonObject) {
			int errorCode = jsonObject.getIntValue("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			
			if (0 == errorCode) {
				msg = "delete menu is OK!";
			} else {
				msg = "delete menu is errcode:{} errmsg:{}"+ errorCode+ errorMsg;
			}
		}
		
		return msg;
	}
}
