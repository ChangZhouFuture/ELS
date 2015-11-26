package data.documentsdata;

import java.util.ArrayList;

import po.documentsPO.DeliveryOrderPO;
import po.lineitemPO.documentslineitemPO.DeliveryOrderlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.DeliveryOrderdataservice;


public class DeliveryOrderdata implements DeliveryOrderdataservice {

	@Override
	public OrderlineitemPO addOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

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

	@Override
	public ResultMessage update(DeliveryOrderPO deliveryOrderPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

}
