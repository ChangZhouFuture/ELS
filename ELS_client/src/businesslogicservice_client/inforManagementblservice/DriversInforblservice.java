package businesslogicservice_client.inforManagementblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.inforManagementVO.DriversVO;
import vo_client.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;

public interface DriversInforblservice {
	/**
	 * 
	 * @param driverId
	 * @param driverName
	 * @param driverDob
	 * @param driverIdNum
	 * @param driverCPN
	 * @param VehicleUnit
	 * @param driverSex
	 * @param driverDLP
	 * @return
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的司机信息
	 */
	public DriversVO add(String driverId, String driverName, String driverDob, String driverIdNum,String driverCPN,String VehicleUnit,String driverSex,String driverDLP);
		
	/**
	 * 
	 * @param id
	 * @return
	 * 前置条件：要删除的司机信息在PO中有记录
	 * 后置条件：删除一条司机信息
	 * 
	 */
	public ResultMessage deleteOne(String driverId);

	/**
	 * 
	 * @param id4Driver
	 * 前置条件：要删除的司机信息在持久化数据中有记录
	 * 后置条件：删除多条司机信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4Driver);
	
	/**
	 * 
	 * @param driverId
	 * @return
	 * 前置条件：要修改的司机信息在PO中有记录
	 * 后置条件：修改司机信息，并更新VO和PO
	 */
	public DriversVO modify(String driverId);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * 前置条件：要查询的司机信息在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public DriverslineitemVO inquire(String keyword);
	
	/**
	 * 前置条件：司机信息处理完成
	 * 后置条件：结束这次司机信息处理，更新数据持久化对象
	 */
	public void end();
}
