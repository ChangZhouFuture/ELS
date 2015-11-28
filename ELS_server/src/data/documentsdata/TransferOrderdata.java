package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import bean.JavaBean1;
import po.documentsPO.TransferOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;
import state.TransportType;
import dataservice.documentsdataservice.TransferOrderdataservice;


public class TransferOrderdata extends UnicastRemoteObject implements TransferOrderdataservice {

	public TransferOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage addTransferOrder(String id, TransportType tst,
			String sa, String ea, ArrayList<String> oidl, String d,
			String hbid, String hgid, String Jzy) {
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
	public JavaBean1 findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 findB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(TransferOrderPO transferOrderPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderlineitemPO getTransferOrderlineitemPO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

}
