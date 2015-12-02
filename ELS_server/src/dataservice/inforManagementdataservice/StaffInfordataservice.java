package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import bean.JavaBean1;
import po.userPO.UserPO;
import state.ResultMessage;

public interface StaffInfordataservice extends Remote{
       
	    
	    public JavaBean1 find(String Id);
	    
        public ResultMessage update(UserPO po);
}
