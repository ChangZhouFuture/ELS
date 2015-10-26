package dataservice_client_Stub.documentsdataservice_Stub;

import java.util.ArrayList;

import po_client.documentsPO.ArrivalOrder4BusiHallPO;
import po_client.lineitemPO.documentslineitemPO.ArrivalOrder4BusiHalllineitemPO;
import state.GoodState;
import state.ResultMessage;
import dataservice_client.documentsdataservice.ArrivalOrder4BusiHalldataservice;

public class ArrivalOrder4BusiHalldataservice_Stub implements ArrivalOrder4BusiHalldataservice{

	@Override
	public ArrivalOrder4BusiHallPO addArrivalOrder4BusiHall(String id,
			String toid, String sa, String d, GoodState gs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4BusiHallPO modify(String id, String toid, String sa,
			String d, GoodState gs) {
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
	public ArrivalOrder4BusiHallPO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4BusiHalllineitemPO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
