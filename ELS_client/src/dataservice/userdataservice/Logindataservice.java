package dataservice.userdataservice;

import java.rmi.Remote;

import bean.JavaBean2;

public interface Logindataservice extends Remote{
	public JavaBean2 login(String id, String passWord);
	
	public void logout();
}
