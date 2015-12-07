package businesslogicservice.managerAndAccountantblservice;

import bean.JavaBean1;


/**
 * 
 * @author zt
 * 该类处理有关统计分析的业务逻辑
 */

public interface StatisAnalyblservice {
	public JavaBean1 inquireReceivalblesOrder(String ID);
	
	public JavaBean1 inquirePaymentOrder(String ID);
	
	public JavaBean1 inquireReceivalblesOrder2();
	
	public JavaBean1 inquirePaymentOrder2();
	
	public JavaBean1 inquireCostAndIncomeTable();
	
}
