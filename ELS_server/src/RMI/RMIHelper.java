package RMI;

import java.io.IOException;
import java.rmi.Naming;

import data.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryservice;

import java.rmi.registry.LocateRegistry;

public class RMIHelper {
	public void init() {
		try {
			LocateRegistry.createRegistry(6602);
			DataFactoryservice dataFactoryservice = new DataFactory();
			Naming.rebind("rmi://127.0.0.1:6602/dataFactoryservice", dataFactoryservice);
			System.out.println("服务器端已提供连接");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		RMIHelper rmiHelper = new RMIHelper();
		rmiHelper.init();
	}
}
