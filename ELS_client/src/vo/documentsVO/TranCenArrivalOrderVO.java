package vo.documentsVO;
import state.GoodState;

public class TranCenArrivalOrderVO {
	String id;
	String transferOrderId;
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
	public String getTransferCenterId() {
		return transferCenterId;
	}
	public void setTransferCenterId(String transferCenterId) {
		this.transferCenterId = transferCenterId;
	}
	
//	public ArrivalOrder4TranCenVO(String id,
//			String tranorderoid, String startaddress, String date, GoodState goodstate, String trancenterid) {
//		this.id=id;
//		this.tranorderoid=tranorderoid;
//		this.startaddress=startaddress;
//		this.date=date;
//		this.goodstate=goodstate;
//		this.trancenterid=trancenterid;
//}
	
} 