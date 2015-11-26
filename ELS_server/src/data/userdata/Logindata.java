package data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.userdataservice.Logindataservice;


public class Logindata extends UnicastRemoteObject implements Logindataservice{

	public Logindata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void logout() {
		
		
	}

	@Override
	public Object login(String id, String passWord) {
		// TODO Auto-generated method stub
		return null;
	}

}
