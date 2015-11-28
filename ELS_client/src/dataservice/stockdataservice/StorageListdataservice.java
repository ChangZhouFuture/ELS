package dataservice.stockdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import bean.JavaBean1;
import po.lineitemPO.stocklineitemPO.StorageListlineitemPO;
import po.stockPO.StorageListPO;
import state.ResultMessage;

public interface StorageListdataservice extends Remote{
	
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * 前置条件：库存管理人员已经输入了所有入库单参数值
	 * 后置条件：增加一个入库单，更新变动到PO
	 */
	public ResultMessage add(StorageListPO storageListPO);
	
	/**
	 * 
	 * @param id4obo
	 * 前置条件:要删除的单据在PO中有记录
	 * 后置条件:删除一个入库单,更新PO数据
	 */
	public ResultMessage deleteone(String id4obo);
	
	/**
	 * 
	 * @param id4obo
	 * 前置条件：要删除的单据在PO中有记录
	 * 后置条件：删除多个入库单,更新PO记录
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4obo);
	
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
	public StorageListPO modify(String id, String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * 前置条件：要查询的单据在PO中有记录
	 * 后置条件：根据id查询某入库单,返回入库单PO信息给业务逻辑层
	 */
	public JavaBean1 findA(String id);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * 前置条件：要查询的单据在PO中有记录
	 * 后置条件：根据时间查询某入库单,返回入库单PO信息
	 */
	public JavaBean1 findB(String time);
	
	/**
	 * 
	 * 前置条件：行为或操作已经完成
	 * 后置条件：持久化更新涉及的领域对象的数据
	 */
	public void update();
}
