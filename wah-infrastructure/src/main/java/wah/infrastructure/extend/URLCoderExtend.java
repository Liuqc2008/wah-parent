package wah.infrastructure.extend;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLCoderExtend {

	public static String UrlEncode(String url) throws Exception {
		return URLCoderExtend.UrlEncode(url, "UTF-8");
	}

	public static String UrlEncode(String url, String charset) throws Exception {
		return URLEncoder.encode(url, charset);
	}

	public static String UrlDecoder(String url) throws Exception {
		return URLCoderExtend.UrlDecoder(url, "UTF-8");
	}

	public static String UrlDecoder(String url, String charset) throws Exception {
		return URLDecoder.decode(url, charset);
	}
}
