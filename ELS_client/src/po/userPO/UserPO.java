package po.userPO;

import java.io.Serializable;

public class UserPO implements Serializable{
    private String Id;
    private String password;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
