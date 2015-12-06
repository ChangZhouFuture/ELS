package bean;

import java.io.Serializable;

import state.Position;
import state.ResultMessage;

public class JavaBean2 implements Serializable{
	private String name;
	private String agencyID;
	private Position position;
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
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
}
