package businesslogic.inforManagementbl;

import java.util.ArrayList;

import dataservice.inforManagementdataservice.DriversInfordataservice;
import state.ResultMessage;
import vo.inforManagementVO.DriversVO;
import vo.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.inforManagementblservice.DriversInforblservice;
import po.inforManagementPO.DriversPO;
import po.lineitemPO.inforManagementlineitemPO.DriverslineitemPO;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class DriversInfor implements DriversInforblservice {
	private DriversInfordataservice driversInfordataservice;
	private DriversPO driversPO;
	private DriversVO driversVO;
	private DriverslineitemVO driverslineitemVO;
	private DriverslineitemPO driverslineitemPO;
	private ArrayList<DriverslineitemPO> arrayList;
	private ArrayList<DriverslineitemVO> arrayList2;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	
	public DriversInfor() {
		try {
			driversInfordataservice = RMIHelper.getDriversInfordataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 add(DriversVO driversVO) {
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
	public ResultMessage modify(DriversVO driversVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateID() {
		// TODO Auto-generated method stub
		return null;
	}

}
