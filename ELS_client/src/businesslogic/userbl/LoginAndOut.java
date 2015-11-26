package businesslogic.userbl;

import java.rmi.RemoteException;
import dataservice.userdataservice.Logindataservice;
import RMI.RMIHelper;
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
	public Object login(String id, String passWord) {
		
		Object o = logindataservice.login(id, passWord);
		
		return o;
	}

	@Override
	public void logout() {
		logindataservice.logout();
	}
	
}
