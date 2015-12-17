package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import bean.JavaBean1;
import po.inforManagementPO.SalaryStrategyPO;
import state.ResultMessage;

public interface StaffInfordataservice extends Remote{
       
	    public JavaBean1 findA(String Id) throws RemoteException;
	    
	    public JavaBean1 findB(String position) throws RemoteException;
	    
        public ResultMessage updateSalaryStrategy(SalaryStrategyPO po) throws RemoteException;
}
