package dataservice.datafactoryservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import dataservice.orderdataservice.Orderdataservice;

public interface DataFactoryservice extends Remote{
	public Orderdataservice getOrderdataservice() throws RemoteException;
	
}
