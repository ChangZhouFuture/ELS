package dataservice_client_Stub.documentsdataservice_Stub;

import java.util.ArrayList;

import po_client.documentsPO.PaymentOrderPO;
import po_client.lineitemPO.documentslineitemPO.PaymentOrderlineitemPO;
import state.ResultMessage;
import dataservice_client.documentsdataservice.PaymentOrderdataservice;

public class PaymentOrderdataservice_Stub implements PaymentOrderdataservice{
	String date4PaymentOrder;
	String amount4PaymentOrder;
	String remitter;
	String account4PaymentOrder;
	ArrayList<String>  item4Vehicles;
	ArrayList<String> remark1;
	ArrayList<String> remark2;
	@Override
	public PaymentOrderPO add(String date4PaymentOrder,
			String amount4PaymentOrder, String remitter,
			String account4PaymentOrder, ArrayList<String> item4Vehicles,
			ArrayList<String> remark1, ArrayList<String> remark2) {
		// TODO Auto-generated method stub
		this.date4PaymentOrder = date4PaymentOrder;
		this.amount4PaymentOrder = amount4PaymentOrder;
		this.remitter = remitter;
		this.account4PaymentOrder = account4PaymentOrder;
		this.item4Vehicles = item4Vehicles;
		this.remark1 = remark1;
		this.remark2 = remark2;
		return null;
	}

	@Override
	public ResultMessage deleteOne(String date, String bussinessHall) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ�ɾ��һ�������Ϣ");
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4courier,
			ArrayList<String> date) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ�ɾ�����������Ϣ");
		return null;
	}

	@Override
	public PaymentOrderPO modify(String bussinessHall, String date) {
		// TODO Auto-generated method stub
		System.out.println("�޸ĳɹ�");
		return null;
	}

	@Override
	public PaymentOrderlineitemPO inquire(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void countAmount(ArrayList<String> OrderId) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ�������ܸ������");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("�Ѿ�������PO�����Ϣ");
	}

}
