package dataservice_client.userManagementdataservice;

import java.util.ArrayList;

import po_client.userPO.UserPO;
import state.ResultMessage;

public interface UserManagementdataservice {
    public ResultMessage add(UserPO po);
    
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage update(UserPO po);
    
    public UserPO find(String Id);
}
