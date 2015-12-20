package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import bean.JavaBean1;
import po.inforManagementPO.BankAccountPO;
import state.ResultMessage;

public interface BankAccountInfordataservice extends Remote{
    public ResultMessage add(BankAccountPO po) throws RemoteException;
     
    public ResultMessage deleteOne(String Id) throws RemoteException;
    
    public ResultMessage deleteMany(ArrayList<String> Ids) throws RemoteException;
    
    public ResultMessage update(String oldName,String newName) throws RemoteException;
    
    public JavaBean1 find(String Id) throws RemoteException;
    
    public ResultMessage updateBalance(double amount) throws RemoteException;
    
    public ResultMessage setInUse(String accountName) throws RemoteException;
    
    public String getInUse() throws RemoteException;
}
