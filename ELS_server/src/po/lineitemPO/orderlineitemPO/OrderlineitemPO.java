package po.lineitemPO.orderlineitemPO;

import java.io.Serializable;

import state.ApproState;
import state.ExpressType;

public class OrderlineitemPO implements Serializable{
	private String id;
	private String date;
	private String senderAdd;
	private String AddresseeAdd;
	private double totalCost;
    private ExpressType expressType;
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
	
	public String getSenderAdd() {
		return senderAdd;
	}
	public void setSenderAdd(String senderAdd) {
		this.senderAdd = senderAdd;
	}
	public String getAddresseeAdd() {
		return AddresseeAdd;
	}
	public void setAddresseeAdd(String addresseeAdd) {
		AddresseeAdd = addresseeAdd;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public ExpressType getExpressType() {
		return expressType;
	}
	public void setExpressType(ExpressType expressType) {
		this.expressType = expressType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
