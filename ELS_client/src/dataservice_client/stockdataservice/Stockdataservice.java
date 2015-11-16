package dataservice_client.stockdataservice;

import po_client.stockPO.StockPO;


public interface Stockdataservice {
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * 前置：库存管理人员已经被识别和授权
	 * 后置：返回这一时间段内的库存变动信息
	 */
	public StockPO stockCheck(String startDate, String endDate);
	
	/**
	 * 
	 * 前置：库存管理人员已被识别和授权
	 * 后置：返回当天的库存信息
	 * @return
	 * 
	 */
	public StockPO stockCount();
	
	/**
	 * 前置：库存管理人员已被识别和授权
	 * 后置：调整分区，更新库存
	 * 
	 * @return
	 */
	public String adjustPartition();
	
	/**
	 * 后置：发出警报
	 */
	public void stockAlarm();
	
	/**
	 * 
	 * 前置：库存管理人员已经把快递放在货物架上
	 * 后置：入库，记录新的架位状态
	 * 
	 */
	public void storage();
	
	/**
	 * 
	 * 前置：库存管理人员已经放在货物架上的快递取出
	 * 后置：出库，记录新的架位状态
	 * 
	 */
	public void outBound();
}
