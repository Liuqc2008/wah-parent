package wah.infrastructure.extend;

import java.util.HashMap;
import java.util.Map;

public class MapExtensions {

	public static Map<String, Object> StringUrlParamToMap(String urlParam) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		String[] param = urlParam.split("&");

		for (String keyvalue : param) {
			String[] pair = keyvalue.split("=");

			if (pair.length == 2) {
				if (pair[0].indexOf("key") >= 0)
					pair[0] = pair[0].replace("key[", "").replace("]", "");

				if (pair[0].equals("page") || pair[0].equals("limit"))
					hashMap.put(pair[0], Integer.parseInt(pair[1]));
				else
					hashMap.put(pair[0], pair[1]);
			}
		}

		return hashMap;
	}
}
