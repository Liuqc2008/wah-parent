package wah.apiclient.alipay.page.pay;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;

import wah.infrastructure.exception.AlertException;

public class AliPagePayApi {
	//获得初始化的AlipayClient
	private static final AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	
	/*
	 * 获取请求表单
	 * */
	public static String aliPagePay(String trageNo, String totalAmount, String orderDesc, String productName) throws Exception{
		Map<String, String> param = new HashMap<String, String>();
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		
		param.put("out_trade_no", new String(trageNo.getBytes("ISO-8859-1"),"UTF-8"));		//商户订单号，商户网站订单系统中唯一订单号，必填
		param.put("total_amount", new String(totalAmount.getBytes("ISO-8859-1"),"UTF-8"));	//付款金额，必填
		param.put("subject", new String(orderDesc.getBytes("ISO-8859-1"),"UTF-8"));		//订单名称，必填
		param.put("body", new String(productName.getBytes("ISO-8859-1"),"UTF-8"));			//商品描述，可空
		param.put("product_code", "FAST_INSTANT_TRADE_PAY");
		
		alipayRequest.setBizContent(JSONObject.toJSONString(param));
	
		return alipayClient.pageExecute(alipayRequest).getBody();
	}
	
	/*
	 * 查询订单
	 * 返回数据：{"alipay_trade_query_response":{"code":"10000","msg":"Success","buyer_logon_id":"yrf***@sandbox.com","buyer_pay_amount":"0.00","buyer_user_id":"2088102176107430","buyer_user_type":"PRIVATE","invoice_amount":"0.00","out_trade_no":"20181024175820713","point_amount":"0.00","receipt_amount":"0.00","send_pay_date":"2018-10-24 18:27:23","total_amount":"0.01","trade_no":"2018102422001407430500470221","trade_status":"TRADE_SUCCESS"},"sign":"pN8wxRIuIXldffh3/i4OFxi+KUb5u1vsKU5eBjn8ltc2wdUX63nrsevMB4wrAsJjni6XD81qjR7cfKiD8A9nhKojT7uuo7NlzK6j1gw3mFP+usG1fkxvIuo1LdFy83cLHRZzZGxEIePq0k204btWAdzUslDr6ixGKuDaYRmwUfSITjp5JlTCcTwCJFof+nGFUDpVJh8e686r55TckRNz4RNfexmQILEqkYP00VgEkIc9Zf6h0jZqWKu9nByKqbfWOlG0vhaRzLTZeo6UfKX+XvriZQb1jr7/Gvp62AMLOOa1C0P4SNrPA0q0KAHJAudF1ULS00TH4iZCIMuWdPQ73A=="}
	 * 错误数据：{"alipay_trade_query_response":{"code":"40004","msg":"Business Failed","sub_code":"ACQ.TRADE_NOT_EXIST","sub_msg":"交易不存在","buyer_pay_amount":"0.00","invoice_amount":"0.00","out_trade_no":"20181024175820711","point_amount":"0.00","receipt_amount":"0.00"},"sign":"iZGa0UE/aPUhLbxVEeYsf65sN9/dq3Q6+5eYjdg6PnTAbZrAfUHiMjOb60ufwzbbajPZ5RfXqesl9YAJhlzt8W0fuJDFV9tWN0Wj2g2emBrUxQxhi6ISPpynlBTmtA7KEcoNWJCbPuEgwgxQaG9p4ForTml0JaUYW7VwFFy02OvhMnCawFUOCZl/Syqo5OckhXunfRCkd9bN2PGu73e3Nj9/YwYvw1eZRQ64Z6QtRFFtBZ7lvz7L9tXMt/zsGqDhpfURGqMlZ6XR1k+o5SzhZJilAiYpWliptQqM37HHWe6ZlzNPnUx0t1fXHZKUCKXVyEl95dnzD237OvcmT8ZN1g=="}
	 * */
	public static String aliPagePayQuery(String out_trade_no, String trade_no) throws Exception{
		Map<String, String> param = new HashMap<String, String>();
				
		//设置请求参数
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
		
		//商户订单号，商户网站订单系统中唯一订单号
		if(! out_trade_no.isEmpty())
			param.put("out_trade_no", new String(out_trade_no.getBytes("ISO-8859-1"),"UTF-8"));
		
		//支付宝交易号
		if(! trade_no.isEmpty())
			param.put("trade_no", new String(out_trade_no.getBytes("ISO-8859-1"),"UTF-8"));
		
		alipayRequest.setBizContent(JSONObject.toJSONString(param));
		return alipayClient.execute(alipayRequest).getBody();
	}
	
	/*
	 * 退款
	 * 返回数据：{"alipay_trade_refund_response":{"code":"40004","msg":"Business Failed","sub_code":"ACQ.TRADE_NOT_EXIST","sub_msg":"交易不存在","refund_fee":"0.00","send_back_fee":"0.00"},"sign":"Wlof9jbiklxMuFxnCisrlwbBlBwQNNixzf0KEwjAHiP6Y1GhIuEcycSaCvF8Wz7JWBxfSYQ0BWpEhx/5NKizOE51oKiQjsQ4O0fxxxmdd1OUgA1/c+cXqTgqgXSiN4dCKcWaM5AuMtCsE4s32Hh6W7KbcRLl5WRiAvGqpNmfqBxAH0XHvrCEt9IiNFgKidPMK8UH2N/reI9BoaRfbMq6wt4qtU2SJMD5r9UhG2dBZ2SdGLZlawcwto9W/mb+KTaJZ2fa10sWw+ZUz3S/vr2dVfSpLsXROorkfumsa+lJmr9nt/SppOQgyBPN2glQImJ5qobIWXS9i81DxeOZ2FCjRQ=="}
	 * */
	public static void aliPageRefund(String out_trade_no, String trade_no, String refundAmount, String refundReason, String out_request_no) throws Exception{
		Map<String, String> param = new HashMap<String, String>();
	
		//设置请求参数
		AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
		
		//商户订单号，商户网站订单系统中唯一订单号
		if(! out_trade_no.isEmpty())
			param.put("out_trade_no", new String(out_trade_no.getBytes("ISO-8859-1"),"UTF-8"));
		
		//支付宝交易号
		if(! trade_no.isEmpty())
			param.put("trade_no", new String(out_trade_no.getBytes("ISO-8859-1"),"UTF-8"));
		
		param.put("refund_amount", new String(refundAmount.getBytes("ISO-8859-1"),"UTF-8"));	//需要退款的金额，该金额不能大于订单金额，必填
		param.put("refund_reason", new String(refundReason.getBytes("ISO-8859-1"),"UTF-8"));	//退款的原因说明
		
		//标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
		if(! out_request_no.isEmpty())
			param.put("out_request_no", new String(out_request_no.getBytes("ISO-8859-1"),"UTF-8"));
		
		alipayRequest.setBizContent(JSONObject.toJSONString(param));
		String request = alipayClient.execute(alipayRequest).getBody();
		
		JSONObject one = JSONObject.parseObject(request);
		JSONObject second = JSONObject.parseObject(one.getString("alipay_trade_refund_response"));
		
		if(! second.getString("code").equals("10000")){
			throw new AlertException(second.getString("sub_msg"));
		}
	}
	
	/*
	 * 退款查询
	 * 返回数据：{"alipay_trade_fastpay_refund_query_response":{"code":"10000","msg":"Success"},"sign":"ioWHRk6KDR0x8Pa8C4mNWRewJW3iDzs1FhTNm1rH+t91hySupY03nrPp09hBL3Ot9xsJfboIq8Bbrv2EAAUBkd/8oK/qy2wZ3qIfaCldc9DVVHg6Py34fLFubrdnULPmwXFAHLjWdSgCBbrnJUFPWnPalMU2uz/E8OZBbIWR+R6U7KdKfbrvIiK05e5+KfVmfNomF5onamtQyHPI5WD75EDJ/GFefVgiDmjBAzRY9HSgIwfDyrUAHpHbke8AVYVnZtRGfiCAwTNhJcFQMUWnjKRwo2nbYRBTaz++zeddRL//Jv3eiWVn2GLiebcYSvKDRRfPPHITr25pGQ2E7MRStw=="}
	 * */
	public static String aliPageRefundQuery(String out_trade_no, String trade_no, String out_request_no) throws Exception{
		Map<String, String> param = new HashMap<String, String>();
	
		//设置请求参数
		AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();
		
		//商户订单号，商户网站订单系统中唯一订单号
		if(! out_trade_no.isEmpty())
			param.put("out_trade_no", new String(out_trade_no.getBytes("ISO-8859-1"),"UTF-8"));
		
		//支付宝交易号
		if(! trade_no.isEmpty())
			param.put("trade_no", new String(out_trade_no.getBytes("ISO-8859-1"),"UTF-8"));

		//请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填
		param.put("out_request_no", new String(out_request_no.getBytes("ISO-8859-1"),"UTF-8"));
		
		alipayRequest.setBizContent(JSONObject.toJSONString(param));
		return alipayClient.execute(alipayRequest).getBody();
	}
	
	/*
	 * 回调函数验证签名
	 * */
	public static boolean rsaCheckV1(Map<String,String> param) throws Exception{
		
		return AlipaySignature.rsaCheckV1(param, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
	}
	
	/*
	 * 关闭订单
	 * */
	public static String aliPagePayClose(String out_trade_no, String trade_no) throws Exception{
		Map<String, String> param = new HashMap<String, String>();
				
		//设置请求参数
		AlipayTradeCloseRequest alipayRequest = new AlipayTradeCloseRequest();
		
		//商户订单号，商户网站订单系统中唯一订单号
		if(! out_trade_no.isEmpty())
			param.put("out_trade_no", new String(out_trade_no.getBytes("ISO-8859-1"),"UTF-8"));
		
		//支付宝交易号
		if(! trade_no.isEmpty())
			param.put("trade_no", new String(out_trade_no.getBytes("ISO-8859-1"),"UTF-8"));
		
		alipayRequest.setBizContent(JSONObject.toJSONString(param));
		return alipayClient.execute(alipayRequest).getBody();
	}
}
