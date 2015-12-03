package businesslogic.utilitybl;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Time {
	static public String generateDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String s = dateFormat.format(date);
		return s;
	}
	
	public static void main(String[] args) {
		Time time = new Time();
		
	}
}
