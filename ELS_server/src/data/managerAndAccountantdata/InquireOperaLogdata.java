package data.managerAndAccountantdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.utilityPO.OperaLogPO;
import dataservice.managerAndAccountantdataservice.InquireOperaLogdataservice;

public class InquireOperaLogdata extends UnicastRemoteObject implements InquireOperaLogdataservice{

	public InquireOperaLogdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public OperaLogPO inquireA(String id, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperaLogPO inquireB(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperaLogPO inquireC(String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
