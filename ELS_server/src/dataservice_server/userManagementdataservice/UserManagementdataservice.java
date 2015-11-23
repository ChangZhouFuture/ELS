package dataservice_server.userManagementdataservice;

import java.util.ArrayList;

import po_server.UserManagementPO;
import state.ResultMessage;

public interface UserManagementdataservice {
	 public ResultMessage add(UserManagementPO po);
	    
	    public ResultMessage deleteOne(String Id);
	    
	    public ResultMessage deleteMany(ArrayList<String> Ids);
	    
	    public ResultMessage update(UserManagementPO po);
	    
	    public UserManagementPO find(String Id);
}
