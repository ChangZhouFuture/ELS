package data.documentsdata;

import java.util.ArrayList;

import po.documentsPO.LoadingListPO;
import po.lineitemPO.documentslineitemPO.LoadingListlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.LoadingListdataservice;

public class LoadingListdata implements LoadingListdataservice {

	@Override
	public OrderlineitemPO addOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addLoadingList(LoadingListPO loadingListPO) {
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
	public LoadingListPO findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoadingListlineitemPO findB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(LoadingListPO loadingListPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

}
