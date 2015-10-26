package businesslogic_client.informngmtbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.informngmtVO.VehiclesVO;
import vo_client.lineitemVO.informngmtlineitemVO.VehicleslineitemVO;
import businesslogicservice_client.informngmtblservice.VehiclesInforblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class VehiclesInfor implements VehiclesInforblservice {

	@Override
	public VehiclesVO add(String vehiclesId, String engineNum,
			String vehiclesNum, String chassisNum, String dateOfBuy,
			String activeTime, String vehiclesImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOne(String vehiclesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4Vehicles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehiclesVO modify(String vehiclesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleslineitemVO inquire(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
