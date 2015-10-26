package businesslogicservice_client.informngmtblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.informngmtVO.VehiclesVO;
import vo_client.lineitemVO.informngmtlineitemVO.VehicleslineitemVO;

public interface VehiclesInforblservice {
	/**
	 * 
	 * @param vehiclesId
	 * @param engineNum
	 * @param vehiclesNum
	 * @param chassisNum
	 * @param dateOfBuy
	 * @param activeTime
	 * @param vehiclesImage
	 * @return
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的车辆信息
	 */
	public VehiclesVO add(String vehiclesId, String engineNum, String vehiclesNum, String chassisNum,String dateOfBuy,String activeTime,String vehiclesImage);
		
	/**
	 * 
	 * @param id
	 * @return
	 * 前置条件：要删除的车辆信息在PO中有记录
	 * 后置条件：删除一条车辆信息
	 * 
	 */
	public ResultMessage deleteOne(String vehiclesId);
	/**
	 * 
	 * @param id4Vehicles
	 * 前置条件：要删除的车辆信息在持久化数据中有记录
	 * 后置条件：删除多条车辆信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4Vehicles);
	
	/**
	 * 
	 * @param vehiclesId
	 * @return
	 * 前置条件：要修改的车辆信息在PO中有记录
	 * 后置条件：修改车辆信息，并更新VO和PO
	 */
	public VehiclesVO modify(String vehiclesId);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * 前置条件：要查询的车辆信息在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public VehicleslineitemVO inquire(String keyword);
	
	/**
	 * 前置条件：车辆信息处理完成
	 * 后置条件：结束本次车辆信息处理，更新数据持久化对象
	 */
	public void end();
}
