package data.documentsdata;

import java.util.ArrayList;

import po.documentsPO.BusinessHallLoadingListPO;
import po.lineitemPO.documentslineitemPO.BusinessHallLoadingListlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.BuinessHallLoadingListdataservice;

public class BuinessHallLoadingList implements BuinessHallLoadingListdataservice {

	@Override
	public OrderlineitemPO addOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addLoadingList(BusinessHallLoadingListPO loadingListPO) {
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
	public BusinessHallLoadingListPO findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessHallLoadingListlineitemPO findB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(BusinessHallLoadingListPO loadingListPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

}
