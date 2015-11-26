package data.documentsdata;

import java.util.ArrayList;

import po.documentsPO.PaymentOrderPO;
import po.inforManagementPO.BankAccountPO;
import po.lineitemPO.documentslineitemPO.PaymentOrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.PaymentOrderdataservice;


public class PaymentOrderdata implements PaymentOrderdataservice {

	@Override
	public BankAccountPO addPaymentAccount(String accountName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(PaymentOrderPO paymentOrderPO) {
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
	public PaymentOrderPO findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PaymentOrderlineitemPO> findB(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(PaymentOrderPO paymentOrderPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generaId() {
		// TODO Auto-generated method stub
		return null;
	}

}
