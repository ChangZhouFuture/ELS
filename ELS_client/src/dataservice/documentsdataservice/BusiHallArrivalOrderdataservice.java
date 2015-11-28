package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;
import bean.JavaBean1;
import po.documentsPO.BusiHallArrivalOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;

/**
 * 
 * @author 朱俊文
 * 该接口提供与营业厅到达单单相关的数据层方法
 *
 */
 public interface BusiHallArrivalOrderdataservice extends Remote{
 
	 /**
		 * 前置：
		 * 后置：添加中转单
		 * @param id
		 * @return
		 */
		 public TransferOrderlineitemPO addTransferOrder(String id);
		 
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
		public ResultMessage addBusiHallArrivalOrder(BusiHallArrivalOrderPO busiHallArrivalOrder);
		
		/**
		 * 前置：要删除的营业厅到达单在PO中有记录
		 * 后置：删除一个营业厅到达单，更新PO数据
		 * @param id
		 */
		public ResultMessage deleteOne(String id);
		
		/**
		 * 前置：要删除的营业厅到达单在持久化数据中有记录
		 * 后置：删除多个营业厅到达单，更新PO数据
		 * @param id
		 */
		public ResultMessage deleteMany(ArrayList<String> idlist);
		
		/**
		 * 前置：要查询的营业厅到达单在PO中有记录
		 * 后置：根据id查询某营业厅到达单,返回营业厅到达单PO信息给业务逻辑层
		 * @param id
		 * @return 营业厅到达单信息
		 */
		public JavaBean1 findA(String id);
		
		/**
		 * 前置：要查询的营业厅到达单在PO中有记录
		 * 后置：根据时间查询某营业厅到达单,返回营业厅到达单PO信息
		 * @param time
		 * @return 营业厅到达单列表
		 */
		public JavaBean1 findB(String time);
		
		/**
		 * 前置：
		 * 后置：查询所有营业厅到达单
		 * @param time
		 * @return
		 */
		public ArrayList<BusiHallArrivalOrderPO> findC();
		
		/**
		 * 前置：行为或操作已经完成
		 * 后置：修改相关单据
		 */
		public ResultMessage update(BusiHallArrivalOrderPO busiHallArrivalOrder);
		
		public String generateStartAdd(String transferOrderId);
		
		public String generateId();
 }
