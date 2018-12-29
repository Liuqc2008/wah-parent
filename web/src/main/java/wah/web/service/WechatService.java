package wah.web.service;

public interface WechatService {

	public String OauthUrl(String returnUrl, String state);
	
	public String GetUserInfoByCode(String code, String state) throws Exception;
	
	public void SendTemplateMessage() throws Exception;
	
	
}
