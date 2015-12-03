package vo.lineitemVO.documentslineitemVO;

public class BusiHallLoadingListlineitemVO{
	private String ID;
	private String loadingDate;
	private String destination;
	private String truckNum;
	private double carriage;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getLoadingDate() {
		return loadingDate;
	}
	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTruckNum() {
		return truckNum;
	}
	public void setTruckNum(String truckNum) {
		this.truckNum = truckNum;
	}
	public double getCarriage() {
		return carriage;
	}
	public void setCarriage(double carriage) {
		this.carriage = carriage;
	}
}
