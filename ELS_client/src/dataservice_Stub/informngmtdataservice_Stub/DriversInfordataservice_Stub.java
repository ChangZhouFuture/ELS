package dataservice_Stub.informngmtdataservice_Stub;

import java.util.ArrayList;

import dataservice.inforManagementdataservice.DriversInfordataservice;
import po.inforManagementPO.DriversPO;
import po.lineitemPO.inforManagementlineitemPO.DriverslineitemPO;
import state.ResultMessage;

public class DriversInfordataservice_Stub implements DriversInfordataservice{
	
	
	@Override
	public ResultMessage add(DriversPO driversPO) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	public DriverslineitemPO inquire(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOne(String driverId) {
		// TODO Auto-generated method stub
		System.out.println("成功删除一条司机信息");
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4Driver) {
		// TODO Auto-generated method stub
		System.out.println("成功删除多条司机信息");
		return null;
	}


	@Override
	public DriversPO find(String Id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage update(DriversPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
