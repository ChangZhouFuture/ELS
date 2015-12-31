package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.orderPO.OrderPO;
import state.ResultMessage;

public interface Orderdataservice extends ParentDocumentsdataservice{
	/**
	 * 前置条件：输入所有订单参数
     * 后置条件：增加一个订单，更新同步到PO
	 * @param sender
	 * @param addressee
	 * @param desti
	 * @param startingPlace
	 * @param eType
	 * @param name
	 * @param id
	 * @param num
	 * @return
	 */
	public ResultMessage add(OrderPO orderPO) throws RemoteException;
    
    public ResultMessage deleteMany(ArrayList<String> idList) throws RemoteException;
	
    /**
     * 前置条件：
     * 后置条件：根据id查询订单，返回po信息给逻辑层
     * @param id
     * @return
     */
    public JavaBean1 findA(String id) throws RemoteException;
    
    /**
     * 前置条件：
     * 后置条件：根据时间查询订单，返回po信息给逻辑层
     * @param id
     * @return
     */
    public JavaBean1 findB(String date) throws RemoteException;
    
    /**
	 * 
	 * 前置条件：行为或操作已经完成
	 * 后置条件：持久化更新涉及的领域对象的数据
	 */
	public ResultMessage update(OrderPO orderPO) throws RemoteException;
	
	public ResultMessage receive(String id,String date,String trueAddresseeName) throws RemoteException;
	
	public OrderlineitemPO getOrderlineitemPO(String id) throws RemoteException;
	
	public String generateId(String date) throws RemoteException;

	public String expectedArrivalDate(String date,String senderAdd,String addresseeAdd) throws RemoteException, ParseException;//参数为订单生成日期
	
	public double getOrderAmount(String orderID) throws RemoteException;
}
