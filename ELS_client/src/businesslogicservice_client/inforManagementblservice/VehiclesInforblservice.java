package businesslogicservice_client.inforManagementblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.inforManagementVO.VehiclesVO;

public interface VehiclesInforblservice {
	/**
	 * 
	 * @param vo
	 * @return
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的车辆信息
	 */
	public ResultMessage add(VehiclesVO vo);
		
	/**
	 * 
	 * @param id
	 * @return
	 * 前置条件：要删除的车辆信息在PO中有记录
	 * 后置条件：删除一条车辆信息
	 * 
	 */
	public ResultMessage deleteOne(String Id);
	/**
	 * 
	 * @param id4Vehicles
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
	public ResultMessage modify(VehiclesVO vo);
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public VehiclesVO inquire(String Id);
}
