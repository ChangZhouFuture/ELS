package businesslogicservice.userblservice;

public interface LoginAndOutblservice {

	public Object login(String id, String passWord, String identity);
	
	public void logout();
}
