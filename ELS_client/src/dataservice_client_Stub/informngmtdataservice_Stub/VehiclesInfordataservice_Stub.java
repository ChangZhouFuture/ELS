package dataservice_client_Stub.informngmtdataservice_Stub;

import java.util.ArrayList;

import po_client.informngmtPO.VehiclesPO;
import po_client.lineitemPO.informngmtlineitemPO.VehicleslineitemPO;
import state.ResultMessage;
import dataservice_client.informngmtdataservice.VehiclesInfordataservice;

public class VehiclesInfordataservice_Stub implements VehiclesInfordataservice{
	String vehiclesId;
	String engineNum;
	String vehiclesNum;
	String chassisNum;
	String dateOfBuy;
	String activeTime;
	String vehiclesImage;
	@Override
	public VehiclesPO add(String vehiclesId, String engineNum,
			String vehiclesNum, String chassisNum, String dateOfBuy,
			String activeTime, String vehiclesImage) {
		// TODO Auto-generated method stub
		this.vehiclesId = vehiclesId;
		this.engineNum = engineNum;
		this.chassisNum = chassisNum;
		this.vehiclesNum = vehiclesNum;
		this.dateOfBuy = dateOfBuy;
		this.activeTime = activeTime;
		this.vehiclesImage = vehiclesImage;
		return null;
	}

	@Override
	public ResultMessage deleteOne(String vehiclesId) {
		// TODO Auto-generated method stub
		System.out.println("成功删除一条车辆信息");
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4Vehicles) {
		// TODO Auto-generated method stub
		System.out.println("成功删除多条车辆信息信息");
		return null;
	}

	@Override
	public VehiclesPO modify(String vehiclesId) {
		// TODO Auto-generated method stub
		System.out.println("修改成功");
		return null;
	}

	@Override
	public VehicleslineitemPO inquire(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("已经更新了PO相关信息");
	}

}
