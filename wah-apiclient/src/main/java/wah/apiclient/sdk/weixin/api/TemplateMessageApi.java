package wah.apiclient.sdk.weixin.api;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import wah.apiclient.sdk.util.WebUtil;

public class TemplateMessageApi {
	
	/*
	 * 获得模板ID 接口
	 * 返回错误消息格式：{"errcode":40001,"errmsg":"invalid credential, access_token is invalid or not latest hint: [ZyxBWA03988051!]"}
	 * */
	public static void GetTemplateId(Map<String, Object> param) throws Exception{
		String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
		
		url = url.replace("ACCESS_TOKEN", Config.AccessToken());
		String jsonString = WebUtil.httpsRequest(url, "POST", param);
		
		System.out.println(jsonString);
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		
		if( jsonObject.containsKey("errcode")){
			System.out.println(jsonObject.containsKey("errmsg"));
		}
	}
	
	/*
	 * 获取模板列表
	 * 返回数据格式：{"template_list":[{"template_id":"UcnjChkm9em9wCReR6W8yxYorncppHdrRuiV2xd14O4","title":"领取奖金提醒","primary_industry":"","deputy_industry":"","content":"{ {result.DATA} }\\n\\n领奖金额:{ {withdrawMoney.DATA} }\\n领奖  时间:{ {withdrawTime.DATA} }\\n银行信息:{ {cardInfo.DATA} }\\n到账时间:  { {arrivedTime.DATA} }\\n{ {remark.DATA} }","example":""}]}
	 * 返回错误消息格式：{"errcode":40001,"errmsg":"invalid credential, access_token is invalid or not latest hint: [ZyxBWA03988051!]"}
	 * */
	public static Map<String, Object> GetTemplateList() throws Exception{
		String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
		
		url = url.replace("ACCESS_TOKEN", Config.AccessToken());
		String jsonString = WebUtil.httpsRequest(url, "POST", null);

		System.out.println(jsonString);
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		if( jsonObject.containsKey("errcode")){
			System.out.println(jsonObject.containsKey("errmsg"));
		}
		
		return jsonObject;
	}
	
	/*
	 * 删除模板
	 * 返回数据格式：{"errcode":0,"errmsg":"ok"}
	 * */
	public static void DeleteTemplateById(Map<String, Object> param) throws Exception{
		String url = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";
		
		url = url.replace("ACCESS_TOKEN", Config.AccessToken());
		String jsonString = WebUtil.httpsRequest(url, "POST", param);

		System.out.println(jsonString);
		//JSONObject jsonObject = JSONObject.parseObject(jsonString);
	}
	
	/*
	 * 发送模板消息
	 * 返回数据格式：{"errcode":0,"errmsg":"ok","msgid":507293339620491264}
	 * */
	public static void SendTemplateMessage(Map<String, Object> param) throws Exception{
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		
		url = url.replace("ACCESS_TOKEN", Config.AccessToken());
		String jsonString = WebUtil.httpsRequest(url, "POST", param);

		System.out.println(jsonString);
		//JSONObject jsonObject = JSONObject.parseObject(jsonString);
	}
}
