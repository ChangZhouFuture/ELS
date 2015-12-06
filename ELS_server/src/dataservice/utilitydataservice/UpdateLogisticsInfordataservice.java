package dataservice.utilitydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import state.ResultMessage;

public interface UpdateLogisticsInfordataservice extends Remote{
	public ResultMessage update(String time, String id, String description) throws 
	RemoteException;
}
