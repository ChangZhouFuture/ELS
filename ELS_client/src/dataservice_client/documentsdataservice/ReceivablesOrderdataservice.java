package dataservice_client.documentsdataservice;

import java.util.ArrayList;

import po_client.documentsPO.ReceivablesOrderPO;
import po_client.lineitemPO.documentslineitemPO.ReceivablesOrderlineitemPO;
import po_client.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;


public interface ReceivablesOrderdataservice {
	/**
	 * 
	 * @param date4RO
	 * @param amount4RO
	 * @param courier4RO
	 * @param barCode
	 * @return
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的收款单信息
	 */
	public ResultMessage add(ReceivablesOrderPO receivablesOrderPO);
		
	/**
	 * 
	 * @param id
	 * @return
	 * 前置条件：要删除的收款单信息在PO中有记录
	 * 后置条件：删除一条收款单信息
	 * 
	 */
	public ResultMessage deleteOne(String id);

	/**
	 * 
	 * @param id4courier
	 * @param date
	 * 前置条件：要删除的收款单信息在持久化数据中有记录
	 * 后置条件：删除多条收款单信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList);
	
//	/**
//	 * 
//	 * @param id4courier
//	 * @param date
//	 * @return
//	 * 前置条件：要修改的收款单信息在PO中有记录
//	 * 后置条件：修改收款单信息，并更新VO和PO
//	 */
//	public ReceivablesOrderPO modify(String id4courier,String date);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * 前置条件：要查询的收款单信息在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public ReceivablesOrderPO findA(String id);
	
	public ReceivablesOrderlineitemPO findB(String date);
	
	public ArrayList<OrderlineitemPO> generateOrder(String courierId);
	
	public double generateFreight();
	/**
	 * 前置条件：收款单信息处理完成
	 * 后置条件：结束这次收款单信息处理，更新数据持久化对象
	 */
	public ResultMessage update(ReceivablesOrderPO receivablesOrderPO);
}
