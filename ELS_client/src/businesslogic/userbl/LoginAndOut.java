package businesslogic.userbl;

import java.rmi.RemoteException;

import dataservice.userdataservice.Logindataservice;
import RMI.RMIHelper;
import bean.JavaBean2;
import businesslogicservice.userblservice.LoginAndOutblservice;

public class LoginAndOut implements LoginAndOutblservice{
	Logindataservice logindataservice;
	
	public LoginAndOut() {
		try {
			logindataservice = RMIHelper.getLogindataservice();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean2 login(String id, String passWord) {
		
		try {
			Object o = logindataservice.login(id, passWord);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void logout() {
		try {
			logindataservice.logout();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
