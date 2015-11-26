package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.documentsdataservice.TransferCenterLoadingListdataservice;

public class TransferCenterLoadingListdata extends UnicastRemoteObject implements TransferCenterLoadingListdataservice {

	public TransferCenterLoadingListdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
