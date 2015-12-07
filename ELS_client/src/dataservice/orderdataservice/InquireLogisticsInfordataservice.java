package dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import bean.JavaBean1;

public interface InquireLogisticsInfordataservice extends Remote{
	public JavaBean1 inquireLogisticsInfor(String orderID) throws RemoteException;
}
