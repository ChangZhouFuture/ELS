package po.documentsPO;


import java.io.Serializable;

import state.GoodState;

 public class BusiHallArrivalOrderPO implements Serializable{
 
	private String id;
	private String transferOrderId;
	private String startingAdd;
	private String date;
	private GoodState goodState;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTransferOrderId() {
		return transferOrderId;
	}

	public void setTransferOrderId(String transferOrderId) {
		this.transferOrderId = transferOrderId;
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

 }
