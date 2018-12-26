package wah.weixinapi.test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import wah.apiclient.sdk.weixin.api.RedPackageApi;

public class RedPackageApiTest {
	
	@Ignore
	@Test
	public void SendCashRedPackageTest() throws Exception {
		String orderNo= (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("mch_billno", orderNo);						//商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z）接口根据商户订单号支持重入，如出现超时可再调用。
		param.put("re_openid", "oSU4Bv4yYHK0OaiV_8uy-QVGiKiQ");	//接受红包的用户openid
		param.put("total_amount", 100);							//付款金额，单位分
		param.put("total_num", 1);								//红包发放总人数total_num=1
		param.put("wishing", "萌萌哒");							//红包祝福语
		param.put("client_ip", "127.0.0.1");					//调用接口的机器Ip地址
		param.put("act_name", "桑博红包");						//活动名称
		param.put("remark", "猜越多得越多，快来抢！");			//备注信息
		param.put("scene_id", "PRODUCT_1");						//发放红包使用场景
		
		RedPackageApi.SendCashRedPackage(param);
	
	}
	
	@Ignore
	@Test
	public void SendGroupRedPackTest() throws Exception {
		String orderNo= (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("mch_billno", orderNo);						//商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z）接口根据商户订单号支持重入，如出现超时可再调用。
		param.put("re_openid", "oSU4Bv4yYHK0OaiV_8uy-QVGiKiQ");	//接受红包的用户openid
		param.put("total_amount", 100);							//付款金额，单位分
		param.put("total_num", 3);								//红包发放总人数total_num=1
		param.put("amt_type", "ALL_RAND");						//红包金额设置方式ALL_RAND—全部随机,商户指定总金额和红包发放总人数，由微信支付随机计算出各红包金额
		param.put("wishing", "萌萌哒");							//红包祝福语
		param.put("client_ip", "127.0.0.1");					//调用接口的机器Ip地址
		param.put("act_name", "桑博红包");						//活动名称
		param.put("remark", "猜越多得越多，快来抢！");			//备注信息
		param.put("scene_id", "PRODUCT_1");						//发放红包使用场景
		
		RedPackageApi.SendGroupRedPack(param);
	}
}
