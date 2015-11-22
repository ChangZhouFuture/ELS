package po_client.documentsPO;

import java.io.Serializable;

import state.GoodState;

 public class ArrivalOrder4TranCenPO implements Serializable{
	String id;
	String transferOrderid;
	String startingAdd;
	String date;
	GoodState goodState;
	String transferCenterId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTransferOrderid() {
		return transferOrderid;
	}
	public void setTransferOrderid(String transferOrderid) {
		this.transferOrderid = transferOrderid;
	}
	public String getStartingAdd() {
		return startingAdd;
	}
	public void setStartingAdd(String startingAdd) {
		this.startingAdd = startingAdd;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public GoodState getGoodState() {
		return goodState;
	}
	public void setGoodState(GoodState goodState) {
		this.goodState = goodState;
	}
	public String getTransferCenterId() {
		return transferCenterId;
	}
	public void setTransferCenterId(String transferCenterId) {
		this.transferCenterId = transferCenterId;
	}
	
//	public ArrivalOrder4TranCenPO(String id,String toid,String sa,String d,GoodState gs,String tcid){
//		super();
//		this.id=id;
//		this.toid=toid;
//		this.sa=sa;
//		this.d=d;
//		this.gs=gs;
//		this.tcid=tcid;
//	}

 }
