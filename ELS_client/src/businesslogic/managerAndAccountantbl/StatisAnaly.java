package businesslogic.managerAndAccountantbl;

import state.ResultMessage;
import dataservice.managerAndAccountantdataservice.StatisAnalydataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.managerAndAccountantblservice.StatisAnalyblservice;

public class StatisAnaly implements StatisAnalyblservice {
	private StatisAnalydataservice statisAnalydataservice;
	private ResultMessage resultMessage;
	
	
	public StatisAnaly() {
		try {
			statisAnalydataservice = RMIHelper.getStatisAnalydataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 inquireReceivalblesOrder(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquirePaymentOrder(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireReceivalblesOrder2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquirePaymentOrder2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireCostAndIncomeTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
