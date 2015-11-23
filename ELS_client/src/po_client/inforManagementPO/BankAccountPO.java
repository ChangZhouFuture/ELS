package po_client.inforManagementPO;

import java.io.Serializable;

public class BankAccountPO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private double amount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
    
}
