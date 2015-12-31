package RMI;

import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import data.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryservice;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIHelper {
	private DataFactoryservice dataFactoryservice;
	private Remote reg;
	
	public void init() {
		try {
			reg = LocateRegistry.createRegistry(6602);
			dataFactoryservice = new DataFactory();
			Naming.rebind("rmi://127.0.0.1:6602/dataFactoryservice", dataFactoryservice);
			System.out.println("服务器端已提供连接");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void release() {
		try {
			UnicastRemoteObject.unexportObject(reg, true);
		} catch (NoSuchObjectException e) {
			e.printStackTrace();
		}
		reg = null;
		System.out.println("服务器端端口已释放");
	}
	
}
