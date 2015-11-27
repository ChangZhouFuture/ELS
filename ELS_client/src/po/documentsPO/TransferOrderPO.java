package po.documentsPO;

import java.io.Serializable;
import java.util.ArrayList;

 
 public class TransferOrderPO implements Serializable{
 
	 private String ID;
		private String loadingDate;
		private String flightNum;
		private String origin;
		private String destination;
		private String containerNum;
		private String supervisionMan;
		ArrayList<String> orderIDs=new ArrayList<>();
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
		public String getFlightNum() {
			return flightNum;
		}
		public void setFlightNum(String flightNum) {
			this.flightNum = flightNum;
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
 }
