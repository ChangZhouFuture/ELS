package po.StatisAnalyPO;

import java.io.Serializable;

public class CostAndIncomePO implements Serializable{
	private double income;
	private double cost;
	private double profit;
	
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	
}
