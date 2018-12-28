package wah.web.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeixinMPConfiguration {
	@Value("#{wxProperties.appId}")
	private String appId;

	@Value("#{wxProperties.appSecret}")
	private String appSecret;

	@Value("#{wxProperties.token}")
	private String token;

	@Value("#{wxProperties.aesKey}")
	private String aesKey;
	
	public WeixinMPConfiguration() {
		System.out.println("WeixinMPConfiguration容器启动初始化。。。");
	}
	
	@Bean
	public WxMpConfigStorage wxMpConfigStorage() {
		//需先安装lombok工具        https://blog.csdn.net/icecoola_/article/details/77414572 
		WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
		configStorage.setAppId(this.appId);
		configStorage.setSecret(this.appSecret);
		configStorage.setToken(this.token);
		configStorage.setAesKey(this.aesKey);
		return configStorage;
	}

	@Bean
	public WxMpService wxMpService() {
		WxMpService wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
		return wxMpService;
	}
}
