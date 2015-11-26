package po.documentsPO;

import java.io.Serializable;

import state.GoodState;

public class ArrivalOrder4TranCenPO implements Serializable{
    private String Id;
    private String Id4TranCen;
    private String arrivalDate;
    private String Id4TransferOrder;
    private String StartingAddress;
    private GoodState status;
    private String generateTime;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getId4TranCen() {
		return Id4TranCen;
	}
	public void setId4TranCen(String id4TranCen) {
		Id4TranCen = id4TranCen;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getId4TransferOrder() {
		return Id4TransferOrder;
	}
	public void setId4TransferOrder(String id4TransferOrder) {
		Id4TransferOrder = id4TransferOrder;
	}
	public String getStartingAddress() {
		return StartingAddress;
	}
	public void setStartingAddress(String startingAddress) {
		StartingAddress = startingAddress;
	}
	public GoodState getStatus() {
		return status;
	}
	public void setStatus(GoodState status) {
		this.status = status;
	}
	public String getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
	}
    
    
}
