package vo_client.lineitemVO.documentslineitemVO;

import java.io.Serializable;
import java.util.ArrayList;

import vo_client.lineitemVO.ParentlineitemVO;

public class PaymentOrderlineitemVO extends ParentlineitemVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8345248940752949681L;
	String date4PaymentOrder;
	String amount4PaymentOrder;
	String remitter;
	String account4PaymentOrder;
	ArrayList<String>  item4Vehicles;
	ArrayList<String> remark1;
	ArrayList<String> remark2;
	public PaymentOrderlineitemVO(String date4PaymentOrder, String amount4PaymentOrder, String remitter, String account4PaymentOrder,ArrayList<String>  item4Vehicles,ArrayList<String> remark1,ArrayList<String> remark2){
		super();
		this.date4PaymentOrder = date4PaymentOrder;
		this.amount4PaymentOrder = amount4PaymentOrder;
		this.remitter = remitter;
		this.account4PaymentOrder = account4PaymentOrder;
		this.item4Vehicles = item4Vehicles;
		this.remark1 = remark1;
		this.remark2 = remark2;
	}
	public String date4PaymentOrder() {
		return this.date4PaymentOrder;
	}
	public void setdate4PaymentOrder(String date4PaymentOrder) {
		this.date4PaymentOrder = date4PaymentOrder;
	}
	public String getamount4PaymentOrder() {
		return this.amount4PaymentOrder;
	}
	public void setamount4PaymentOrder(String amount4PaymentOrder) {
		this.amount4PaymentOrder = amount4PaymentOrder;
	}
	public String getremitter() {
		return this.remitter;
	}
	public void setremitter(String remitter) {
		this.remitter = remitter;
	}
	public String getaccount4PaymentOrder() {
		return this.account4PaymentOrder;
	}
	public void setaccount4PaymentOrder(String account4PaymentOrder) {
		this.account4PaymentOrder = account4PaymentOrder;
	}
	public ArrayList<String> getitem4Vehicles() {
		return this.item4Vehicles;
	}
	public void setitem4Vehicles(ArrayList<String> item4Vehicles) {
		this.item4Vehicles = item4Vehicles;
	}
	public ArrayList<String> getremark1() {
		return this.remark1;
	}
	public void setremark1(ArrayList<String> remark1) {
		this.remark1 = remark1;
	}
	public ArrayList<String> getremark2() {
		return this.remark2;
	}
	public void setremark2(ArrayList<String> remark2) {
		this.remark2 = remark2;
	}
}
