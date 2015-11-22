package businesslogic_client.inforManagementbl;

import java.util.ArrayList;

import state.Gender;
import state.ResultMessage;
import vo_client.inforManagementVO.DriversVO;
import vo_client.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;
import businesslogicservice_client.inforManagementblservice.DriversInforblservice;
import dataservice_client.inforManagementdataservice.DriversInfordataservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class DriversInfor implements DriversInforblservice {

	private DriversVO driversvo;
	private DriverslineitemVO driversllvo; 
	private ResultMessage rm;
	private DriversInfordataservice driversdataservice;
	@Override
	public ResultMessage add(DriversVO vo) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		rm=driversdataservice.deleteOne(Id);
		return rm;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		rm=driversdataservice.deleteMany(Ids);
		return null;
	}


	@Override
	public ResultMessage modify(DriversVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriversVO inquire(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
