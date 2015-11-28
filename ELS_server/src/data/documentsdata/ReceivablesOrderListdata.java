package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import bean.JavaBean1;
import po.documentsPO.ReceivablesOrderPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.ReceivablesOrderdataservice;

public class ReceivablesOrderListdata extends UnicastRemoteObject implements ReceivablesOrderdataservice{

	public ReceivablesOrderListdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(ReceivablesOrderPO receivablesOrderPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 findB(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderlineitemPO> generateOrder(String courierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double generateFreight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage update(ReceivablesOrderPO receivablesOrderPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

}
