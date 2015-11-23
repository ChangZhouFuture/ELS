package dataservice_client.inforManagementdataservice;

import java.util.ArrayList;

import po_client.inforManagementPO.BankAccountPO;
import po_client.lineitemPO.inforManagementlineitemPO.BankAccountlineitemPO;
import state.ResultMessage;

public interface BankAccountInfordataservice {
    public ResultMessage add(BankAccountPO po);
     
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage update(BankAccountPO po);
    
    public BankAccountPO find(String Id);
}
