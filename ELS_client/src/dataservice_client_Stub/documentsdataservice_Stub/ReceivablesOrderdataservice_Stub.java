package dataservice_client_Stub.documentsdataservice_Stub;

import java.util.ArrayList;

import po_client.documentsPO.ReceivablesOrderPO;
import po_client.lineitemPO.documentslineitemPO.ReceivablesOrderlineitemPO;
import po_client.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import dataservice_client.documentsdataservice.ReceivablesOrderdataservice;

public class ReceivablesOrderdataservice_Stub implements ReceivablesOrderdataservice{
	String date4RO;
	String amount4RO;
	String courier4RO;
	ArrayList<String> barCode;
	@Override
	public ResultMessage add(ReceivablesOrderPO receivablesOrderPO) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ResultMessage deleteOne(String id) {
		// TODO Auto-generated method stub
		System.out.println("成功删除一条收款单信息");
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		System.out.println("成功删除多条收款单信息");
		return null;
	}

	@Override
	public ReceivablesOrderPO findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceivablesOrderlineitemPO findB(String date) {
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

}
