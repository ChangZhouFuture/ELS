package data.utility;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.utilitydataservice.RecordOperaLogdataservice;

public class RecordOperaLogdata extends UnicastRemoteObject implements RecordOperaLogdataservice{

	public RecordOperaLogdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
