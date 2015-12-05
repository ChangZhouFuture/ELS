package dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import bean.JavaBean1;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.orderPO.OrderPO;
import state.ResultMessage;

public interface Orderdataservice extends Remote{
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
	public ResultMessage add(OrderPO orderPO);
	
	/**
	 * 前置条件：要删除的订单在PO中有记录
	 * 后置条件：删除一个订单，更新PO
	 * @param orderid
	 */
    public ResultMessage deleteOne(String id) ;
    
    public ResultMessage deleteMany(ArrayList<String> idList) ;
	
    /**
     * 前置条件：
     * 后置条件：根据id查询订单，返回po信息给逻辑层
     * @param id
     * @return
     */
    public JavaBean1 findA(String id) ;
    
    /**
     * 前置条件：
     * 后置条件：根据时间查询订单，返回po信息给逻辑层
     * @param id
     * @return
     */
    public JavaBean1 findB(String date) ;
    
    /**
	 * 
	 * 前置条件：行为或操作已经完成
	 * 后置条件：持久化更新涉及的领域对象的数据
	 */
	public ResultMessage update(OrderPO orderPO) ;
	
	public OrderlineitemPO getOrderlineitemPO(String id);
	
	public String generateId() ;

}
