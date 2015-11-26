package dataservice_Stub.documentsdataservice_Stub;

import java.util.ArrayList;

import dataservice.documentsdataservice.PaymentOrderdataservice;
import po.documentsPO.PaymentOrderPO;
import po.inforManagementPO.BankAccountPO;
import po.lineitemPO.documentslineitemPO.PaymentOrderlineitemPO;
import state.ResultMessage;

public class PaymentOrderdataservice_Stub implements PaymentOrderdataservice{
	String date4PaymentOrder;
	String amount4PaymentOrder;
	String remitter;
	String account4PaymentOrder;
	ArrayList<String>  item4Vehicles;
	ArrayList<String> remark1;
	ArrayList<String> remark2;
	@Override
	public ResultMessage add(PaymentOrderPO paymentOrderPO) {
		return null;
	}

	@Override
	public ResultMessage deleteOne(String id) {
		// TODO Auto-generated method stub
		System.out.println("成功删除一条付款单信息");
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		System.out.println("成功删除多条付款单信息");
		return null;
	}

	@Override
	public PaymentOrderPO findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(PaymentOrderPO paymentOrderPO) {
		// TODO Auto-generated method stub
		System.out.println("已经更新了PO相关信息");
		return null;
	}

	@Override
	public BankAccountPO addPaymentAccount(String accountName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PaymentOrderlineitemPO> findB(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generaId() {
		// TODO Auto-generated method stub
		return null;
	}

}
