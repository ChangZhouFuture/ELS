package po_server.documentsPO;

import java.io.Serializable;

import state.GoodState;

public class ArrivalOrder4BusiHallPO implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Id;
	private String ID4BusiHall;
	private String arrivalDate;
	private String ID4TransferOrder;
	private String startingAddress;
	private GoodState status;
	private String generateTime;

	public String getID4BusiHall() {
		return ID4BusiHall;
	}
	public void setID4BusiHall(String iD4BusiHall) {
		ID4BusiHall = iD4BusiHall;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getID4TransferOrder() {
		return ID4TransferOrder;
	}
	public void setID4TransferOrder(String iD4TransferOrder) {
		ID4TransferOrder = iD4TransferOrder;
	}
	public String getStartingAddress() {
		return startingAddress;
	}
	public void setStartingAddress(String startingAddress) {
		this.startingAddress = startingAddress;
	}
	
	public GoodState getStatus() {
		return status;
	}
	public void setStatus(GoodState status) {
		this.status = status;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
	}
	
	
}
