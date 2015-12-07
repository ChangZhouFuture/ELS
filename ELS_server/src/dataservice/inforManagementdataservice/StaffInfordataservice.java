package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import bean.JavaBean1;
import po.userPO.UserPO;
import state.ResultMessage;

public interface StaffInfordataservice extends Remote{
       
	    public JavaBean1 findA(String Id) throws RemoteException;
	    
	    public JavaBean1 findB() throws RemoteException;
	    
        public ResultMessage updateSalaryStrategy(UserPO po) throws RemoteException;
}
