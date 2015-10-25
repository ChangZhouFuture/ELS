package vo_client.stockVO;

import java.io.Serializable;

import vo_client.ParentVO;

public class OutBoundOrderVO extends ParentVO{
	String id4e;
	
	String desti;
	
	String id4to;
	
	String id4obo;
	
	String time;
	
	public OutBoundOrderVO(String id4e, String desti, String id4to, String id4obo, 
			String time){
		super();
		this.id4e = id4e;
		this.desti = desti;
		this.id4to = id4to;
		this.id4obo = id4obo;
		this.time = time;
	}

	public String getId4obo() {
		return this.id4obo;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public String getId4e() {
		return id4e;
	}

	public void setId4e(String id4e) {
		this.id4e = id4e;
	}

	public String getDesti() {
		return desti;
	}

	public void setDesti(String desti) {
		this.desti = desti;
	}

	public String getId4to() {
		return id4to;
	}

	public void setId4to(String id4to) {
		this.id4to = id4to;
	}
	
}
