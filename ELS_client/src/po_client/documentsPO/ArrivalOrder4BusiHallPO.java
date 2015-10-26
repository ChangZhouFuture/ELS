package po_client.documentsPO;

import java.io.Serializable;

import state.GoodState;

public class ArrivalOrder4BusiHallPO implements Serializable{

	String id;
	String toid;
	String sa;
	String d;
	GoodState gs;
	
	public ArrivalOrder4BusiHallPO(String id,String toid,String sa,String d,GoodState gs){
		super();
		this.id=id;
		this.toid=toid;
		this.sa=sa;
		this.d=d;
		this.gs=gs;
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
}
