package dataservice_client_Stub.informngmtdataservice_Stub;

import java.util.ArrayList;

import po_client.inforManagementPO.DriversPO;
import po_client.lineitemPO.inforManagementlineitemPO.DriverslineitemPO;
import state.ResultMessage;
import dataservice_client.inforManagementdataservice.DriversInfordataservice;

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
		System.out.println("�ɹ�ɾ��һ��˾����Ϣ");
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4Driver) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ�ɾ������˾����Ϣ");
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
