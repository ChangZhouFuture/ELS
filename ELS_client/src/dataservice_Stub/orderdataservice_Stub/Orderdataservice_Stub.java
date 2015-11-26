package dataservice_Stub.orderdataservice_Stub;

import java.util.ArrayList;

import dataservice.orderdataservice.Orderdataservice;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.orderPO.OrderPO;
import state.ExpressType;
import state.ResultMessage;

public class Orderdataservice_Stub implements Orderdataservice{

	@Override
	public OrderPO add(OrderPO orderPO) {
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
	public OrderPO findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderlineitemPO> findB(String date) {
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
