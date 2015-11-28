package bean;

import state.ResultMessage;

public class JavaBean1 {
	private Object VOObject;
	private ResultMessage resultMessage;
	
	public Object getVOObject() {
		return VOObject;
	}
	public void setvOObject(Object VOObject) {
		this.VOObject = VOObject;
	}
	public ResultMessage getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
}
