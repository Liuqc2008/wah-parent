package wah.apiclient.aliyun.message;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import wah.infrastructure.exception.AlertException;

public class MessageApi {
	
	//初始化ascClient需要的几个参数
	static final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
	static final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
	//替换成你的AK
	static final String accessKeyId = "LTAIhb46OIaSD4C0";//你的accessKeyId,参考本文档步骤2
	static final String accessKeySecret = "DmpSlYfLiy8eaTlbACOBdxsio3sgHL";//你的accessKeySecret，参考本文档步骤2
	
	/*
	 * 返回信息：{"bizId":"626803340367774475^0","code":"OK","message":"OK","requestId":"E229E474-014E-4723-AABA-EE26306DD792"}
	 * 错误信息返回格式：{"code":"isv.SMS_TEMPLATE_ILLEGAL","message":"模板不合法(不存在或被拉黑)","requestId":"262AABE4-193E-4D8F-B645-51975FD31DC4"}
	 * */
	public static SendSmsResponse sendMessage(String phone, String data, String signName, String templateCode) throws Exception{
		
		//可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(data);

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        if(! sendSmsResponse.getCode().equals("OK"))
        	throw new AlertException("错误信息：" + sendSmsResponse.getMessage());
        	
        return sendSmsResponse;
	}
	
	
	
}
