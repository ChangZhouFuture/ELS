package po_client.documentsPO;

import java.io.Serializable;

import state.GoodState;

 public class ArrivalOrder4TranCenPO implements Serializable{
	String id;
	String toid;
	String sa;
	String d;
	GoodState gs;
	String tcid;
	
	public ArrivalOrder4TranCenPO(String id,String toid,String sa,String d,GoodState gs,String tcid){
		super();
		this.id=id;
		this.toid=toid;
		this.sa=sa;
		this.d=d;
		this.gs=gs;
		this.tcid=tcid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToid() {
		return toid;
	}

	public void setToid(String toid) {
		this.toid = toid;
	}

	public String getSa() {
		return sa;
	}

	public void setSa(String sa) {
		this.sa = sa;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public GoodState getGs() {
		return gs;
	}

	public void setGs(GoodState gs) {
		this.gs = gs;
	}

	public String getTcid() {
		return tcid;
	}
 
	public void setTcid(String tcid) {
		this.tcid = tcid;
	}
 }
