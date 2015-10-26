package vo_client.documentsVO;

import java.util.ArrayList;

import vo_client.ParentVO;

public class LoadingListVO extends ParentVO{

	String id;
	String busihallid;
	String tranloadid;
	String endaddress;
	ArrayList<String> orderidlist;
	String date;
	String vehicleid;
	int fare;
	String Jianzhuangyuan;
	String Yayunyuan;
	LoadingListVO ll;
	public LoadingListVO(String id, String busihallid, String tranloadid,
			String endaddress, ArrayList<String> orderidlist, String date,
			String vehicleid, int fare, String Jianzhuangyuan, String Yayunyuan) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.busihallid=busihallid;
		this.tranloadid=tranloadid;
		this.endaddress=endaddress;
		this.orderidlist=orderidlist;
		this.date=date;
		this.vehicleid=vehicleid;
		this.fare=fare;
		this.Jianzhuangyuan=Jianzhuangyuan;
		this.Yayunyuan=Yayunyuan;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBusihallid() {
		return busihallid;
	}
	public void setBusihallid(String busihallid) {
		this.busihallid = busihallid;
	}
	public String getTranloadid() {
		return tranloadid;
	}
	public void setTranloadid(String tranloadid) {
		this.tranloadid = tranloadid;
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
	public String getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getJianzhuangyuan() {
		return Jianzhuangyuan;
	}
	public void setJianzhuangyuan(String jianzhuangyuan) {
		Jianzhuangyuan = jianzhuangyuan;
	}
	public String getYayunyuan() {
		return Yayunyuan;
	}
	public void setYayunyuan(String yayunyuan) {
		Yayunyuan = yayunyuan;
	}
	public LoadingListVO getLl() {
		return ll;
	}
	public void setLl(LoadingListVO ll) {
		this.ll = ll;
	}

}
