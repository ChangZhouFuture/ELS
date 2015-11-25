package businesslogic_client.utilitybl;

import state.ResultMessage;

public class JavaBean {
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
