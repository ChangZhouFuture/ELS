package po_client.inforManagementPO;

import java.io.Serializable;

public class DriversPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8345248940752949681L;
	String driverID;
	String driverName;
	String driverDob;
	String driverIdNum;
	String driverCPN;
	String VehicleUnit;
	String driverSex;
	String driverDLP;
	public DriversPO(String id, String driverName, String driverDob, String driverIdNum,String driverCPN,String VehicleUnit,String driverSex,String driverDLP){
		super();
		this.driverID = driverID;
		this.driverName = driverName;
		this.driverDob = driverDob;
		this.driverIdNum = driverIdNum;
		this.driverCPN = driverCPN;
		this.VehicleUnit = VehicleUnit;
		this.driverSex = driverSex;
		this.driverDLP = driverDLP;
	}
	public String getdriverID() {
		return this.driverID;
	}
	public void setdriverID(String driverID) {
		this.driverID = driverID;
	}
	public String getdriverName() {
		return this.driverName;
	}
	public void setdriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getdriverDob() {
		return this.driverDob;
	}
	public void setdriverDob(String driverDob) {
		this.driverDob = driverDob;
	}
	public String getdriverIdNum() {
		return this.driverIdNum;
	}
	public void setdriverIdNum(String driverIdNum) {
		this.driverIdNum = driverIdNum;
	}
	public String getdriverCPN() {
		return this.driverCPN;
	}
	public void setdriverCPN(String driverCPN) {
		this.driverCPN = driverCPN;
	}
	public String getVehicleUnit() {
		return this.VehicleUnit;
	}
	public void setVehicleUnit(String VehicleUnit) {
		this.VehicleUnit = VehicleUnit;
	}
	public String getdriverSex() {
		return this.driverSex;
	}
	public void setdriverSex(String driverSex) {
		this.driverSex = driverSex;
	}
	public String getdriverDLP() {
		return this.driverDLP;
	}
	public void setdriverDLP(String driverDLP) {
		this.driverDLP = driverDLP;
	}
}
