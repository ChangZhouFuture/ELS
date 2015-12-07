package businesslogic.inforManagementbl;

import java.util.ArrayList;

import dataservice.inforManagementdataservice.VehiclesInfordataservice;
import state.ResultMessage;
import vo.inforManagementVO.VehiclesVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.inforManagementblservice.VehiclesInforblservice;
import po.inforManagementPO.VehiclesPO;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class VehiclesInfor implements VehiclesInforblservice {
	private VehiclesInfordataservice vehiclesInfordataservice;
	private VehiclesPO vehiclesPO;
	private VehiclesVO vehiclesVO;
	private ArrayList<VehiclesPO> arrayList;
	private ArrayList<VehiclesVO> arrayList2;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	
	public VehiclesInfor() {
		try {
			vehiclesInfordataservice = RMIHelper.getVehiclesInfordataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 add(VehiclesVO vehiclesVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(VehiclesVO vehiclesVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireA(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireB(String city, String region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateID() {
		// TODO Auto-generated method stub
		return null;
	}

}
