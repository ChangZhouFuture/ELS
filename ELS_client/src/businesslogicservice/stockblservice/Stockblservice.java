package businesslogicservice.stockblservice;

import java.util.ArrayList;

import po.stockPO.StorageListPO;
import bean.JavaBean3;
import bean.JavaBean4;
import bean.JavaBean5;
import state.ResultMessage;

public interface Stockblservice {
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * 前置：库存管理人员已经被识别和授权
	 * 后置：返回这一时间段内的库存变动信息
	 */
	public JavaBean5 stockCheck(String startDate, String endDate);
	
	/**
	 * 
	 * 前置：库存管理人员已被识别和授权
	 * 后置：返回当天的库存信息
	 * @return
	 * 
	 */
	public JavaBean3 stockCount();
	
	/**
	 * 前置：库存管理人员已被识别和授权
	 * 后置：调整分区，更新库存
	 * 
	 * @return
	 */
	public JavaBean4 adjustPartition(ArrayList<String> IDList, String area);
	
	/**
	 * 后置：发出警报
	 */
	public JavaBean4 stockAlarm();
	
	/**
	 * 
	 * 前置：库存管理人员已经把快递放在货物架上
	 * 后置：入库，记录新的架位状态
	 * 
	 */
	public ResultMessage storage(StorageListPO po);
	
	/**
	 * 
	 * 前置：库存管理人员已经放在货物架上的快递取出
	 * 后置：出库，记录新的架位状态
	 * 
	 */
	public ResultMessage outBound(String id);
}
