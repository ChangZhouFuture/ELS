package dataservice_client_Stub.documentsdataservice_Stub;

import java.util.ArrayList;

import po_client.documentsPO.ReceivablesOrderPO;
import po_client.lineitemPO.documentslineitemPO.ReceivablesOrderlineitemPO;
import state.ResultMessage;
import dataservice_client.documentsdataservice.ReceivablesOrderdataservice;

public class ReceivablesOrderdataservice_Stub implements ReceivablesOrderdataservice{
	String date4RO;
	String amount4RO;
	String courier4RO;
	ArrayList<String> barCode;
	@Override
	public ReceivablesOrderPO add(String date4ro, String amount4ro,
			String courier4ro, ArrayList<String> barCode) {
		// TODO Auto-generated method stub
		this.date4RO = date4ro;
		this.amount4RO = amount4ro;
		this.courier4RO = courier4ro;
		this.barCode = barCode;
		return null;
	}

	@Override
	public ResultMessage deleteOne(String date, String courierId) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ�ɾ��һ���տ��Ϣ");
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4courier,
			ArrayList<String> date) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ�ɾ�������տ��Ϣ");
		return null;
	}

	@Override
	public ReceivablesOrderPO modify(String id4courier, String date) {
		// TODO Auto-generated method stub
		System.out.println("�޸ĳɹ�");
		return null;
	}

	@Override
	public ReceivablesOrderlineitemPO inquire(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void countCarriage(String depature, String destination) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ�������˷�");
	}

	@Override
	public void countAmount(ArrayList<String> OrderId) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ�������������տ����");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("�Ѿ�������PO�����Ϣ");
	}
	
}
