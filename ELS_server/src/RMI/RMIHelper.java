package RMI;

import java.rmi.Naming;
import data.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryservice;
import java.rmi.registry.LocateRegistry;

public class RMIHelper {
	
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(6600);
			DataFactoryservice dataFactoryservice = new DataFactory();
			Naming.rebind("rmi://127.0.0.1:6600/dataFactoryservice", dataFactoryservice);
			System.out.println("�����������ṩ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
