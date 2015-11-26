package po.documentsPO;

import java.io.Serializable;
import java.util.ArrayList;
import state.TransportType;
 
 public class TransferOrderPO implements Serializable{
 
	String id;
	TransportType tst;
	String sa;
	String ea;
	ArrayList<String> oidl;
	String d;
	String hbid;
	String hgid;
	String Jzy;
	
	public TransferOrderPO(String id,TransportType tst,String sa,String ea,ArrayList<String> oidl,String d,String hbid,String hgid,String Jzy){
		this.id=id;
		this.tst=tst;
		this.sa=sa;
		this.ea=ea;
		this.oidl=oidl;
		this.d=d;
		this.hbid=hbid;
		this.hgid=hgid;
		this.Jzy=Jzy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TransportType getTst() {
		return tst;
	}

	public void setTst(TransportType tst) {
		this.tst = tst;
	}

	public String getSa() {
		return sa;
	}

	public void setSa(String sa) {
		this.sa = sa;
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

	public String getHbid() {
		return hbid;
	}

	public void setHbid(String hbid) {
		this.hbid = hbid;
	}

	public String getHgid() {
		return hgid;
	}

	public void setHgid(String hgid) {
		this.hgid = hgid;
	}

	public String getJzy() {
		return Jzy;
	}

	public void setJzy(String jzy) {
		Jzy = jzy;
	}
 }
