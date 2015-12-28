package vo.documentsVO;

import java.util.ArrayList;

import state.ApproState;

public class ReceivablesOrderVO {
		private String ID;
	    private String date;
	    private String courier;
	    private String generateTime;
	    private String agencyID;
	    ArrayList<String> orderIDs;
	    private double amount;
	    private ApproState approState;
	    
		public String getAgencyID() {
			return agencyID;
		}
		public void setAgencyID(String agencyID) {
			this.agencyID = agencyID;
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
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getCourier() {
			return courier;
		}
		public void setCourier(String courier) {
			this.courier = courier;
		}
		public ArrayList<String> getOrderIDs() {
			return orderIDs;
		}
		public void setOrderIDs(ArrayList<String> orderIDs) {
			this.orderIDs = orderIDs;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
}
