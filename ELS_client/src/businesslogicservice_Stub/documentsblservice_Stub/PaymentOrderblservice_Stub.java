package businesslogicservice_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo.documentsVO.PaymentOrderVO;
import vo.lineitemVO.documentslineitemVO.PaymentOrderlineitemVO;
import vo.orderVO.OrderVO;
import businesslogicservice.documentsblservice.PaymentOrderblservice;

public class PaymentOrderblservice_Stub implements PaymentOrderblservice{
	PaymentOrderVO PaymentOrderVO;
	PaymentOrderlineitemVO PaymentOrderlineitemVO;
	OrderVO oVO;
	String date4PaymentOrder;
	String amount4PaymentOrder;
	String remitter;
	String account4PaymentOrder;
	ArrayList<String>  item4Vehicles;
	ArrayList<String> remark1;
	ArrayList<String> remark2;
	@Override
	public PaymentOrderVO add(String date4PaymentOrder,
			String amount4PaymentOrder, String remitter,
			String account4PaymentOrder, ArrayList<String> item4Vehicles,
			ArrayList<String> remark1, ArrayList<String> remark2) {
		// TODO Auto-generated method stub
		return PaymentOrderVO;
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
	public vo.lineitemVO.documentslineitemVO.PaymentOrderlineitemVO inquireA(
			String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public vo.lineitemVO.documentslineitemVO.PaymentOrderlineitemVO inquireB(
			String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage doesAccountExist(String accountName) {
		// TODO Auto-generated method stub
		return null;
	}

}
