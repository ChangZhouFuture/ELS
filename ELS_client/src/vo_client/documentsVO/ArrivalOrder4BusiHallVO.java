package vo_client.documentsVO;

import state.GoodState;


public class ArrivalOrder4BusiHallVO {

	String id;
	String transferOrderId;
	String startingAdd;
	String date;
	GoodState goodState;
	
//	public ArrivalOrder4BusiHallVO(String id, String transferOrderId,
//			String startingAdd, String date, GoodState goodState) {
//		this.id=id;
//		this.transferOrderId=transferOrderId;
//		this.startingAdd=startingAdd;
//		this.date=date;
//		this.goodState=goodState;
//	}
	
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

