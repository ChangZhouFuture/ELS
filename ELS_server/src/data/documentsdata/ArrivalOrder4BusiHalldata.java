package data.documentsdata;

import java.util.ArrayList;

import po.documentsPO.ArrivalOrder4BusiHallPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import dataservice.documentsdataservice.ArrivalOrder4BusiHalldataservice;
import state.ResultMessage;

public class ArrivalOrder4BusiHalldata implements
		ArrivalOrder4BusiHalldataservice {

	@Override
	public TransferOrderlineitemPO addTransferOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addArrivalOrder4BusiHall(
			ArrivalOrder4BusiHallPO arrivalOrder4BusiHallPO) {
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
	public ArrivalOrder4BusiHallPO findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalOrder4BusiHallPO> findB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalOrder4BusiHallPO> findC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(ArrivalOrder4BusiHallPO arrivalOrder4BusiHallPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateStartAdd(String transferOrderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

}
