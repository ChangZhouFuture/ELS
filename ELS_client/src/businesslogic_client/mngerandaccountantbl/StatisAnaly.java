package businesslogic_client.mngerandaccountantbl;

import businesslogicservice_client.mngerandaccountantblservice.StatisAnalyblservice;
import vo_client.StatisAnalyVO.BusinessSituationVO;
import vo_client.StatisAnalyVO.CostAndIncomeVO;

public class StatisAnaly implements StatisAnalyblservice {

	@Override
	public BusinessSituationVO BS(String StartDate, String EndDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CostAndIncomeVO CAI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double profit(double income, double cost) {
		// TODO Auto-generated method stub
		return 0;
	}

}
