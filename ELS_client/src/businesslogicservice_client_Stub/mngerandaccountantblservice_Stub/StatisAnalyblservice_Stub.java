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
