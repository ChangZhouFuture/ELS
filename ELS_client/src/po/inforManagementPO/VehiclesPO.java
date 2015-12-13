package po.inforManagementPO;

import java.io.Serializable;


public class VehiclesPO implements Serializable{
	private String ID;
    private	String plateNum;
	private String serviceTime;
	private String busiHallID;
	
	public String getBusiHallID() {
		return busiHallID;
	}
	public void setBusiHallID(String busiHallID) {
		this.busiHallID = busiHallID;
	}
	public String getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	
	
}
