package dataservice_server.inforManagementdataservice;

import java.util.ArrayList;

import po_server.inforManagementPO.BankAccountPO;
import state.ResultMessage;

public interface BankAccountInfordataservice {
	 public ResultMessage add(BankAccountPO po);
     
	    public ResultMessage deleteOne(String name);
	    
	    public ResultMessage deleteMany(ArrayList<String> names);
	    
	    public ResultMessage update(BankAccountPO po);
	    
	    public BankAccountPO find(String name);
}
