package com.github.wxpay.sdk;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants;

import wah.apiclient.sdk.weixin.api.Config;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class IWxPayConfig extends WXPayConfig{

	private byte[] certData;

    private String app_id = Config.AppId;

    private String wx_pay_key = Config.PayKey;

    private String wx_pay_mch_id = Config.MchId;

    public IWxPayConfig() throws Exception { // 构造方法读取证书, 通过getCertStream 可以使sdk获取到证书
        //String certPath = "/data/config/chidori/apiclient_cert.p12";
    	String certPath = "D:/project/cert/apiclient_cert.p12";
    	File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public String getAppID() {
        return app_id;
    }


    public String getMchID() {
        return wx_pay_mch_id;
    }


    public String getKey() {
        return wx_pay_key;
    }


    public InputStream getCertStream() {
        return new ByteArrayInputStream(this.certData);
    }


    public IWXPayDomain getWXPayDomain() { // 这个方法需要这样实现, 否则无法正常初始化WXPay
        IWXPayDomain iwxPayDomain = new IWXPayDomain() {
          
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }
         
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
        return iwxPayDomain;
    }

}
