package bean;

import java.io.Serializable;
import java.util.ArrayList;
import state.ResultMessage;

public class JavaBean4 implements Serializable{
	private boolean isAlarm;
	private ResultMessage resultMessage;
	private ArrayList<String> AlarmArea;
	
	public boolean isAlarm() {
		return isAlarm;
	}
	public void setAlarm(boolean isAlarm) {
		this.isAlarm = isAlarm;
	}
	public ArrayList<String> getAlarmArea() {
		return AlarmArea;
	}
	public void setAlarmArea(ArrayList<String> alarmArea) {
		AlarmArea = alarmArea;
	}
	public ResultMessage getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
	
}
