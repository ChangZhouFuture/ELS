package po.documentsPO;

import java.io.Serializable;
import java.util.ArrayList;

import state.ApproState;

public class ReceivablesOrderPO implements Serializable{
	    private double amount;
	    private String ID;
	    private String courier;
	    private String date;
	    private String generateTime;
	    private String agencyID;
	    ArrayList<String> orderIDs;
	    private ApproState approState;
	    
		public String getAgencyID() {
			return agencyID;
		}
		public void setAgencyID(String agencyID) {
			this.agencyID = agencyID;
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
