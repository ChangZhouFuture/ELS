package dataservice_client_Stub.documentsdataservice_Stub;

import java.util.ArrayList;

import po_client.documentsPO.ArrivalOrder4TranCenPO;
import po_client.lineitemPO.documentslineitemPO.ArrivalOrder4TranCenlineitemPO;
import state.GoodState;
import state.ResultMessage;
import dataservice_client.documentsdataservice.ArrivalOrder4TranCendataservice;

public class ArrivalOrder4TranCendataservice_Stub implements ArrivalOrder4TranCendataservice{

	@Override
	public ArrivalOrder4TranCenPO addArrivalOrder4TranCen(String id,
			String toid, String sa, String d, GoodState gs, String tcid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4TranCenPO modify(String id, String toid, String sa,
			String d, GoodState gs, String tcid) {
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
	public ArrivalOrder4TranCenPO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4TranCenlineitemPO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
