package data.managerAndAccountantdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.managerAndAccountantdataservice.Approdocmdataservice;


public class Approdocmdata extends UnicastRemoteObject implements Approdocmdataservice{

	public Approdocmdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object inquireB(String kind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object inquireC(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object modify() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
