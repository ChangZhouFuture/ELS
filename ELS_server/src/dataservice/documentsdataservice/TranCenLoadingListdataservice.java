package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.TranCenLoadingListPO;
import state.ResultMessage;

public interface TranCenLoadingListdataservice extends ParentDocumentsdataservice{

	public ResultMessage addLoadingList(TranCenLoadingListPO po) throws RemoteException;
	
	public ResultMessage deleteOne(String Id) throws RemoteException;
	
	public ResultMessage deleteMany(ArrayList<String> Ids) throws RemoteException;
	
	public ResultMessage update(TranCenLoadingListPO po) throws RemoteException;
	
	public JavaBean1 findA(String Id) throws RemoteException;
	
	public JavaBean1 findB(String date) throws RemoteException;
	
	public String generateId(String date) throws RemoteException;
}
