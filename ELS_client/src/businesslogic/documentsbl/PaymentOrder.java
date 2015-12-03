package businesslogic.documentsbl;

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
		resultMessage = paymentOrderdataservice.addPaymentAccount(accountName);
		return resultMessage;
	}

	@Override
	public PaymentOrderVO add(PaymentOrderVO paymentOrderVO) {
		paymentOrderPO = new PaymentOrderPO();
		this.paymentOrderVO = paymentOrderVO;
		
		this.paymentOrderVO.setDate(generateDate());
		this.paymentOrderVO.setID(generateId());
		VOtoPO();
		
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
	public ResultMessage modify(PaymentOrderVO paymentOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String generateId() {
		String id = date+paymentOrderdataservice.generaId(date);
		return id;
	}

	@Override
	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	@Override
	public void VOtoPO() {
		paymentOrderPO.setAmount(paymentOrderVO.getAmount());
		paymentOrderPO.setBankAccount(paymentOrderVO.getBankAccount());
		paymentOrderPO.setDate(paymentOrderVO.getDate());
		paymentOrderPO.setEntry(paymentOrderVO.getEntry());
		paymentOrderPO.setNote(paymentOrderVO.getNote());
		paymentOrderPO.setPayer(paymentOrderVO.getPayer());
		
	}

	@Override
	public void POtoVO() {
		// TODO Auto-generated method stub
		
	}

	
}
