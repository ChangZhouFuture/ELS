package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import dataservice.datafactoryservice.DataFactoryservice;
import dataservice.orderdataservice.Orderdataservice;

public class RMIHelper {
	public static DataFactoryservice dataFactoryservice;
	
	public static void init() {
		try {
			dataFactoryservice = (DataFactoryservice)Naming.lookup
					("rmi://127.0.0.1:6600/dataFactoryservice");
			System.out.println("客户端已连接至服务器端");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Orderdataservice getOrderDataservice() throws RemoteException {
		return dataFactoryservice.getOrderdataservice();
	}
}
