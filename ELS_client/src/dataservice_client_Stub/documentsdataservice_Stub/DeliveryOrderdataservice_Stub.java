package dataservice_client_Stub.documentsdataservice_Stub;

import java.util.ArrayList;

import po_client.documentsPO.DeliveryOrderPO;
import po_client.lineitemPO.documentslineitemPO.DeliveryOrderlineitemPO;
import state.ResultMessage;
import dataservice_client.documentsdataservice.DeliveryOrderdataservice;

public class DeliveryOrderdataservice_Stub implements DeliveryOrderdataservice{

	@Override
	public DeliveryOrderPO addDeliveryOrder(String id,
			ArrayList<String> orsderidlist, String dn, String did, String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrderPO modify(String id, ArrayList<String> orsderidlist,
			String dn, String did, String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrderPO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrderlineitemPO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
