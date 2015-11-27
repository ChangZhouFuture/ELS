package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.documentsdataservice.TranCenLoadingListdataservice;

public class TranCenLoadingListdata extends UnicastRemoteObject implements TranCenLoadingListdataservice {

	public TranCenLoadingListdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
