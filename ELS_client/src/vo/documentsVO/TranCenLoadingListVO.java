package vo.documentsVO;

import java.util.ArrayList;

public class TranCenLoadingListVO {
	private String ID;
	private String loadingDate;
	private String tranCenID;
	private String trucksNum;
	private String destination;
	private String vehiclesID;
	private String supervisionMan;
	private String escortMan;
	ArrayList<String>  orderIDs=new ArrayList<>();
	private double carriage;
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
	public String getTranCenID() {
		return tranCenID;
	}
	public void setTranCenID(String tranCenID) {
		this.tranCenID = tranCenID;
	}
	public String getTrucksNum() {
		return trucksNum;
	}
	public void setTrucksNum(String trucksNum) {
		this.trucksNum = trucksNum;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getVehiclesID() {
		return vehiclesID;
	}
	public void setVehiclesID(String vehiclesID) {
		this.vehiclesID = vehiclesID;
	}
	public String getSupervisionMan() {
		return supervisionMan;
	}
	public void setSupervisionMan(String supervisionMan) {
		this.supervisionMan = supervisionMan;
	}
	public String getEscortMan() {
		return escortMan;
	}
	public void setEscortMan(String escortMan) {
		this.escortMan = escortMan;
	}
	public ArrayList<String> getOrderIDs() {
		return orderIDs;
	}
	public void setOrderIDs(ArrayList<String> orderIDs) {
		this.orderIDs = orderIDs;
	}
	public double getCarriage() {
		return carriage;
	}
	public void setCarriage(double carriage) {
		this.carriage = carriage;
	}
}
