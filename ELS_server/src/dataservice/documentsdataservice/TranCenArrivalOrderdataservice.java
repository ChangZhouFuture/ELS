package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.TranCenArrivalOrderPO;
import state.ResultMessage;
 
/**
 * @author 朱俊文
 * 该接口提供与中转中心到达单相关的数据层方法
 */
public interface TranCenArrivalOrderdataservice extends ParentDocumentsdataservice{
	
	
	/**
	 * 前置：中转中心业务员已输入所有参数
	 * 后置：增加一个中转中心到达单，更新变动到PO
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @param tcid
	 * @return 一个中转中心到达单
	 */
	public ResultMessage addTranCenArrivalOrder(TranCenArrivalOrderPO tanCenArrivalOrderPO)
	throws RemoteException;
	
	
	/**
	 * 前置：要删除的中转中心到达单在持久化数据中有记录
	 * 后置：删除一个中转中心到达单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist) throws RemoteException; 
	
	/**
	 * 前置：要查询的中转中心到达单在PO中有记录
	 * 后置：根据时间查询某中转中心到达单,返回中转中心到达单PO信息到业务逻辑层
	 * @param id
	 * @return 中转中心到达单信息
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	/**
	 * 前置：要查询的中转中心到达单在PO中有记录
	 * 后置：根据时间查询某中转中心到达单,返回中转中心到达单PO信息
	 * @param time
	 * @return 中转中心到达单列表
	 */
	public JavaBean1 findB(String time) throws RemoteException;
	
	/**
	 * 前置：行为或操作已经完成
	 * 后置：持久化更新设计的领域对象的数据
	 */
	public ResultMessage update(TranCenArrivalOrderPO tranCenArrivalOrderPO) throws 
	RemoteException;
	
	public String generateId(String date) throws RemoteException;
	
	public String generateStartAdd(String transferOrderId) throws RemoteException;
 }
