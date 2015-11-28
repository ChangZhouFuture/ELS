package bean;

import state.ResultMessage;

public class JavaBean2 {
	private String name;
	private String agencyID;
	private ResultMessage resultMessage;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ResultMessage getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
	public String getAgencyID() {
		return agencyID;
	}
	public void setAgencyID(String agencyID) {
		this.agencyID = agencyID;
	}
}
