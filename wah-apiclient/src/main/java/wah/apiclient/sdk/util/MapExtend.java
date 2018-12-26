package wah.apiclient.sdk.util;

import java.util.Map;
import java.util.Map.Entry;

public class MapExtend {
	/**
     * 凑成xml格式字符串
     *
     * @return
     */
	public static String MapToXML(Map<String, Object> map) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("<xml>");

        for (Entry<String, Object> entry : map.entrySet()) {
        	String key = entry.getKey();
        	String value = entry.getValue().toString();
        	
        	if(entry.getKey().toString().equals("consume_mch_id"))
        		System.out.print(entry.getKey());
        	
    		sb.append("<" + key + ">" + value + "</" + key + ">");
        }

        sb.append("</xml>");
        
        return sb.toString();
    }
}
