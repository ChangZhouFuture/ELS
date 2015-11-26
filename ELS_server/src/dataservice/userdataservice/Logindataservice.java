package dataservice.userdataservice;

import java.rmi.Remote;

public interface Logindataservice extends Remote{
	public Object login(String id, String passWord);
	
	public void logout();
}
