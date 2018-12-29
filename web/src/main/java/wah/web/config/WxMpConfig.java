package wah.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Binary Wang
 */
@Configuration
public class WxMpConfig {
	@Value("#{wxProperties.token}")
	private String token;

	@Value("#{wxProperties.appid}")
	private String appid;

	@Value("#{wxProperties.appsecret}")
	private String appSecret;

	@Value("#{wxProperties.aeskey}")
	private String aesKey;

	public String getToken() {
		return this.token;
	}

	public String getAppid() {
		return this.appid;
	}

	public String getAppSecret() {
		return this.appSecret;
	}

	public String getAesKey() {
		return this.aesKey;
	}

}