package dataservice_client.inforManagementdataservice;

import java.util.ArrayList;

import po_client.inforManagementPO.DriversPO;
import state.ResultMessage;

public interface DriversInfordataservice {
	/**
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的司机信息
	 * @param po
	 * @return
	 */
	public ResultMessage add(DriversPO po);
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public DriversPO find(String Id);
	
	/**
	 * 
	 * @param ID
	 * @return
	 * 前置条件：要删除的司机信息在PO中有记录
	 * 后置条件：删除一条信息信息
	 * 
	 */
	public ResultMessage deleteOne(String Id);
	
	/**
	 * 
	 * @param IDs
	 * 前置条件：要删除的司机信息在持久化数据中有记录
	 * 后置条件：删除多条司机信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	/**
	 * 
	 * @param po
	 * @return
	 * 前置条件：要修改的司机信息在PO中有记录
	 * 后置条件：修改司机信息，并更新VO和PO
	 */
	public ResultMessage update(DriversPO po);
	
}
