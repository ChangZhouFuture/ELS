package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import bean.JavaBean1;
import po.inforManagementPO.SalaryStrategyPO;
import state.ResultMessage;

public interface StaffInfordataservice extends Remote{
       
	    public JavaBean1 findA(String Id) throws RemoteException;
	    
	    public JavaBean1 findB(String position) throws RemoteException;
	    
	    public JavaBean1 getSalaryStrategy() throws RemoteException;
	    
        public ResultMessage updateSalaryStrategy(ArrayList<SalaryStrategyPO>
        salaryStrategyPOs) throws RemoteException;
}
