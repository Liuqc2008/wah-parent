package wah.web.controller;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import wah.web.service.WechatService;

@Controller
@RequestMapping("Wechat")
public class WechatController {

    @Autowired
    protected WxMpService wxMpService;
	
    @Autowired
    protected WechatService wechatService;
    
    @RequestMapping(value = "View")
    public String View() {
    	
    	
    	return "";
    }
    
    @RequestMapping(value = "Login")
    public String Login() throws Exception
    {
    	String returnUrl = URLEncoder.encode("http://khvyti.natappfree.cc/web/Wechat/getOAuth2UserInfo", "UTF-8");
        String redirectUrl=  wxMpService.oauth2buildAuthorizationUrl(returnUrl, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        
        System.out.println(redirectUrl);
        return "redirect:" + redirectUrl;
    }
    
    /* 通过Code获取用户信息
     * @param code code
     * @param lang zh_CN, zh_TW, en
     * @throws Exception 
     */
    @RequestMapping(value = "/getOAuth2UserInfo")
    public String getOAuth2UserInfo(@RequestParam(value = "code") String code, 
    							    @RequestParam(value = "lang") String lang,
    							    Model model) throws Exception {
        WxMpOAuth2AccessToken accessToken = wxMpService.oauth2getAccessToken(code);;
        
        WxMpUser wxMpUser = wxMpService.getUserService().userInfo(accessToken.getOpenId(), lang);;
      
        model.addAttribute("country", wxMpUser.getCountry());
		model.addAttribute("province", wxMpUser.getProvince());
		model.addAttribute("city", wxMpUser.getCity());
		model.addAttribute("sex", wxMpUser.getSex());
		model.addAttribute("nickname", wxMpUser.getNickname());
		model.addAttribute("headimgurl", wxMpUser.getHeadImgUrl());
		model.addAttribute("language", wxMpUser.getLanguage());
		model.addAttribute("openid", wxMpUser.getOpenId());
		model.addAttribute("privilege", wxMpUser.getPrivileges());
		
		return "jsp/Wechat/OAuth2UserInfo";
    }
    
    /*
     * 发送微信模板消息
     * */
    @RequestMapping(value="SendTemplateMessage", method= RequestMethod.GET)
	@ResponseBody
	public void SendTemplateMessage() throws Exception{
    	wechatService.SendTemplateMessage();
	}
}
