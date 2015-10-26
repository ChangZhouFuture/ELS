package vo_client.lineitemVO.documentslineitemVO;

import java.io.Serializable;
import java.util.ArrayList;

import vo_client.lineitemVO.ParentlineitemVO;

public class ReceivablesOrderlineitemVO extends ParentlineitemVO{
	String date4RO;
	String amount4RO;
	String courier4RO;
	ArrayList<String> barCode;
	public ReceivablesOrderlineitemVO(String date4Ro, String amount4Ro, String courier4Ro, ArrayList<String> barCode){
		super();
		this.date4RO = date4Ro;
		this.amount4RO = amount4Ro;
		this.courier4RO = courier4Ro;
		this.barCode = barCode;
	}
	public String getdate4RO() {
		return this.date4RO;
	}
	public void setdate4RO(String date4RO) {
		this.date4RO = date4RO;
	}
	public String getamount4RO() {
		return this.amount4RO;
	}
	public void setamount4RO(String amount4RO) {
		this.amount4RO = amount4RO;
	}
	public String getcourier4RO() {
		return this.courier4RO;
	}
	public void setcourier4RO(String courier4RO) {
		this.courier4RO = courier4RO;
	}
	public ArrayList<String> getbarCode() {
		return this.barCode;
	}
	public void setbarCode(ArrayList<String> barCode) {
		this.barCode = barCode;
	}
}
