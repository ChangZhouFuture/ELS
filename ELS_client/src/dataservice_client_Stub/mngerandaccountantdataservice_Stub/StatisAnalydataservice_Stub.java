package dataservice_client_Stub.mngerandaccountantdataservice_Stub;

import dataservice_client.mngerandaccountantdataservice.StatisAnalydataservice;
import vo_client.StatisAnalyVO.BusinessSituationVO;
import vo_client.StatisAnalyVO.CostAndIncomeVO;

public class StatisAnalydataservice_Stub implements StatisAnalydataservice{

	@Override
	public BusinessSituationVO BS(String StartDate, String EndDate) {
		// TODO Auto-generated method stub
		System.out.println("��Ӫ�����");
		return null;
	}

	@Override
	public CostAndIncomeVO CAI() {
		// TODO Auto-generated method stub
		System.out.println("�ɱ������");
		return null;
	}

	@Override
	public double profit(double income, double cost) {
		// TODO Auto-generated method stub
		return income-cost;
	}

}
