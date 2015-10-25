package dataservice_client_Stub.stockdataservice_Stub;

import java.util.ArrayList;

import dataservice_client.stockdataservice.OutBoundOrderdataservice;
import po_client.OrderPO;
import po_client.stockPO.OutBoundOrderPO;
import state.ResultMessage;
import vo_client.stockVO.OutBoundOrderVO;

public class OutBoundOrderdataservice_Stub implements OutBoundOrderdataservice{

	@Override
	public OutBoundOrderVO add(String id4e, String id4to, String desti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteone(String id4obo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4obo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderVO modify(String id, String id4e, String id4to,
			String desti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderPO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderPO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
