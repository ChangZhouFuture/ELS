package vo_client.lineitemVO.informngmtlineitemVO;


public class VehicleslineitemVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8345248940752949681L;
	String vehiclesId;
	String engineNum;
	String vehiclesNum;
	String chassisNum;
	String dateOfBuy;
	String activeTime;
	String vehiclesImage;
	public VehicleslineitemVO(String vehiclesId, String engineNum, String vehiclesNum, String chassisNum,String dateOfBuy,String activeTime,String vehiclesImage){
		super();
		this.vehiclesId = vehiclesId;
		this.engineNum = engineNum;
		this.chassisNum = chassisNum;
		this.vehiclesNum = vehiclesNum;
		this.dateOfBuy = dateOfBuy;
		this.activeTime = activeTime;
		this.vehiclesImage = vehiclesImage;
	}
	public String getvehiclesId() {
		return this.vehiclesId;
	}
	public void setvehiclesId(String vehiclesId) {
		this.vehiclesId = vehiclesId;
	}
	public String getengineNum() {
		return this.engineNum;
	}
	public void setengineNum(String engineNum) {
		this.engineNum = engineNum;
	}
	public String getvehiclesNum() {
		return this.vehiclesNum;
	}
	public void setvehiclesNum(String vehiclesNum) {
		this.vehiclesNum = vehiclesNum;
	}
	public String getchassisNum() {
		return this.chassisNum;
	}
	public void setchassisNum(String chassisNum) {
		this.chassisNum = chassisNum;
	}
	public String getdateOfBuy() {
		return this.dateOfBuy;
	}
	public void setdateOfBuy(String dateOfBuy) {
		this.dateOfBuy = dateOfBuy;
	}
	public String getactiveTime() {
		return this.activeTime;
	}
	public void setactiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	public String getvehiclesImage() {
		return this.vehiclesImage;
	}
	public void setvehiclesImage(String vehiclesImage) {
		this.vehiclesImage = vehiclesImage;
	}
}
