package wah.web.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import wah.web.service.PaymentService;

import wah.apiclient.alipay.page.pay.AliPagePayApi;
import wah.infrastructure.exception.AlertException;

@Service
public class PaymentServiceImpl implements PaymentService {

	public String aliPagePay(Map<String, String> param) throws Exception {
		String result = AliPagePayApi.aliPagePay(param.get("out_trade_no"), param.get("total_amount"),
				param.get("subject"), param.get("body"));

		return result;
	}

	public String aliPagePayQuery(Map<String, String> param) throws Exception {
		String result = AliPagePayApi.aliPagePayQuery(param.get("out_trade_no"), param.get("trade_no"));

		return result;
	}

	public String aliPagePayReturn(Map<String, String> param) throws Exception {
		boolean signVerified = AliPagePayApi.rsaCheckV1(param);

		if (signVerified) {

		} else {
			throw new AlertException("验签失败");
		}

		return JSONObject.toJSONString(param);
	}

	public void aliPagePayRefund(Map<String, String> param) throws Exception {

		AliPagePayApi.aliPageRefund(param.get("out_trade_no"), "", param.get("refundAmount"), param.get("refundReason"),
				param.get("out_trade_no"));
	}

	public String aliPagePayRefundQuery(Map<String, String> param) throws Exception {
		String result = AliPagePayApi.aliPageRefundQuery(param.get("out_trade_no"), "", param.get("out_trade_no"));
		return result;
	}

	public String aliPagePayClose(Map<String, String> param) throws Exception {
		String result = AliPagePayApi.aliPagePayClose(param.get("out_trade_no"), param.get("trade_no"));

		return result;
	}
}
