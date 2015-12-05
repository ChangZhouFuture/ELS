package po.lineitemPO.documentslineitemPO;

import java.io.Serializable;

import state.ApproState;
import state.TransportType;

public class TransferOrderlineitemPO implements Serializable{
	private String ID;
	private String loadingDate;
	private String destination;
	private String vehicleNum;
	private double carriage;
	private TransportType tranType;
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
	public double getCarriage() {
		return carriage;
	}
	public void setCarriage(double carriage) {
		this.carriage = carriage;
	}
	public TransportType getTranType() {
		return tranType;
	}
	public void setTranType(TransportType tranType) {
		this.tranType = tranType;
	}
	public String getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
}
