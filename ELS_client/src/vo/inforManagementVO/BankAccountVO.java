package vo.inforManagementVO;

import state.UseState;

public class BankAccountVO {
	private String name;
    private double amount;
    private UseState useState;
    
    public UseState getUseState() {
		return useState;
	}
	public void setUseState(UseState useState) {
		this.useState = useState;
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
