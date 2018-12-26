package wah.infrastructure.extend;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectExtension extends Object{
	
	/*
	 * formate "yyyy-MM-dd HH:mm:ss"
	 */
	public static Date StringToDate(String object, String formate) throws ParseException{
		DateFormat dateFormat2 = new SimpleDateFormat(formate);
		return dateFormat2.parse(object);
	}
}
