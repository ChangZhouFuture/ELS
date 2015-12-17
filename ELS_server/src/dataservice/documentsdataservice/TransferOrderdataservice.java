package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.TransferOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;

/**
 * @author 朱俊文
 * 该接口提供与中转单相关的数据层方法
 */
 public interface TransferOrderdataservice extends ParentDocumentsdataservice{
 
	/**
	 * 前置：中转中心业务员已输入所有参数
	 * 后置：增加一个中转单，更新变动到PO
	 * @param id
	 * @param tst
	 * @param sa
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param hbid
	 * @param hgid
	 * @param Jzy
	 * @return 一个中转单
	 */
	public ResultMessage addTransferOrder(TransferOrderPO po) throws RemoteException;
	
	/**
	 * 前置：要删除的中转单在PO中有记录
	 * 后置：删除一个中转单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteOne(String id) throws RemoteException;
	
	/**
	 * 前置：要删除的中转单在PO中有记录
	 * 后置：删除多个中转单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist) throws RemoteException;
	
	/**
	 * 前置：要查询的中转单在PO中有记录
	 * 后置：根据时间查询某中转单,返回中转单PO信息给业务逻辑层
	 * @param id
	 * @return 中转单信息
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	/**
	 * 前置：要查询的中转单在PO中有记录
	 * 后置：根据时间查询某中转单,返回中转单PO信息
	 * @param time
	 * @return 中转单列表
	 */
	public JavaBean1 findB(String date) throws RemoteException;
	
	/**
	 * 前置：行为或操作已经完成
	 * 后置：持久化更新设计的领域对象的数据
	 */
	public ResultMessage update(TransferOrderPO po) throws RemoteException;


	public String generateId(String date,String trancenId) throws RemoteException;
	
	public TransferOrderlineitemPO getTransferOrderlineitemPO(String id) throws RemoteException;;
 }
