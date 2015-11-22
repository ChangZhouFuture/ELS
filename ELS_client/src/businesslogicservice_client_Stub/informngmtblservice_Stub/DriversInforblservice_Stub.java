package businesslogicservice_client_Stub.informngmtblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.inforManagementVO.DriversVO;
import vo_client.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;
import vo_client.orderVO.OrderVO;
import businesslogicservice_client.inforManagementblservice.DriversInforblservice;

public class DriversInforblservice_Stub implements DriversInforblservice{
	DriversVO driversVO;
	DriverslineitemVO driverslineitemVO;
	OrderVO oVO;
	String driverID;
	String driverName;
	String driverDob;
	String driverIdNum;
	String driverCPN;
	String VehicleUnit;
	String driverSex;
	String driverDLP;
	@Override
	public ResultMessage add(DriversVO driversVO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage deleteOne(String driverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4Driver) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage modify(DriversVO driversVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriversVO inquire(String keyword) {
		// TODO Auto-generated method stub
		System.out.println("找到相关记录x条");
		return null;
	}

}
