package dataservice_server.documentsdataservice;

import java.util.ArrayList;

import po_server.documentsPO.ArrivalOrder4BusiHallPO;
import po_server.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;

public interface ArrivalOrder4BusiHalldataservice {
	
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
		public ResultMessage addArrivalOrder4BusiHall(ArrivalOrder4BusiHallPO arrivalOrder4BusiHallPO);
		
		/**
		 * 前置：要修改的营业厅到达单在PO中有记录
		 * 后置：更改一个营业厅到达单，更新PO相关信息
		 * @param id
		 * @param toid
		 * @param sa
		 * @param d
		 * @param gs
		 * @return 更改后的营业厅到达单
		 */
		public ResultMessage update(ArrivalOrder4BusiHallPO arrivalOrder4BusiHallPO);
		
		/**
		 * 前置：要删除的营业厅到达单在PO中有记录
		 * 后置：删除一个营业厅到达单，更新PO数据
		 * @param id
		 */
		public ResultMessage deleteone(String id);
		
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
		public ArrivalOrder4BusiHallPO findA(String id);
		
		/**
		 * 前置：要查询的营业厅到达单在PO中有记录
		 * 后置：根据时间查询某营业厅到达单,返回营业厅到达单PO信息
		 * @param time
		 * @return 营业厅到达单列表
		 */
		public ArrayList<ArrivalOrder4BusiHallPO> findB(String time);//****-**-** 
		
		/**
		 * 前置：
		 * 后置：查询所有营业厅到达单
		 * @param time
		 * @return
		 */
		public ArrayList<ArrivalOrder4BusiHallPO> findC();
		
		
}
