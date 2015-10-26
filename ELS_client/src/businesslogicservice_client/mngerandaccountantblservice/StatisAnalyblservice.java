package businesslogicservice_client.mngerandaccountantblservice;

import vo_client.StatisAnalyVO.CostAndIncomeVO;
import vo_client.StatisAnalyVO.BusinessSituationVO;
/**
 * 
 * @author zt
 * 该类处理有关统计分析的业务逻辑
 */
public interface StatisAnalyblservice {
    
	/**
	 * 前置条件：启动查看经营情况表
	 * 后置条件：根据开始日期和结束日期，显示期间内所有的入款单和收款单信息
	 * @param StartDate
	 * @param EndDate
	 * @return
	 */
	public BusinessSituationVO BS(String StartDate,String EndDate);
	
	/**
	 * 前置条件：启动查看成本收益表
	 * 后置条件：生成截止当前日期的成本收益表（总收入、总支出、总利润=总收入-总支出）
	 * @return
	 */
	public CostAndIncomeVO CAI();
	
	/**
	 * 前置条件：已知总收入和总支出
	 * 后置条件：根据总收入和总支出计算总利润
	 * @param income
	 * @param cost
	 * @return
	 */
	public double profit(double income,double cost);
	
}
