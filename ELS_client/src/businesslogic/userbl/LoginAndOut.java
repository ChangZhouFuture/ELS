package businesslogic.userbl;

import java.rmi.RemoteException;

import dataservice.userdataservice.Logindataservice;
import RMI.RMIHelper;
import bean.JavaBean2;
import businesslogicservice.userblservice.LoginAndOutblservice;

public class LoginAndOut implements LoginAndOutblservice{
	Logindataservice logindataservice;
	JavaBean2 javaBean2;
	
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
			javaBean2 = logindataservice.login(id, passWord);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("´íÎó");
		}
		
		return javaBean2;
	}

	public static void main(String[] args) {
		RMIHelper.init();
		LoginAndOut loginAndOut = new LoginAndOut();
		loginAndOut.login("12345678", "12345678");
	}
}
