package po.lineitemPO.documentslineitemPO;

import java.io.Serializable;

import state.ApproState;


public class BusiHallLoadingListlineitemPO implements Serializable{
	private String ID;
	private String loadingDate;
	private String destination;
	private String truckNum;
	private double carriage;
	private ApproState approState;
	
	public ApproState getApproState() {
		return approState;
	}
	public void setApproState(ApproState approState) {
		this.approState = approState;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getLoadingDate() {
		return loadingDate;
	}
	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTruckNum() {
		return truckNum;
	}
	public void setTruckNum(String truckNum) {
		this.truckNum = truckNum;
	}
	public double getCarriage() {
		return carriage;
	}
	public void setCarriage(double carriage) {
		this.carriage = carriage;
	}
	
	
}
