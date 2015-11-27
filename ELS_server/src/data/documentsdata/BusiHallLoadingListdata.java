package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.documentsPO.BusiHallLoadingListPO;
import po.lineitemPO.documentslineitemPO.BusiHallLoadingListlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.BusiHallLoadingListdataservice;

public class BusiHallLoadingListdata extends UnicastRemoteObject implements BusiHallLoadingListdataservice {

	public BusiHallLoadingListdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public OrderlineitemPO addOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addLoadingList(BusiHallLoadingListPO loadingListPO) {
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
	public BusiHallLoadingListPO findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusiHallLoadingListlineitemPO findB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(BusiHallLoadingListPO loadingListPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

}
