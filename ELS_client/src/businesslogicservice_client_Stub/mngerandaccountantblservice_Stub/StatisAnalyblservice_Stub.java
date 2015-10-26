package businesslogicservice_client_Stub.mngerandaccountantblservice_Stub;

import businesslogicservice_client.mngerandaccountantblservice.StatisAnalyblservice;
import vo_client.StatisAnalyVO.CostAndIncomeVO;
import vo_client.StatisAnalyVO.BusinessSituationVO;
import vo_client.lineitemVO.documentslineitemVO.LoadingListlineitemVO;

public class StatisAnalyblservice_Stub implements StatisAnalyblservice{
    BusinessSituationVO mcVO;
    CostAndIncomeVO caiVO;
    String StartDate;
    String EndDate;
	
	@Override
	public BusinessSituationVO BS(String StartDate, String EndDate) {
		// TODO Auto-generated method stub
		
//		此处传入VO所有参数，记录mcVO
		
		System.out.println("显示经营情况表：");
		return mcVO;
	}

	@Override
	public CostAndIncomeVO CAI() {
		// TODO Auto-generated method stub
//		此处传入VO所有参数，记录caiVO		
		
		System.out.println("显示成本收益表：");
		return caiVO;
	}

	@Override
	public double profit(double income, double cost) {
		// TODO Auto-generated method stub
		return income-cost;
	}
    
}
