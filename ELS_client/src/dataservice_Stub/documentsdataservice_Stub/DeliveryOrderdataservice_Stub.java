package dataservice_Stub.documentsdataservice_Stub;

import java.util.ArrayList;

import dataservice.documentsdataservice.DeliveryOrderdataservice;
import po.documentsPO.DeliveryOrderPO;
import po.lineitemPO.documentslineitemPO.DeliveryOrderlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;

public class DeliveryOrderdataservice_Stub implements DeliveryOrderdataservice{

	@Override
	public ResultMessage addDeliveryOrder(DeliveryOrderPO deliveryOrderPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public DeliveryOrderPO modify(String id, ArrayList<String> orsderidlist,
//			String dn, String did, String d) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ResultMessage update(DeliveryOrderPO deliveryOrderPO) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderlineitemPO addOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrderPO findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeliveryOrderlineitemPO> findB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

}
