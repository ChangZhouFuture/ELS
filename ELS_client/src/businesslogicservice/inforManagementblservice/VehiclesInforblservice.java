package businesslogicservice.inforManagementblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.inforManagementVO.VehiclesVO;

public interface VehiclesInforblservice {
	/**
	 * 
	 * @param vo
	 * @return
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的车辆信息
	 */
	public JavaBean1 add(VehiclesVO vehiclesVO);

	/**
	 * 
	 * @param id4Vehicles
	 * 前置条件：要删除的车辆信息在持久化数据中有记录
	 * 后置条件：删除多条车辆信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> IDList);
	
	/**
	 * 
	 * @param Id
	 * @return
	 * 前置条件：要修改的车辆信息在PO中有记录
	 * 后置条件：修改车辆信息，并更新VO和PO
	 */
	public ResultMessage modify(VehiclesVO vehiclesVO);
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public JavaBean1 inquireA(String ID);
	
	public JavaBean1 inquireB(String busiHallID);
	
}
