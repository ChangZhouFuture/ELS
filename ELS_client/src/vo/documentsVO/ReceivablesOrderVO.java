package vo.documentsVO;

import java.util.ArrayList;

public class ReceivablesOrderVO {
	 private String ID;
	    private double amount;
	    private String courier;
	    ArrayList<String> orderIDs=new ArrayList<>();
	    private String date;
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
