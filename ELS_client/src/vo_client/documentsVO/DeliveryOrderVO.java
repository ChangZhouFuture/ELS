package vo_client.documentsVO;

import java.util.ArrayList;

public class DeliveryOrderVO {
	String couriername;
	String deliverierid;
	String date;
	ArrayList<String> orsderidlist;
	String id;
	public DeliveryOrderVO(String id,ArrayList<String> orsderidlist,String deliveriername,String deliverierid,String date){
		this.id=id;
		this.orsderidlist=orsderidlist;
		this.couriername=deliveriername;
		this.deliverierid=deliverierid;
		this.date=date;
		
	}
	public String getDeliveriername(String deliverierid) {
		return couriername;
	}
	public void setDeliveriername(String deliveriername) {
		this.couriername = deliveriername;
	}
	public String getDeliverierid() {
		return deliverierid;
	}
	public void setDeliverierid(String deliverierid) {
		this.deliverierid = deliverierid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<String> getOrsderidlist() {
		return orsderidlist;
	}
	public void setOrsderidlist(ArrayList<String> orsderidlist) {
		this.orsderidlist = orsderidlist;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
