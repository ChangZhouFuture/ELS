package businesslogicservice_Stub.mngerandaccountantblservice_Stub;

import businesslogicservice.managerAndAccountantblservice.StatisAnalyblservice;
import vo.StatisAnalyVO.BusinessSituationVO;
import vo.StatisAnalyVO.CostAndIncomeVO;
import vo.lineitemVO.documentslineitemVO.BusiHallLoadingListlineitemVO;

public class StatisAnalyblservice_Stub implements StatisAnalyblservice{
    BusinessSituationVO mcVO;
    CostAndIncomeVO caiVO;
    String StartDate;
    String EndDate;
	
	@Override
	public BusinessSituationVO BS(String StartDate, String EndDate) {
		// TODO Auto-generated method stub
		
//		�˴�����VO���в�������¼mcVO
		
		System.out.println("��ʾ��Ӫ�����");
		return mcVO;
	}

	@Override
	public CostAndIncomeVO CAI() {
		// TODO Auto-generated method stub
//		�˴�����VO���в�������¼caiVO		
		
		System.out.println("��ʾ�ɱ������");
		return caiVO;
	}

	@Override
	public double profit(double income, double cost) {
		// TODO Auto-generated method stub
		return income-cost;
	}
    
}
