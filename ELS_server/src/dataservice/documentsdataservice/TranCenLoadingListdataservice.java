package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import bean.JavaBean1;
import po.documentsPO.TranCenLoadingListPO;
import state.ResultMessage;

public interface TranCenLoadingListdataservice extends Remote{

	public ResultMessage addLoadingList(TranCenLoadingListPO po) throws RemoteException;
	
	public ResultMessage deleteOne(String Id) throws RemoteException;
	
	public ResultMessage deleteMany(ArrayList<String> Ids) throws RemoteException;
	
	public ResultMessage update(TranCenLoadingListPO po) throws RemoteException;
	
	public JavaBean1 findA(String Id) throws RemoteException;
	
	public JavaBean1 findB(String date) throws RemoteException;
	
	public String generateId(String date) throws RemoteException;
}
