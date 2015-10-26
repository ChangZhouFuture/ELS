package vo_client.documentsVO;

import java.util.ArrayList;

import vo_client.ParentVO;

public class ReceivablesOrderVO extends ParentVO{
	String date4RO;
	String amount4RO;
	String courier4RO;
	ArrayList<String> barCode;
	public ReceivablesOrderVO(String date4RO, String amount4RO, String courier4RO, ArrayList<String> barCode){
		super();
		this.date4RO = date4RO;
		this.amount4RO = amount4RO;
		this.courier4RO = courier4RO;
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
