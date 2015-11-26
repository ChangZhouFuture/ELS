package dataservice.userManagementdataservice;

import java.util.ArrayList;

import po.userPO.UserPO;
import state.ResultMessage;

public interface UserManagementdataservice {
    public ResultMessage add(UserPO po);
    
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage update(UserPO po);
    
    public UserPO find(String Id);
}
