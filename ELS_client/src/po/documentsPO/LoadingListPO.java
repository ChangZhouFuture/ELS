package po.documentsPO;

import java.io.Serializable;

import java.io.Serializable;
import java.util.ArrayList;
 
 public class LoadingListPO implements Serializable{
 
	String id;
	String bhid;
	String tlid;
	String ea;
	ArrayList<String> oidl;
	String d;
	String vid;
	int f;
	String Jzy;
	String Yyy;
	
	public LoadingListPO(String id,String bhid,String tlid,String ea,ArrayList<String> oidl,String d,String vid,int f,String Jzy,String Yyy){
		this.id=id;
		this.bhid=bhid;
		this.tlid=tlid;
		this.ea=ea;
		this.oidl=oidl;
		this.d=d;
		this.vid=vid;
		this.f=f;
		this.Jzy=Jzy;
		this.Yyy=Yyy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBhid() {
		return bhid;
	}

	public void setBhid(String bhid) {
		this.bhid = bhid;
	}

	public String getTlid() {
		return tlid;
	}

	public void setTlid(String tlid) {
		this.tlid = tlid;
	}

	public String getEa() {
		return ea;
	}

	public void setEa(String ea) {
		this.ea = ea;
	}

	public ArrayList<String> getOidl() {
		return oidl;
	}

	public void setOidl(ArrayList<String> oidl) {
		this.oidl = oidl;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public String getJzy() {
		return Jzy;
	}

	public void setJzy(String jzy) {
		Jzy = jzy;
	}

	public String getYyy() {
		return Yyy;
	}

	public void setYyy(String yyy) {
		Yyy = yyy;
	}
 }
