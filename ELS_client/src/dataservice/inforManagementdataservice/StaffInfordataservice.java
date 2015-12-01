package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;

public interface StaffInfordataservice extends Remote{
//		public ResultMessage add(StaffPO po);
	    
	    public JavaBean1 find(String Id);
	    
	    public ResultMessage deleteOne(String Id);
	    
	    public ResultMessage deleteMany(ArrayList<String> Ids);
	    
//	    public ResultMessage update(StaffPO po);
}
