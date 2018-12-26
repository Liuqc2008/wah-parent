package wah.apiclient.sdk.util;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class CommonUtil {
	
	/**
     * 获取UUID
     * @return
     */
    public static String GetRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    /*
     * 
     * */
    public static String MapToUrlParam(Map<String, Object> map) {
    	if (map == null) {
            return "";
        }
    	
    	StringBuffer sb = new StringBuffer();
        map = new TreeMap<String, Object>(map);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if(entry.getValue() == null){
                continue;
            }
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        
        if (s.endsWith("&")) {
            s = StringUtils.substringBeforeLast(s, "&");
        }
        return s;
    }
}
