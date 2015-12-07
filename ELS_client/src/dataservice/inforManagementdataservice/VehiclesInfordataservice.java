package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bean.JavaBean1;
import po.inforManagementPO.VehiclesPO;
import state.ResultMessage;

public interface VehiclesInfordataservice extends Remote{
	/**
	 * 
	 * @param po
	 * @return
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的车辆信息
	 */
	public ResultMessage add(VehiclesPO po) throws RemoteException;
		
	/**
	 * 
	 * @param Id
	 * @return
	 * 前置条件：要删除的车辆信息在PO中有记录
	 * 后置条件：删除一条车辆信息
	 * 
	 */
	public ResultMessage deleteOne(String Id) throws RemoteException;
	/**
	 * 
	 * @param Ids
	 * 前置条件：要删除的车辆信息在持久化数据中有记录
	 * 后置条件：删除多条车辆信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> Ids) throws RemoteException;
	
	/**
	 * 
	 * @param Id
	 * @return
	 * 前置条件：要修改的车辆信息在PO中有记录
	 * 后置条件：修改车辆信息，并更新VO和PO
	 */
	public ResultMessage update(VehiclesPO po) throws RemoteException;
	
	/**
	 * 
	 * @param Id
	 * @return
	 * 前置条件：要查询的车辆信息在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public JavaBean1 findA(String Id) throws RemoteException;
	
	public JavaBean1 findB() throws RemoteException;
	
	public String generateID() throws RemoteException;
}
