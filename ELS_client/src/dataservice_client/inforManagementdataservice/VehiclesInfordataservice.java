package dataservice_client.inforManagementdataservice;

import java.util.ArrayList;

import po_client.inforManagementPO.VehiclesPO;
import po_client.lineitemPO.inforManagementlineitemPO.VehicleslineitemPO;
import state.ResultMessage;

public interface VehiclesInfordataservice {
	/**
	 * 
	 * @param po
	 * @return
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的车辆信息
	 */
	public ResultMessage add(VehiclesPO po);
		
	/**
	 * 
	 * @param Id
	 * @return
	 * 前置条件：要删除的车辆信息在PO中有记录
	 * 后置条件：删除一条车辆信息
	 * 
	 */
	public ResultMessage deleteOne(String Id);
	/**
	 * 
	 * @param Ids
	 * 前置条件：要删除的车辆信息在持久化数据中有记录
	 * 后置条件：删除多条车辆信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	/**
	 * 
	 * @param Id
	 * @return
	 * 前置条件：要修改的车辆信息在PO中有记录
	 * 后置条件：修改车辆信息，并更新VO和PO
	 */
	public ResultMessage update(VehiclesPO po);
	
	/**
	 * 
	 * @param Id
	 * @return
	 * 前置条件：要查询的车辆信息在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public VehiclesPO find(String Id);
	
}
