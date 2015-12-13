package po.inforManagementPO;

import java.io.Serializable;

public class BankAccountPO implements Serializable{
	private String name;
    private double amount;
    private String usage;
    
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
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
