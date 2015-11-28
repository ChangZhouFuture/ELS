package businesslogic.documentsbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo.documentsVO.PaymentOrderVO;
import vo.lineitemVO.documentslineitemVO.PaymentOrderlineitemVO;
import bean.JavaBean1;
import businesslogicservice.documentsblservice.PaymentOrderblservice;

public class PaymentOrder implements PaymentOrderblservice {

	@Override
	public PaymentOrderVO add(String date4PaymentOrder,
			String amount4PaymentOrder, String remitter,
			String account4PaymentOrder, ArrayList<String> item4Vehicles,
			ArrayList<String> remark1, ArrayList<String> remark2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOne(String date, String bussinessHall) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4courier,
			ArrayList<String> date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentOrderVO modify(String bussinessHall, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void countAmount(ArrayList<String> OrderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage doesAccountExist(String accountName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
