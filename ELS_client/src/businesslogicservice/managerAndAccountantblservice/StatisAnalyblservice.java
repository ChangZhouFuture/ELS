package businesslogicservice.managerAndAccountantblservice;

import bean.JavaBean1;


/**
 * 
 * @author zt
 * ���ദ���й�ͳ�Ʒ�����ҵ���߼�
 */

public interface StatisAnalyblservice {
	public JavaBean1 inquireReceivalblesOrder(String ID);
	
	public JavaBean1 inquirePaymentOrder(String ID);
	
	public JavaBean1 inquireReceivalblesOrder2();
	
	public JavaBean1 inquirePaymentOrder2();
	
	public JavaBean1 inquireCostAndIncomeTable();
	
}
