package businesslogic.userbl;

import dataservice.userdataservice.Logindataservice;
import businesslogicservice.userblservice.LoginAndOutblservice;

public class LoginAndOut implements LoginAndOutblservice{
	Logindataservice logindataservice;
	
	@Override
	public Object login(String id, String passWord, String identity) {
		
		Object o = logindataservice.login(id, passWord, identity);
		
		return o;
	}

	@Override
	public void logout() {
		logindataservice.logout();
	}
	
}
