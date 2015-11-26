package dataservice.inforManagementdataservice;

import java.util.ArrayList;

import po.inforManagementPO.BankAccountPO;
import state.ResultMessage;

public interface BankAccountInfordataservice {
    public ResultMessage add(BankAccountPO po);
     
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage update(BankAccountPO po);
    
    public BankAccountPO find(String Id);
}
