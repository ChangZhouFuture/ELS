package data.managerAndAccountantdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.StatisAnalyPO.BusinessSituationPO;
import po.StatisAnalyPO.CostAndIncomePO;
import dataservice.managerAndAccountantdataservice.StatisAnalydataservice;


public class StatisAnalydata extends UnicastRemoteObject implements StatisAnalydataservice{

	public StatisAnalydata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public BusinessSituationPO BS(String StartDate, String EndDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CostAndIncomePO CAI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double profit(double income, double cost) {
		// TODO Auto-generated method stub
		return 0;
	}

}
