package wah.weixinapi.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.*;

public class PayTest {
	private static WXPay wxPay;
	
	static {
		try{
			wxPay = new WXPay(new IWxPayConfig());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 统一下单接口（当前参数   网页扫描支付）
	 * */
	@Ignore
	@Test
	public void unifiedOrder() throws Exception {
		Map<String, String> param = new HashMap<String, String>();
		String orderNo= (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		param.put("body", "腾讯充值中心-QQ会员充值");		//商品简单描述，该字段请按照规范传递，具体请见参数规定
		param.put("out_trade_no",orderNo);				//商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。详见商户订单号
		param.put("total_fee","2");						//订单总金额，单位为分，详见支付金额
		param.put("spbill_create_ip","127.0.0.1");		//APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
		param.put("notify_url","http://www.home-h.com/Payment/WxNotify");	//异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
		param.put("trade_type","NATIVE");				//JSAPI 公众号支付   NATIVE 扫码支付   APP APP支付
		
		Map<String, String> result = wxPay.unifiedOrder(param);
		
		System.out.println(JSONObject.toJSONString(result));
	}
	
	/*
	 * 查询支付状态接口
	 * */
	@Ignore
	@Test
	public void OrderQuery()throws Exception {
		Map<String, String> param = new HashMap<String, String>();
		param.put("out_trade_no", "20181023175400902");
	  //param.put("transaction_id", "20181023175400902");
		
		
		Map<String, String> result = wxPay.orderQuery(param);
		System.out.println(JSONObject.toJSONString(result));
	}
	
	/*
	 * 退款接口
	 * */
	@Ignore
	@Test
	public void Refund()throws Exception {
		Map<String, String> param = new HashMap<String, String>();
		param.put("out_trade_no", "20181023175400902");
		param.put("out_refund_no", "20181023175400902");
		param.put("total_fee", "2");
		param.put("refund_fee", "2");
		
		
		Map<String, String> result = wxPay.refund(param);
		System.out.println(JSONObject.toJSONString(result));
		
	}
	
	/*
	 * 退款查询接口
	 * */
	@Ignore
	@Test
	public void RefundQuery()throws Exception {
		Map<String, String> param = new HashMap<String, String>();
		param.put("out_trade_no", "20181023175400902");
		
		
		Map<String, String> result = wxPay.refundQuery(param);
		System.out.println(JSONObject.toJSONString(result));
	}
}
