package vo_client.documentsVO;

import vo_client.ParentVO;
import java.util.ArrayList;

import state.TransportType;
import vo_client.ParentVO;
 
public class TransferOrderVO extends ParentVO{
 
	String id;
	TransportType transporttype;
	String startaddress;
	String endaddress;
	ArrayList<String> orderidlist;
	String date;
	String hangbanid;
	String huoguiid;
	String Jianzhuangyyuan;
	public TransferOrderVO(String id, TransportType transporttype,
			String startaddress, String endaddress,
			ArrayList<String> orderidlist, String date, String hangbanid,
			String huoguiid, String Jianzhuangyyuan) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.transporttype=transporttype;
		this.startaddress=startaddress;
		this.endaddress=endaddress;
		this.orderidlist=orderidlist;
		this.date=date;
		this.hangbanid=hangbanid;
		this.huoguiid=huoguiid;
		this.Jianzhuangyyuan=Jianzhuangyyuan;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TransportType getTransporttype() {
		return transporttype;
	}
	public void setTransporttype(TransportType transporttype) {
		this.transporttype = transporttype;
	}
	public String getStartaddress() {
		return startaddress;
	}
	public void setStartaddress(String startaddress) {
		this.startaddress = startaddress;
	}
	public String getEndaddress() {
		return endaddress;
	}
	public void setEndaddress(String endaddress) {
		this.endaddress = endaddress;
	}
	public ArrayList<String> getOrderidlist() {
		return orderidlist;
	}
	public void setOrderidlist(ArrayList<String> orderidlist) {
		this.orderidlist = orderidlist;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHangbanid() {
		return hangbanid;
	}
	public void setHangbanid(String hangbanid) {
		this.hangbanid = hangbanid;
	}
	public String getHuoguiid() {
		return huoguiid;	
	}
	public void setHuoguiid(String huoguiid) {
		this.huoguiid = huoguiid;
	}
	public String getJianzhuangyyuan() {
		return Jianzhuangyyuan;
	}
	public void setJianzhuangyyuan(String jianzhuangyyuan) {
		Jianzhuangyyuan = jianzhuangyyuan;
	}

 }
