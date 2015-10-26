package dataservice_client_Stub.orderdataservice_Stub;

import dataservice_client.orderdataservice.Orderdataservice;
import po_client.OrderPO;
import state.ExpressType;

public class Orderdataservice_Stub implements Orderdataservice{

	@Override
	public OrderPO add(String sender, String addressee, String desti, String startingPlace, ExpressType eType,
			String name, String id, int num) {
		// TODO Auto-generated method stub
		System.out.println("增加成功");
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		System.out.println("删除成功");
	}

	@Override
	public OrderPO modify(String sender, String addressee, String desti, String startingPlace, ExpressType eType,
			String name, String id, int num) {
		// TODO Auto-generated method stub
		System.out.println("修改成功");
		return null;
	}

	@Override
	public OrderPO inquireA(String id) {
		// TODO Auto-generated method stub
		System.out.println("订单信息；");
		return null;
	}

	@Override
	public OrderPO inquireB(String date) {
		// TODO Auto-generated method stub
		System.out.println("该日订单；");
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("更新成功");
	}

}
