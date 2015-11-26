package data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.orderPO.OrderPO;
import dataservice.orderdataservice.Orderdataservice;
import state.ResultMessage;

public class Orderdata extends UnicastRemoteObject implements Orderdataservice{

	public Orderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public OrderPO add(OrderPO orderPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOne(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderPO findA(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("a");
		return null;
	}

	@Override
	public ArrayList<OrderlineitemPO> findB(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(OrderPO orderPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderlineitemPO getOrderlineitemPO(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateId() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
