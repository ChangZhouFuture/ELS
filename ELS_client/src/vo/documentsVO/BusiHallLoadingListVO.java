package vo.documentsVO;

import java.util.ArrayList;

import state.ApproState;
 
 public class BusiHallLoadingListVO {
	 	private String ID;
	    private String loadingDate;
	    private String generateTime;
	    private String busiHallID;
	    private String truckNum;
	    private String destination;
	    private String vehiclesID;
	    private String supervisionMan;
	    private String escortMan;
	    ArrayList<String> orderIDs;
	    private double carriage;
	    private ApproState approState;
	    
		public String getGenerateTime() {
			return generateTime;
		}
		public void setGenerateTime(String generateTime) {
			this.generateTime = generateTime;
		}
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
		public String getBusiHallID() {
			return busiHallID;
		}
		public void setBusiHallID(String busiHallID) {
			this.busiHallID = busiHallID;
		}
		public String getTruckNum() {
			return truckNum;
		}
		public void setTruckNum(String truckNum) {
			this.truckNum = truckNum;
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
