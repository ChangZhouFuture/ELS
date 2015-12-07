package po.utilityPO;

import java.io.Serializable;

import state.OperaType;

public class OperaLogPO implements Serializable{

	private OperaType operaType;
	private String date;
	private String objectType;
	private String id;
	private String operatorId;
	private String generateTime;
	public OperaType getOperaType() {
		return operaType;
	}
	public void setOperaType(OperaType operaType) {
		this.operaType = operaType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
	}
	
	
}
