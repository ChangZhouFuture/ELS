package po.utilityPO;

import java.io.Serializable;

public class LogisticsInforPO implements Serializable{

	private String id;
	private String generateTime;
	private String descripition;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
	}
	public String getDescripition() {
		return descripition;
	}
	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}
	
	
}
