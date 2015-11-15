package businesslogicservice_client_Stub.informngmtblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.informngmtVO.DriversVO;
import vo_client.lineitemVO.informngmtlineitemVO.DriverslineitemVO;
import vo_client.orderVO.OrderVO;
import businesslogicservice_client.informngmtblservice.DriversInforblservice;

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
	public DriversVO add(String driverId, String driverName,
			String driverDob, String driverIdNum, String driverCPN,
			String VehicleUnit, String driverSex, String driverDLP) {
		// TODO Auto-generated method stub
		end();
		return driversVO;
	}
	@Override
	public ResultMessage deleteOne(String driverId) {
		// TODO Auto-generated method stub
		end();
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4Driver) {
		// TODO Auto-generated method stub
		end();
		return null;
	}
	@Override
	public DriversVO modify(String driverId) {
		// TODO Auto-generated method stub
		end();
		return null;
	}

	@Override
	public DriverslineitemVO inquire(String keyword) {
		// TODO Auto-generated method stub
		System.out.println("找到相关记录x条");
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
		//调用数据层的update方法
	}

}
