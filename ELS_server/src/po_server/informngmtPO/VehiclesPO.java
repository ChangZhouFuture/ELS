package po_server.informngmtPO;

import java.io.Serializable;

public class VehiclesPO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
    private String plateNum;
    private int serviceTime;
    
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	public int getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
    
}
