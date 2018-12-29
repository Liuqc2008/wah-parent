package wah.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import me.chanjar.weixin.mp.api.WxMpService;
import wah.web.service.WechatService;

@Controller
@RequestMapping("Wechat")
public class WechatController {
	
    @Autowired
    protected WechatService wechatService;
    
    @Autowired
    protected WxMpService wxMpService;
    
    @RequestMapping(value = "Login")
    public String Login() throws Exception
    {
    	String returnUrl = "http://khvyti.natappfree.cc/web/Wechat/getOAuth2UserInfo";
    		
        return "redirect:" + wechatService.OauthUrl(returnUrl, null);
    }
    
    /* 
     * 通过Code获取用户信息
     * @param code code
     * @param lang zh_CN, zh_TW, en
     * @throws Exception 
     * 用户信息{"city":"","country":"冰岛","groupId":0,"headImgUrl":"http://thirdwx.qlogo.cn/mmopen/F5pYbOced8eD0OvfnRWsflGJu5QALJslfujcg8fsuUIuSykXf42AzIzKia7CmRVN7HG4UUUcVoUM5FFgicluibMoAY9p6COFjAC/132","language":"zh_CN","nickname":"x","openId":"oOaWMty6ZXxCEr967bKp9NUH5hSU","province":"","qrScene":"0","qrSceneStr":"","remark":"","sex":1,"sexDesc":"男","subscribe":true,"subscribeScene":"ADD_SCENE_QR_CODE","subscribeTime":1533880823,"tagIds":[]}
     */
    @RequestMapping(value = "/getOAuth2UserInfo")
    public String getOAuth2UserInfo(@RequestParam(value = "code") String code, 
    							    @RequestParam(value = "state") String state,
    							    Model model) throws Exception {
    	
        Map userinfo = (Map)JSON.parseObject(wechatService.GetUserInfoByCode(code, state));
    
        model.addAttribute("country", userinfo.get("country"));
		model.addAttribute("province", userinfo.get("province"));
		model.addAttribute("city", userinfo.get("city"));
		model.addAttribute("sex", userinfo.get("sex"));
		model.addAttribute("nickname", userinfo.get("nickname"));
		model.addAttribute("headimgurl", userinfo.get("headImgUrl"));
		model.addAttribute("language", userinfo.get("language"));
		model.addAttribute("openid", userinfo.get("openid"));
		
		System.out.println(userinfo.get("headimgurl"));
		return "jsp/Wechat/OAuth2UserInfo";
    }
    
    /*
     * 发送微信模板消息
     * http://localhost/web/Wechat/SendTemplateMessage
     * */
    @RequestMapping(value="SendTemplateMessage", method= RequestMethod.GET)
	@ResponseBody
	public void SendTemplateMessage() throws Exception{
    	wechatService.SendTemplateMessage();
	}
    
    @RequestMapping(value="getJsapiTicket", method= RequestMethod.GET)
	@ResponseBody
    public String getJsapiTicket() throws Exception{
    	
    	return wxMpService.getJsapiTicket();
	}
    
    @RequestMapping("jssdk")
	public String jssdk(Model model) throws Exception{
    	
		model.addAttribute("configData", wxMpService.createJsapiSignature("http://khvyti.natappfree.cc/web/Wechat/jssdk"));

		return "jsp/Wechat/jssdk";
	}
    
    /*
     * 获取Config参数：{"appId":"wx1d02f3d1411a96e3","nonceStr":"FFHrYFdY8JydytuN","timestamp":1546070645,"url":"http://khvyti.natappfree.cc","signature":"43dbaee40af544d8e4866fc5d35ad04d58590311"}
     * */
    @RequestMapping(value="createJsapiSignature", method= RequestMethod.GET)
   	@ResponseBody
   	public Object createJsapiSignature() throws Exception {
       	
       	return wxMpService.createJsapiSignature("http://khvyti.natappfree.cc");
   	}
}
