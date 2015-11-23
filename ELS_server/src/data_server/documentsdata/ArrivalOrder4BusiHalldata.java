package data_server.documentsdata;

import java.util.ArrayList;

import dataservice_server.documentsdataservice.ArrivalOrder4BusiHalldataservice;
import po_server.documentsPO.ArrivalOrder4BusiHallPO;
import po_server.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;

public class ArrivalOrder4BusiHalldata implements
		ArrivalOrder4BusiHalldataservice {

	@Override
	public TransferOrderlineitemPO addTransferOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addArrivalOrder4BusiHall(ArrivalOrder4BusiHallPO arrivalOrder4BusiHallPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(ArrivalOrder4BusiHallPO arrivalOrder4BusiHallPO) {
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
	public ArrayList<ArrivalOrder4BusiHallPO> inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalOrder4BusiHallPO> inquireC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
