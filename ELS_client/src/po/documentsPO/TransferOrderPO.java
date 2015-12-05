package po.documentsPO;

import java.io.Serializable;
import java.util.ArrayList;

import state.ApproState;
import state.TransportType;

 
 public class TransferOrderPO implements Serializable{
 
	 private String ID;
		private String loadingDate;
		private TransportType transportType;
		private String vehicleNum;
		private String origin;
		private String destination;
		private String containerNum;
		private String supervisionMan;
		ArrayList<String> orderIDs=new ArrayList<>();
		private double carriage;
		private String generateTime;
		private ApproState approState;
		public TransportType getTransportType() {
			return transportType;
		}
		public void setTransportType(TransportType transportType) {
			this.transportType = transportType;
		}
		public String getVehicleNum() {
			return vehicleNum;
		}
		public void setVehicleNum(String vehicleNum) {
			this.vehicleNum = vehicleNum;
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
		public String getContainerNum() {
			return containerNum;
		}
		public void setContainerNum(String containerNum) {
			this.containerNum = containerNum;
		}
		public String getSupervisionMan() {
			return supervisionMan;
		}
		public void setSupervisionMan(String supervisionMan) {
			this.supervisionMan = supervisionMan;
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
 }
