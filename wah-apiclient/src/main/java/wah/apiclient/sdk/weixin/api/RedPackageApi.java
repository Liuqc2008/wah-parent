package wah.apiclient.sdk.weixin.api;

import java.util.Map;
import java.util.TreeMap;

import wah.apiclient.sdk.util.CommonUtil;
import wah.apiclient.sdk.util.MD5;
import wah.apiclient.sdk.util.MapExtend;
import wah.apiclient.sdk.util.WebUtil;

public class RedPackageApi {
	public final static String SendRedPackUrl ="https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	public final static String SendGroupRedPackUrl ="	https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";
	/*
	 * 发放现金红包接口
	 */
	public static void SendCashRedPackage(Map<String, Object> param)throws Exception{
		param.put("send_name", "Giracle");    				//商户名称   红包发送者名称   不长于32位
		param.put("mch_id", Config.MchId);					//微信支付分配的商户号
		param.put("wxappid", Config.AppId);					//微信分配的公众账号ID
		param.put("nonce_str", CommonUtil.GetRandomUUID());	//随机字符串，不长于32位
		
		String urlParam = CommonUtil.MapToUrlParam(param) + "&key=" + Config.PayKey;
		param.put("sign", MD5.parseStrToMd5L32(urlParam).toUpperCase());	//	详见签名生成算法
		
		TreeMap<String, Object> treeMap = new TreeMap<String, Object>(param);
		String requestString = MapExtend.MapToXML(treeMap);
		
		String result = WebUtil.HttpRequestBySSL(SendRedPackUrl, requestString );
		System.out.println(result);
	}
	
	/*
	 * 发放裂变红包
	 */
	public static void SendGroupRedPack(Map<String, Object> param)throws Exception{
		param.put("send_name", "Giracle");    				//商户名称   红包发送者名称   不长于32位
		param.put("mch_id", Config.MchId);					//微信支付分配的商户号
		param.put("wxappid", Config.AppId);					//微信分配的公众账号ID
		param.put("nonce_str", CommonUtil.GetRandomUUID());	//随机字符串，不长于32位
		
		String urlParam = CommonUtil.MapToUrlParam(param) + "&key=" + Config.PayKey;
		param.put("sign", MD5.parseStrToMd5L32(urlParam).toUpperCase());	//	详见签名生成算法
		
		TreeMap<String, Object> treeMap = new TreeMap<String, Object>(param);
		String requestString = MapExtend.MapToXML(treeMap);
		
		String result = WebUtil.HttpRequestBySSL(SendGroupRedPackUrl, requestString );
		System.out.println(result);
	}
}
