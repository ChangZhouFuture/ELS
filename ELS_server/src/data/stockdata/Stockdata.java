package data.stockdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.stockPO.StockPO;
import dataservice.stockdataservice.Stockdataservice;

public class Stockdata extends UnicastRemoteObject implements Stockdataservice{

	public Stockdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public StockPO stockCheck(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockPO stockCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String adjustPartition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stockAlarm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void outBound() {
		// TODO Auto-generated method stub
		
	}

}
