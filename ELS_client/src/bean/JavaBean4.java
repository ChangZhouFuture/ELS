package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class JavaBean4 implements Serializable{
	private boolean ifAlarm;
	private ArrayList<String> area;
	
	public boolean isIfAlarm() {
		return ifAlarm;
	}
	public void setIfAlarm(boolean ifAlarm) {
		this.ifAlarm = ifAlarm;
	}
	public ArrayList<String> getArea() {
		return area;
	}
	public void setArea(ArrayList<String> area) {
		this.area = area;
	}
	
}
