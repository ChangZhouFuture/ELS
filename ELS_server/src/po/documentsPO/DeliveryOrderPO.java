package po.documentsPO;

import java.io.Serializable;

import java.util.ArrayList;

public class DeliveryOrderPO implements Serializable{

	String id;
	ArrayList<String> orsderidlist;
	String dn;
	String did;
	String d;
	public DeliveryOrderPO(String id,ArrayList<String> orsderidlist,String dn,String did,String d){
		this.id=id;
		this.orsderidlist=orsderidlist;
		this.dn=dn;
		this.did=did;
		this.d=d;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<String> getOrsderidlist() {
		return orsderidlist;
	}
	public void setOrsderidlist(ArrayList<String> orsderidlist) {
		this.orsderidlist = orsderidlist;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
}
