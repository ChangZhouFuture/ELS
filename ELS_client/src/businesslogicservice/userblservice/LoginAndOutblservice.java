package businesslogicservice.userblservice;

import bean.JavaBean2;

public interface LoginAndOutblservice {

	public JavaBean2 login(String id, String passWord);
	
	public void logout();
}
