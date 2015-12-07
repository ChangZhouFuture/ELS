package data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import bean.JavaBean1;
import dataservice.orderdataservice.InquireLogisticsInfordataservice;

public class InquireLogisticsInfordata extends UnicastRemoteObject
implements InquireLogisticsInfordataservice{

	protected InquireLogisticsInfordata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public JavaBean1 inquireLogisticsInfor(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

}
