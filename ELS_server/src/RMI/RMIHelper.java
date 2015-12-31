package RMI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import data.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryservice;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIHelper {
	private String fileName = "������IP��ַ.txt";
	private String URL;
	private DataFactoryservice dataFactoryservice;
	private Remote reg;
	
	public void init() {
		try {
			File file = new File(fileName);
			BufferedReader bf = new BufferedReader(new FileReader(file));
			URL = bf.readLine();
			bf.close();
			
			reg = LocateRegistry.createRegistry(6602);
			dataFactoryservice = new DataFactory();
			Naming.rebind("rmi://" + URL + ":6602/dataFactoryservice", 
					dataFactoryservice);
			System.out.println(URL);
			System.out.println("�����������ṩ����");
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
		System.out.println("�������˶˿����ͷ�");
	}
	
	public static void main(String[] args) {
		RMIHelper rmiHelper = new RMIHelper();
		rmiHelper.init();
	}
}
