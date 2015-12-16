package dataservice.utilitydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import bean.JavaBean1;

public interface ParentDocumentsdataservice extends Remote{
	public JavaBean1 findA(String id) throws RemoteException;
	
	public JavaBean1 findB(String date) throws RemoteException;
}
