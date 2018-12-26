package wah.weixinapi.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import wah.apiclient.sdk.weixin.api.*;

public class TemplateMessageTest {

	@Ignore
	@Test
	public void GetTemplateByShortId() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("template_id_short", "TM00015");
		
		TemplateMessageApi.GetTemplateId(param);
	}
	
	@Ignore
	@Test
	public void GetTemplateList() throws Exception {
		
		//Map<String, Object> result = TemplateMessageApi.GetTemplateList();
	}
	
	@Ignore
	@Test
	public void DeleteTemplateById() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("template_id", "ZWv5SjVpY3zQnurDKRG_j9QnvDeXlDLx_-PuJtLd07U");
	
		TemplateMessageApi.DeleteTemplateById(param);
	}
	/*
	 *  模板格式{{Title.DATA}}
		商品名称：{{ProductName.DATA}}
		消费金额：{{Amount.DATA}}
		购买时间：{{Time.DATA}}
		{{Remark.DATA}}
	 * 发送消息：
	 * {"touser":"oOaWMty6ZXxCEr967bKp9NUH5hSU","data":{"ProductName":{"color":"#173177","value":"巧克力"},"Amount":{"color":"#173177","value":"39.8元"},"Title":{"color":"#173177","value":"恭喜你购买成功！"},"Time":{"color":"#173177","value":"2014年9月22日"},"Remark":{"color":"#173177","value":"欢迎再次购买！"}},"template_id":"7JYd8gAixGPJOtuwECS74jmbRAw_v2H4gtlWVa4IIVo","url":"mtest.home-h.com"}
	 * */
	@Ignore
	@Test
	public void SendTemplateMessage() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("touser", "oOaWMty6ZXxCEr967bKp9NUH5hSU");
		param.put("template_id", "7JYd8gAixGPJOtuwECS74jmbRAw_v2H4gtlWVa4IIVo");
		param.put("url", "https://xw.qq.com/m/nba");
		
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> Title = new HashMap<String, Object>();
		Title.put("value", "恭喜你购买成功！");
		Title.put("color", "#173177");
		data.put("Title", Title);
		
		Map<String, Object> ProductName = new HashMap<String, Object>();
		ProductName.put("value", "巧克力");
		ProductName.put("color", "#173177");
		data.put("ProductName", ProductName);
		
		Map<String, Object> Amount = new HashMap<String, Object>();
		Amount.put("value", "39.8元");
		Amount.put("color", "#173177");
		data.put("Amount", Amount);
		
		Map<String, Object> Time = new HashMap<String, Object>();
		Time.put("value", "2014年9月22日");
		Time.put("color", "#173177");
		data.put("Time", Time);
		
		Map<String, Object> Remark = new HashMap<String, Object>();
		Remark.put("value", "欢迎再次购买！");
		Remark.put("color", "#173177");
		data.put("Remark", Remark);
		
		param.put("data", data);
	
		TemplateMessageApi.SendTemplateMessage(param);
	}
}
