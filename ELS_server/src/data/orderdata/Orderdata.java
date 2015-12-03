package data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import bean.JavaBean1;
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
	public ResultMessage add(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 findA(String id) {
		// TODO Auto-generated method stub
		System.out.println("a");
		return null;
	}

	@Override
	public JavaBean1 findB(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderlineitemPO getOrderlineitemPO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateId() {
		// TODO Auto-generated method stub
		
	}

}
