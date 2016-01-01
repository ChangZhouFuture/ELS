package po.lineitemPO.documentslineitemPO;

import java.io.Serializable;
import state.ApproState;
import state.TransportType;

public class TransferOrderlineitemPO implements Serializable{
	private String id;
	private String date;
	private String origin;
	private String destination;
	private String vehiclesNum;
	private double carriage;
	private TransportType transportType;
	private ApproState approState;
	
	public ApproState getApproState() {
		return approState;
	}
	public void setApproState(ApproState approState) {
		this.approState = approState;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getVehiclesNum() {
		return vehiclesNum;
	}
	public void setVehiclesNum(String vehiclesNum) {
		this.vehiclesNum = vehiclesNum;
	}
	public double getCarriage() {
		return carriage;
	}
	public void setCarriage(double carriage) {
		this.carriage = carriage;
	}
	public TransportType getTransportType() {
		return transportType;
	}
	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}
	
}
