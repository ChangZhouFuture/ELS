package dataservice_client_Stub.stockdataservice_Stub;

import java.util.ArrayList;

import dataservice_client.stockdataservice.OutBoundOrderdataservice;
import po_client.lineitemPO.stocklineitemPO.OutBoundOrderlineitemPO;
import po_client.stockPO.OutBoundOrderPO;
import state.ResultMessage;

public class OutBoundOrderdataservice_Stub implements OutBoundOrderdataservice{
	String id4obo;
	String time;
	String id4e;
	String id4to;
	String desti;
	
	@Override
	public OutBoundOrderPO add(String id4obo, String time,String id4e, String id4to, String desti) {
		// TODO Auto-generated method stub
		this.id4obo = id4obo;
		this.time = time;
		this.id4e = id4e;
		this.id4to = id4to;
		this.desti = desti;
		
		//此处实现在PO里增加相应记录
		
		return null;
	}

	@Override
	public ResultMessage deleteone(String id4obo) {
		// TODO Auto-generated method stub
		
		System.out.println("成功删除一个出库单");
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4obo) {
		// TODO Auto-generated method stub
		
		System.out.println("成功删除多个出库单");
		return null;
	}

	@Override
	public OutBoundOrderPO modify(String id, String id4e, String id4to,
			String desti) {
		// TODO Auto-generated method stub
		
		System.out.println("修改成功");
		return null;
	}

	@Override
	public OutBoundOrderPO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderlineitemPO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		System.out.println("已经更新了PO相关信息");
	}
	
}
