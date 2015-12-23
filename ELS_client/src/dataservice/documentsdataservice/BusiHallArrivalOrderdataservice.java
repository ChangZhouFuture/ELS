package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.BusiHallArrivalOrderPO;
import state.ResultMessage;

/**
 * 
 * @author 朱俊文
 * 该接口提供与营业厅到达单单相关的数据层方法
 *
 */
 public interface BusiHallArrivalOrderdataservice extends ParentDocumentsdataservice{
 

		 
		/**
		 * 前置：营业厅业务员已输入所有参数
		 * 后置：增加一个营业厅到达单，更新PO
		 * @param id
		 * @param toid
		 * @param sa
		 * @param d
		 * @param gs 
		 * @return 一个营业厅到达单
		 */
		public ResultMessage addBusiHallArrivalOrder(BusiHallArrivalOrderPO busiHallArrivalOrder)
		throws RemoteException;
		
		
		/**
		 * 前置：要删除的营业厅到达单在持久化数据中有记录
		 * 后置：删除多个营业厅到达单，更新PO数据
		 * @param id
		 */
		public ResultMessage deleteMany(ArrayList<String> idlist) throws RemoteException;
		
		/**
		 * 前置：要查询的营业厅到达单在PO中有记录
		 * 后置：根据id查询某营业厅到达单,返回营业厅到达单PO信息给业务逻辑层
		 * @param id
		 * @return 营业厅到达单信息
		 */
		public JavaBean1 findA(String id) throws RemoteException;
		
		/**
		 * 前置：要查询的营业厅到达单在PO中有记录
		 * 后置：根据时间查询某营业厅到达单,返回营业厅到达单PO信息
		 * @param time
		 * @return 营业厅到达单列表
		 */
		public JavaBean1 findB(String time) throws RemoteException;
	
		
		/**
		 * 前置：行为或操作已经完成
		 * 后置：修改相关单据
		 */
		public ResultMessage update(BusiHallArrivalOrderPO busiHallArrivalOrder) throws
		RemoteException;
		
		public String generateStartAdd(String transferOrderId) throws RemoteException;
		
		public String generateId(String date) throws RemoteException;
 }
