package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.documentsPO.BusiHallLoadingListPO;
import po.lineitemPO.documentslineitemPO.BusiHallLoadingListlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;

/**
 * @author 朱俊文
 * 该接口提供与装车单相关的数据层方法
 */
 public interface BusiHallLoadingListdataservice extends Remote{
 
	 public OrderlineitemPO addOrder(String id);
	 
	/**
	 * 前置：营业厅业务员已输入所有参数
	 * 后置：增加一个装车单，更新变动到PO
	 */
	public ResultMessage addLoadingList(BusiHallLoadingListPO loadingListPO);
	

	/**
	 * 前置：要删除的装车单在PO中有记录
	 * 后置：删除一个装车单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * 前置：要删除的装车单在PO中有记录
	 * 后置：删除多个装车单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * 前置：要查询的装车单在PO中有记录
	 * 后置：根据时间查询某装车单,返回装车单PO信息给业务逻辑层
	 * @param id
	 * @return 装车单信息
	 */
	public BusiHallLoadingListPO findA(String id);
	
	/**
	 * 前置：要查询的装车单在PO中有记录
	 * 后置：根据时间查询某装车单,返回装车单PO信息
	 * @param time
	 * @return 装车单列表
	 */
	public BusiHallLoadingListlineitemPO findB(String time);
	
	/**
	 * 前置：行为或操作已经完成
	 * 后置：持久化更新设计的领域对象的数据
	 */
	public ResultMessage update(BusiHallLoadingListPO loadingListPO);
	
	public String generateId();
	
 }
