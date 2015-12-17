package businesslogic.utilitybl;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Time {
	private static DateFormat dateFormat;
	private static Date date = new Date();
	
	public static String generateDate() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String s = dateFormat.format(date);
		return s;
	}
	
	static public String generateTime() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = dateFormat.format(date);
		return s;
	}
	
	public static ArrayList<String> getEveryDay(String beginDate, String endDate) 
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy--MM--dd");
		Date before;
		Date after;
		Date d1;
		Date d2;
		
		d1 = sdf.parse(beginDate);
		d2 = sdf.parse(endDate);
		if (d1.before(d2)) {
			before = d1;
			after = d2;
		} else {
			before = d2;
			after = d1;
		}
		
		ArrayList<String> arrayList = new ArrayList<String>();
		String day;
		for (; before.before(after)||before.equals(after); before = new
				Date(before.getTime() + 24 * 60 * 60 * 1000)) {
			day = sdf.format(before);
			arrayList.add(day);
		}
		
		return arrayList;
	}
	
}
