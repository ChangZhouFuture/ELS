package businesslogic_client.userbl;

import dataservice_client.userdataservice.Logindataservice;
import businesslogicservice_client.userblservice.LoginAndOutblservice;

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
