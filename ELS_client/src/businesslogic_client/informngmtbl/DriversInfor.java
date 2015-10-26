package businesslogic_client.informngmtbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.informngmtVO.DriversVO;
import vo_client.lineitemVO.informngmtlineitemVO.DriverslineitemVO;
import businesslogicservice_client.informngmtblservice.DriversInforblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class DriversInfor implements DriversInforblservice {

	@Override
	public DriversVO add(String driverId, String driverName,
			String driverDob, String driverIdNum, String driverCPN,
			String VehicleUnit, String driverSex, String driverDLP) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DriversVO modify(String driverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverslineitemVO inquire(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
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
	
}
