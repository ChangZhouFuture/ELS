package businesslogic.inforManagementbl;

import java.rmi.RemoteException;
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
 * @author 周畅
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
		vehiclesPO = new VehiclesPO();
		this.vehiclesVO = vehiclesVO;
		
		this.vehiclesVO.setID(generateID());
		VOtoPO();
		
		try {
			resultMessage = vehiclesInfordataservice.add(vehiclesPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.vehiclesVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		try {
			resultMessage = vehiclesInfordataservice.deleteMany(IDList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public ResultMessage modify(VehiclesVO vehiclesVO) {
		vehiclesPO = new VehiclesPO();
		this.vehiclesVO = vehiclesVO;
		
		VOtoPO();
		try {
			resultMessage = vehiclesInfordataservice.update(vehiclesPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String ID) {
		try {
			javaBean1 = vehiclesInfordataservice.findA(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<VehiclesPO>)javaBean1.getObject();
		
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String busiHallID) {
		try {
			javaBean1 = vehiclesInfordataservice.findB();//数据层要改
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<VehiclesPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	public String generateID() {
		//车辆代号（城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
		//直接截取营业厅编号大部分，后面三位需要数据层生成
		
		return null;
	}
	
	public void VOtoPO() {
		vehiclesPO.setID(vehiclesVO.getID());
		vehiclesPO.setPlateNum(vehiclesVO.getPlateNum());
		vehiclesPO.setServiceTime(vehiclesVO.getServiceTime());
		vehiclesPO.setBusiHallID(vehiclesVO.getBusiHallID());
	}
	
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<VehiclesVO>();
		
		for (int i = 0; i < k; i++) {
			vehiclesPO = arrayList.get(i);
			
			vehiclesVO = new VehiclesVO();
			vehiclesVO.setID(vehiclesPO.getID());
			vehiclesVO.setPlateNum(vehiclesPO.getPlateNum());
			vehiclesVO.setBusiHallID(vehiclesPO.getBusiHallID());
			vehiclesVO.setServiceTime(vehiclesPO.getServiceTime());
			
			arrayList2.add(vehiclesVO);
		}
	}
	
}
