package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import bean.JavaBean1;
/**
 * 该类处理和查看统计分析有关的数据层方法
 * @author zt
 *
 */
public interface StatisAnalydataservice extends Remote{

	/**
	 * 前置条件：
	 * 后置条件：生成截止当前日期的成本收益表（总收入、总支出、总利润=总收入-总支出）返回给逻辑层
	 * @return
	 */
	public JavaBean1 CostAndIncome() throws RemoteException;
	

}
