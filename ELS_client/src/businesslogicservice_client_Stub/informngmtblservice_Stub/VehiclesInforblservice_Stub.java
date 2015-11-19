package businesslogicservice_client_Stub.informngmtblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.inforManagementVO.VehiclesVO;
import vo_client.lineitemVO.inforManagementlineitemVO.VehicleslineitemVO;
import vo_client.orderVO.OrderVO;
import businesslogicservice_client.inforManagementblservice.VehiclesInforblservice;

public class VehiclesInforblservice_Stub implements VehiclesInforblservice{
	VehiclesVO VehiclesVO;
	VehicleslineitemVO VehicleslineitemVO;
	OrderVO oVO;
	String vehiclesId;
	String engineNum;
	String vehiclesNum;
	String chassisNum;
	String dateOfBuy;
	String activeTime;
	String vehiclesImage;
	@Override
	public VehiclesVO add(String vehiclesId, String engineNum,
			String vehiclesNum, String chassisNum, String dateOfBuy,
			String activeTime, String vehiclesImage) {
		// TODO Auto-generated method stub
		end();
		return VehiclesVO;
	}

	@Override
	public ResultMessage deleteOne(String vehiclesId) {
		// TODO Auto-generated method stub
		end();
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4Vehicles) {
		// TODO Auto-generated method stub
		end();
		return null;
	}

	@Override
	public VehiclesVO modify(String vehiclesId) {
		// TODO Auto-generated method stub
		end();
		return null;
	}

	@Override
	public VehicleslineitemVO inquire(String keyword) {
		// TODO Auto-generated method stub
		System.out.println("找到相关记录x条");
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
