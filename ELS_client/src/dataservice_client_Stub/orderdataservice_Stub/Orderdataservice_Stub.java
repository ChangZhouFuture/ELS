package dataservice_client_Stub.orderdataservice_Stub;

import dataservice_client.orderdataservice.Orderdataservice;
import po_client.OrderPO;
import state.ExpressType;

public class Orderdataservice_Stub implements Orderdataservice{

	@Override
	public OrderPO add(String sender, String addressee, String desti, String startingPlace, ExpressType eType,
			String name, String id, int num) {
		// TODO Auto-generated method stub
		System.out.println("���ӳɹ�");
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		System.out.println("ɾ���ɹ�");
	}

	@Override
	public OrderPO modify(String sender, String addressee, String desti, String startingPlace, ExpressType eType,
			String name, String id, int num) {
		// TODO Auto-generated method stub
		System.out.println("�޸ĳɹ�");
		return null;
	}

	@Override
	public OrderPO inquireA(String id) {
		// TODO Auto-generated method stub
		System.out.println("������Ϣ��");
		return null;
	}

	@Override
	public OrderPO inquireB(String date) {
		// TODO Auto-generated method stub
		System.out.println("���ն�����");
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("���³ɹ�");
	}

}
