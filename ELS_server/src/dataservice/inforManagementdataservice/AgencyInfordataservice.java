package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import bean.JavaBean1;
import po.inforManagementPO.AgencyPO;
import state.ResultMessage;

public interface AgencyInfordataservice extends Remote{
	public ResultMessage add(AgencyPO po) throws RemoteException;
	
	public ResultMessage deleteOne(String Id) throws RemoteException;
	
	public ResultMessage deleteMany(ArrayList<String> Ids) throws RemoteException;
	
	public ResultMessage update(AgencyPO po) throws RemoteException;
	
	public JavaBean1 find(String Id) throws RemoteException;
	
	public String generateID() throws RemoteException;
}
