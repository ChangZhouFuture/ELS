package dataservice_client_Stub.informngmtdataservice_Stub;

import java.util.ArrayList;

import po_client.informngmtPO.DriversPO;
import po_client.lineitemPO.informngmtlineitemPO.DriverslineitemPO;
import state.ResultMessage;
import dataservice_client.informngmtdataservice.DriversInfordataservice;

public class DriversInfordataservice_Stub implements DriversInfordataservice{
	String driverID;
	String driverName;
	String driverDob;
	String driverIdNum;
	String driverCPN;
	String VehicleUnit;
	String driverSex;
	String driverDLP;
	@Override
	public DriversPO add(String driverId, String driverName, String driverDob,
			String driverIdNum, String driverCPN, String VehicleUnit,
			String driverSex, String driverDLP) {
		// TODO Auto-generated method stub
		this.driverID = driverId;
		this.driverName = driverName;
		this.driverDob = driverDob;
		this.driverIdNum = driverIdNum;
		this.driverCPN = driverCPN;
		this.VehicleUnit = VehicleUnit;
		this.driverSex = driverSex;
		this.driverDLP = driverDLP;
		return null;
	}

	@Override
	public DriversPO modify(String driverId) {
		// TODO Auto-generated method stub
		System.out.println("�޸ĳɹ�");
		return null;
	}

	@Override
	public DriverslineitemPO inquire(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("�Ѿ�������PO�����Ϣ");
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

}
