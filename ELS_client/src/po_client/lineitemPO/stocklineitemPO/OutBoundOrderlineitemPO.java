package po_client.lineitemPO.stocklineitemPO;

import java.io.Serializable;

import po_client.lineitemPO.ParentlineitemPO;
import vo_client.lineitemVO.ParentlineitemVO;

public class OutBoundOrderlineitemPO extends ParentlineitemPO{
	String id4e;
	
	String desti;
	
	String id4to;
	
	String id4obo;
	
	String time;
	
	public OutBoundOrderlineitemPO(String id4e, String desti, String id4to, String id4obo, String time){
		super();
		this.id4e = id4e;
		this.desti = desti;
		this.id4to = id4to;
		this.id4obo = id4obo;
		this.time = time;
	}
	
	public String getId4obo() {
		return id4obo;
	}

	public String getTime() {
		return time;
	}

	public String getid4e() {
		return this.id4e;
	}
	
	public void setid4e(String id4e) {
		this.id4e = id4e;
	}
	
	public String getdesti() {
		return this.desti;
	}
	
	public void setdesti(String desti) {
		this.desti = desti;
	}

	public String getid4to() {
		return this.id4to;
	}
	
	public void setid4to(String id4to) {
		this.id4to = id4to;
	}
	
}