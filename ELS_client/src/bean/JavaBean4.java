package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class JavaBean4 implements Serializable{
	private boolean isAlarm;
	private ArrayList<String> area;
	
	public boolean isAlarm() {
		return isAlarm;
	}
	public void setAlarm(boolean isAlarm) {
		this.isAlarm = isAlarm;
	}
	public ArrayList<String> getArea() {
		return area;
	}
	public void setArea(ArrayList<String> area) {
		this.area = area;
	}
	
}
