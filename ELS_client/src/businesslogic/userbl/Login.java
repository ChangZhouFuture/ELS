package businesslogic.userbl;

import java.rmi.RemoteException;

import dataservice.userdataservice.Logindataservice;
import RMI.RMIHelper;
import bean.JavaBean2;
import businesslogicservice.userblservice.Loginblservice;

public class Login implements Loginblservice{
	Logindataservice logindataservice;
	JavaBean2 javaBean2;
	public static String id;
	public static String agencyID;
	public static String city;
	public static String region;
	
	public Login() {
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
			System.out.println("����");
		}
		this.id = id;
		city = javaBean2.getCity();
		region = javaBean2.getRegion();
		agencyID = javaBean2.getAgencyID();
		
		return javaBean2;
	}

	public static void main(String[] args) {
		RMIHelper.init();
		Login loginAndOut = new Login();
		loginAndOut.login("12345678", "12345678");
	}
}
