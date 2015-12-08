package dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import bean.JavaBean3;
import bean.JavaBean4;
import bean.JavaBean5;
import po.stockPO.StorageListPO;
import state.ResultMessage;


public interface Stockdataservice extends Remote{
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * 前置：库存管理人员已经被识别和授权
	 * 后置：返回这一时间段内的库存变动信息
	 */
	public JavaBean5 stockCheck(String startDate, String endDate) throws RemoteException;
	
	/**
	 * 
	 * 前置：库存管理人员已被识别和授权
	 * 后置：返回当天的库存信息
	 * @return
	 * 
	 */
	public JavaBean3 stockCount(String generateTime) throws RemoteException;
	
	/**
	 * 前置：库存管理人员已被识别和授权
	 * 后置：调整分区，更新库存
	 * 
	 * @return
	 */
	public ResultMessage adjustPartition(String id,String area) throws RemoteException;
	
	/**
	 * 后置：发出警报
	 */
	public JavaBean4 stockAlarm() throws RemoteException;
	
	/**
	 * 
	 * 前置：库存管理人员已经把快递放在货物架上
	 * 后置：入库，记录新的架位状态
	 * 
	 */
	public ResultMessage storage(StorageListPO po) throws RemoteException;
	
	/**
	 * 
	 * 前置：库存管理人员已经放在货物架上的快递取出
	 * 后置：出库，记录新的架位状态
	 * 
	 */
	public ResultMessage outBound(String id) throws RemoteException;
}
