package bean;

import state.ResultMessage;

public class JavaBean1 {
	private Object POObject;
	private ResultMessage resultMessage;
	public Object getPOObject() {
		return POObject;
	}
	public void setPOObject(Object pOObject) {
		POObject = pOObject;
	}
	public ResultMessage getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
	
}
