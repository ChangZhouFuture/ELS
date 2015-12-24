package dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.JavaBean3;
import bean.JavaBean4;
import bean.JavaBean5;
import po.stockPO.StockPO;
import state.ResultMessage;


public interface Stockdataservice extends Remote{
	
	/**
	 * 
	 * 前置：库存管理人员已被识别和授权
	 * 后置：返回当天的库存信息
	 * @return
	 * @throws SQLException 
	 * 
	 */
	public JavaBean3 stockCount(String date) throws RemoteException;
	
	/**
	 * 前置：库存管理人员已被识别和授权
	 * 后置：调整分区，更新库存
	 * 
	 * @return
	 */
	public ResultMessage adjustPartition(ArrayList<String> IDList,String area)
			throws RemoteException;
	
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
	public ResultMessage storage(StockPO po) throws RemoteException;
	
	/**
	 * 
	 * 前置：库存管理人员已经放在货物架上的快递取出
	 * 后置：出库，记录新的架位状态
	 * 
	 */
	public ResultMessage outBound(String id) throws RemoteException;
}
