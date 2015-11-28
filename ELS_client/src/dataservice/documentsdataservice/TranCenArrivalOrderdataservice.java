package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import bean.JavaBean1;
import po.documentsPO.TranCenArrivalOrderPO;
import po.lineitemPO.documentslineitemPO.TranCenArrivalOrderlineitemPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
 
/**
 * @author 朱俊文
 * 该接口提供与中转中心到达单相关的数据层方法
 */
public interface TranCenArrivalOrderdataservice extends Remote{
	
public TransferOrderlineitemPO addTransferOrder(String id);
	
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
	public ResultMessage addTranCenArrivalOrder(TranCenArrivalOrderPO tanCenArrivalOrderPO);
	
	/**
	 * 前置：要删除的中转中心到达单在PO中有记录
	 * 后置：删除一个中转中心到达单，更新PO数据
	 * @param id
	 * @return 
	 */
	public ResultMessage deleteOne(String id);
	
	/**
	 * 前置：要删除的中转中心到达单在持久化数据中有记录
	 * 后置：删除一个中转中心到达单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * 前置：要查询的中转中心到达单在PO中有记录
	 * 后置：根据时间查询某中转中心到达单,返回中转中心到达单PO信息到业务逻辑层
	 * @param id
	 * @return 中转中心到达单信息
	 */
	public JavaBean1 findA(String id);
	
	/**
	 * 前置：要查询的中转中心到达单在PO中有记录
	 * 后置：根据时间查询某中转中心到达单,返回中转中心到达单PO信息
	 * @param time
	 * @return 中转中心到达单列表
	 */
	public JavaBean1 findB(String time);
	
	/**
	 * 后置：查询所有中转中心到达单
	 * @return
	 */
	public ArrayList<TranCenArrivalOrderPO> findC();
	
	/**
	 * 前置：行为或操作已经完成
	 * 后置：持久化更新设计的领域对象的数据
	 */
	public ResultMessage update(TranCenArrivalOrderPO tranCenArrivalOrderPO);
	
	public String generateId();
	
	public String generateStartAdd();
 }
