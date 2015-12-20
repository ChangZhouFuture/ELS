package dataservice.stockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.stockPO.StorageListPO;
import state.ResultMessage;

public interface StorageListdataservice extends ParentDocumentsdataservice{
	
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * 前置条件：库存管理人员已经输入了所有入库单参数值
	 * 后置条件：增加一个入库单，更新变动到PO
	 */
	public ResultMessage add(StorageListPO po) throws RemoteException;
	
	/**
	 * 
	 * @param id4obo
	 * 前置条件:要删除的单据在PO中有记录
	 * 后置条件:删除一个入库单,更新PO数据
	 */
	public ResultMessage deleteOne(String id) throws RemoteException;
	
	/**
	 * 
	 * @param id4obo
	 * 前置条件：要删除的单据在PO中有记录
	 * 后置条件：删除多个入库单,更新PO记录
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * 前置条件：要修改的出库单在PO中有记录
	 * 后置条件:修改一个入库单，更新相关信息到PO
	 */
	public ResultMessage update(StorageListPO po) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 
	 * 前置条件：要查询的单据在PO中有记录
	 * 后置条件：根据id查询某入库单,返回入库单PO信息给业务逻辑层
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 
	 * 前置条件：要查询的单据在PO中有记录
	 * 后置条件：根据时间查询某入库单,返回入库单PO信息
	 */
	public JavaBean1 findB(String date) throws RemoteException; 
	
	public String generateId(String date) throws RemoteException;
}
