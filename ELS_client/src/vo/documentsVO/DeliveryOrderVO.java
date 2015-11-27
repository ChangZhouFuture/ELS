package vo.documentsVO;

import java.util.ArrayList;

public class DeliveryOrderVO {
	private String ID;
    private String arrivalDate;
    ArrayList<String> orderIDs=new ArrayList<>();
    private String deliverier;
    private String generateTime;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public ArrayList<String> getOrderIDs() {
		return orderIDs;
	}
	public void setOrderIDs(ArrayList<String> orderIDs) {
		this.orderIDs = orderIDs;
	}
	public String getDeliverier() {
		return deliverier;
	}
	public void setDeliverier(String deliverier) {
		this.deliverier = deliverier;
	}
	public String getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
	}
}
