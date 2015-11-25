package dataservice_client_Stub.documentsdataservice_Stub;

import java.util.ArrayList;

import po_client.documentsPO.TransferOrderPO;
import po_client.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;
import state.TransportType;
import dataservice_client.documentsdataservice.TransferOrderdataservice;

public class TransferOrderdataservice_Stub implements TransferOrderdataservice{

	@Override
	public TransferOrderPO addTransferOrder(String id, TransportType tst,
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
	public TransferOrderPO findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderlineitemPO findB(String time) {
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

}
