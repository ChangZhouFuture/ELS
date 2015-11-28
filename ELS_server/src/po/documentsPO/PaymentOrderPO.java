package po.documentsPO;

import java.io.Serializable;

public class PaymentOrderPO implements Serializable{
	 private String ID;
	    private String date;
	    private double amount;
	    private String payer;
	    private String bankAccount;
	    private String entry;
	    private String note;
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getPayer() {
			return payer;
		}
		public void setPayer(String payer) {
			this.payer = payer;
		}
		public String getBankAccount() {
			return bankAccount;
		}
		public void setBankAccount(String bankAccount) {
			this.bankAccount = bankAccount;
		}
		public String getEntry() {
			return entry;
		}
		public void setEntry(String entry) {
			this.entry = entry;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
}
