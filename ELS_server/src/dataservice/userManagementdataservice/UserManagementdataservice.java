package dataservice.userManagementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import bean.JavaBean1;
import po.userPO.UserPO;
import state.Position;
import state.ResultMessage;

public interface UserManagementdataservice extends Remote{
    public ResultMessage add(UserPO po) throws RemoteException;
    
    public ResultMessage deleteMany(ArrayList<String> Ids) throws RemoteException;
    
    public ResultMessage update(UserPO po) throws RemoteException;
    
    public JavaBean1 findA(String Id) throws RemoteException;
    
    public JavaBean1 findB(Position position) throws RemoteException;
    
    public String generateID(Position position) throws RemoteException;
}
