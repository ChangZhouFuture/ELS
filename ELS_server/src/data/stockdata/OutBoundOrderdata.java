package data.stockdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.lineitemPO.stocklineitemPO.OutBoundOrderlineitemPO;
import po.stockPO.OutBoundOrderPO;
import state.ResultMessage;
import dataservice.stockdataservice.OutBoundOrderdataservice;


public class OutBoundOrderdata extends UnicastRemoteObject implements OutBoundOrderdataservice {

	public OutBoundOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public OutBoundOrderPO add(String id4obo, String time, String id4e,
			String id4to, String desti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteone(String id4obo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4obo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderPO modify(String id, String id4e, String id4to,
			String desti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderPO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderlineitemPO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
