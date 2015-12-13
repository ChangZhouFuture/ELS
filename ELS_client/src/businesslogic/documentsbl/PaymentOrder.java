package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import po.documentsPO.PaymentOrderPO;
import dataservice.documentsdataservice.PaymentOrderdataservice;
import state.ResultMessage;
import vo.documentsVO.PaymentOrderVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.utilitybl.Time;
import businesslogicservice.documentsblservice.PaymentOrderblservice;

public class PaymentOrder implements PaymentOrderblservice {
	private PaymentOrderdataservice paymentOrderdataservice;
	private PaymentOrderVO paymentOrderVO;
	private PaymentOrderPO paymentOrderPO;
	private ArrayList<PaymentOrderPO> arrayList;
	private ArrayList<PaymentOrderVO> arrayList2;
	private JavaBean1 javaBean1;
	private ResultMessage resultMessage;
	private String date;
	
	public PaymentOrder() {
		try {
			paymentOrderdataservice = RMIHelper.getPaymentOrderdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultMessage addPaymentAccount(String accountName) {
		try {
			resultMessage = paymentOrderdataservice.addPaymentAccount(accountName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public PaymentOrderVO add(PaymentOrderVO paymentOrderVO) {
		paymentOrderPO = new PaymentOrderPO();
		this.paymentOrderVO = paymentOrderVO;
		
		this.paymentOrderVO.setDate(generateDate());
		this.paymentOrderVO.setGenerateTime(Time.generateTime());
		this.paymentOrderVO.setID(generateId());
		VOtoPO();
		
		return null;
	}

	@Override
	public ResultMessage deleteOne(String id) {
		try {
			resultMessage = paymentOrderdataservice.deleteOne(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		try {
			resultMessage = paymentOrderdataservice.deleteMany(idList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public ResultMessage modify(PaymentOrderVO paymentOrderVO) {
		paymentOrderPO = new PaymentOrderPO();
		this.paymentOrderVO = paymentOrderVO;
		
		VOtoPO();
		try {
			resultMessage = paymentOrderdataservice.update(paymentOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		try {
			javaBean1 = paymentOrderdataservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<PaymentOrderPO>)javaBean1.getObject();
		
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		try {
			javaBean1 = paymentOrderdataservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<PaymentOrderPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		
		return javaBean1;
	}

	public String generateId() {
		String id = null;
		try {
			id = date+paymentOrderdataservice.generaId(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return id;
	}

	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	public void VOtoPO() {
		paymentOrderPO.setAmount(paymentOrderVO.getAmount());
		paymentOrderPO.setBankAccount(paymentOrderVO.getBankAccount());
		paymentOrderPO.setDate(paymentOrderVO.getDate());
		paymentOrderPO.setGenerateTime(paymentOrderVO.getGenerateTime());
		paymentOrderPO.setEntry(paymentOrderVO.getEntry());
		paymentOrderPO.setNote(paymentOrderVO.getNote());
		paymentOrderPO.setPayer(paymentOrderVO.getPayer());
	}

	public void POtoVO(int k) {
		arrayList2 = new ArrayList<PaymentOrderVO>();
		
		for (int i = 0; i < k; i++) {
			paymentOrderPO = arrayList.get(i);
			
			paymentOrderVO = new PaymentOrderVO();
			paymentOrderVO.setDate(paymentOrderPO.getDate());
			paymentOrderVO.setAmount(paymentOrderPO.getAmount());
			paymentOrderVO.setPayer(paymentOrderPO.getPayer());
			paymentOrderVO.setBankAccount(paymentOrderPO.getBankAccount());
			paymentOrderVO.setEntry(paymentOrderPO.getEntry());
			
			arrayList2.add(paymentOrderVO);
		}
		
	}

	
}
