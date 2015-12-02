package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import bean.JavaBean1;
import po.inforManagementPO.BankAccountPO;
import state.ResultMessage;

public interface BankAccountInfordataservice extends Remote{
    public ResultMessage add(BankAccountPO po);
     
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage update(BankAccountPO po);
    
    public JavaBean1 find(String Id);
}
