package dataservice.utilitydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.utilityPO.LogisticsInforPO;
import state.ResultMessage;

public interface UpdateLogisticsInfordataservice extends Remote{
	public ResultMessage update(LogisticsInforPO po) throws 
	RemoteException;
}
