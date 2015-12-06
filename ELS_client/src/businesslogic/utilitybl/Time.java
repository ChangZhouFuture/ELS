package businesslogic.utilitybl;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Time {
	private static DateFormat dateFormat;
	private static Date date = new Date();
	
	static public String generateDate() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String s = dateFormat.format(date);
		return s;
	}
	
	static public String generateTime() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = dateFormat.format(date);
		return s;
	}
	
}
