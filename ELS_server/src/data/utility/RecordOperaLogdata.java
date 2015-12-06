package data.utility;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.utilitydataservice.RecordOperaLogdataservice;
import state.OperaType;
import state.ResultMessage;

public class RecordOperaLogdata extends UnicastRemoteObject implements RecordOperaLogdataservice{

	public RecordOperaLogdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage recordOperaLog(OperaType type, String date, String objectType, String id, String operatorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
