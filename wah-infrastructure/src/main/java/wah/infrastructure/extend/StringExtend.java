package wah.infrastructure.extend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringExtensions {	
	
	public static String DateFormat(Date date, String formate){
		
		SimpleDateFormat df = new SimpleDateFormat(formate);  
		return df.format(date);
	}
}
