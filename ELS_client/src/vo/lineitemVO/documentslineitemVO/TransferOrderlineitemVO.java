package vo.lineitemVO.documentslineitemVO;

import state.TransportType;

public class TransferOrderlineitemVO {
	private String id;
	private String date;
	private String startingAdd;
	private String endAdd;
	private String vehiclesId;
	private int carriage;
	private TransportType transportType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartingAdd() {
		return startingAdd;
	}
	public void setStartingAdd(String startingAdd) {
		this.startingAdd = startingAdd;
	}
	public String getEndAdd() {
		return endAdd;
	}
	public void setEndAdd(String endAdd) {
		this.endAdd = endAdd;
	}
	public String getVehiclesId() {
		return vehiclesId;
	}
	public void setVehiclesId(String vehiclesId) {
		this.vehiclesId = vehiclesId;
	}
	public int getCarriage() {
		return carriage;
	}
	public void setCarriage(int carriage) {
		this.carriage = carriage;
	}
	public TransportType getTransportType() {
		return transportType;
	}
	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}
	
	
}
