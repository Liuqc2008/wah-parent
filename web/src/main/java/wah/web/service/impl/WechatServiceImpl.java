package wah.web.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import wah.infrastructure.extend.StringExtend;
import wah.web.service.WechatService;

@Service("WechatService")
public class WechatServiceImpl implements WechatService{
	
	@Autowired
    protected WxMpService wxMpService;
	
	public String OauthUrl(String returnUrl, String state) {
		
		return wxMpService.oauth2buildAuthorizationUrl(returnUrl, WxConsts.OAuth2Scope.SNSAPI_USERINFO, state);
	}
	
	public String GetUserInfoByCode(String code, String state) throws Exception {
		 WxMpOAuth2AccessToken accessToken = wxMpService.oauth2getAccessToken(code);
		 WxMpUser wxMpUser = wxMpService.getUserService().userInfo(accessToken.getOpenId(), "zh_CN");
		 
		 return wxMpUser.toString();
	}
	
	public void SendTemplateMessage() throws Exception {
		
		WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
				.toUser("oOaWMty6ZXxCEr967bKp9NUH5hSU")
				.templateId("7JYd8gAixGPJOtuwECS74jmbRAw_v2H4gtlWVa4IIVo")
				.url("https://sports.qq.com/nba/").build();

		templateMessage.addData(new WxMpTemplateData("Title", "下单成功！", "#FF0000"));
		templateMessage.addData(new WxMpTemplateData("ProductName", "巧克力", "#FF0000"));
		templateMessage.addData(new WxMpTemplateData("Amount", "39.8元", "#FF0000"));
		templateMessage.addData(new WxMpTemplateData("Time", StringExtend.DateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"), "#333"));
		templateMessage.addData(new WxMpTemplateData("Remark", "恭喜您购买成功！", "#FF0000"));

		wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
	}
}
