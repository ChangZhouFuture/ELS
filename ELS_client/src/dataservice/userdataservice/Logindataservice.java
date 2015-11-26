package dataservice.userdataservice;

public interface Logindataservice {
	public Object login(String id, String passWord, String identity);
	
	public void logout();
}
