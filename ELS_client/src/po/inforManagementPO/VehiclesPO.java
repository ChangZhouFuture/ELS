package po.inforManagementPO;

import java.io.Serializable;


public class VehiclesPO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String ID;
    private	String plateNum;
	private String serviceTime;
	private String city;
	private String region;
	
	public String getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
