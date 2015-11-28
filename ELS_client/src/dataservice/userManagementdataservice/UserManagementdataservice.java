package dataservice.userManagementdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import bean.JavaBean1;
import po.userPO.UserPO;
import state.ResultMessage;

public interface UserManagementdataservice extends Remote{
    public ResultMessage add(UserPO po);
    
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage update(UserPO po);
    
    public JavaBean1 find(String Id);
}
