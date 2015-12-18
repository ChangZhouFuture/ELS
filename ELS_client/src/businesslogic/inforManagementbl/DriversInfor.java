package businesslogic.inforManagementbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.inforManagementdataservice.DriversInfordataservice;
import state.OperaType;
import state.ResultMessage;
import vo.inforManagementVO.DriversVO;
import vo.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.userbl.Login;
import businesslogic.utilitybl.RecordOperaLog;
import businesslogicservice.inforManagementblservice.DriversInforblservice;
import po.inforManagementPO.DriversPO;
import po.lineitemPO.inforManagementlineitemPO.DriverslineitemPO;
/**
 * 
 * @author 周畅
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
	private RecordOperaLog recordOperaLog;
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
		driversPO = new DriversPO();
		this.driversVO = driversVO;
		
		this.driversVO.setID(generateID());
		VOtoPO();
		
		try {
			resultMessage = driversInfordataservice.add(driversPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			recordOperaLog.recordOperaLog(OperaType.Add, "司机", this.driversVO.getID()
					, "营业厅业务员" + Login.id);
		}
		javaBean1.setObject(this.driversVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireA(String ID) {
		try {
			javaBean1 = driversInfordataservice.findA(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		driversPO = (DriversPO)javaBean1.getObject();
		driversVO = new DriversVO();
		
		driversVO.setID(driversPO.getID());
		driversVO.setBirthDate(driversPO.getBirthDate());
//		driversVO.setCity(driversPO.getCity());
		driversVO.setDriveLimitDate(driversPO.getDriveLimitDate());
		driversVO.setGender(driversPO.getGender());
		driversVO.setIdentyNum(driversPO.getIdentyNum());
		driversVO.setName(driversPO.getName());
		driversVO.setPhone(driversPO.getPhone());
//		driversVO.setRegion(driversPO.getRegion());
		
		javaBean1.setObject(driversVO);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String busiHallID) {
		try {
			javaBean1 = driversInfordataservice.findB(busiHallID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<DriverslineitemPO>)javaBean1.getObject();
		arrayList2 = new ArrayList<DriverslineitemVO>();
		int k = arrayList.size();
		
		for (int i = 0; i < k; i++) {
			driverslineitemPO = arrayList.get(i);
			
			driverslineitemVO = new DriverslineitemVO();
			driverslineitemVO.setID(driverslineitemPO.getID());
			driverslineitemVO.setName(driverslineitemPO.getName());
			driverslineitemVO.setPhone(driverslineitemPO.getPhone());
			driverslineitemVO.setGender(driverslineitemPO.getGender());
			driverslineitemVO.setDriveLimitDate(driverslineitemPO.getDriveLimitDate());
			
			arrayList2.add(driverslineitemVO);
		}
		
		javaBean1.setObject(arrayList2);
		return null;
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		try {
			resultMessage = driversInfordataservice.deleteMany(IDList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			String driverID;
			for (int i = 0; i < IDList.size(); i++) {
				driverID = IDList.get(i);
				recordOperaLog.recordOperaLog(OperaType.Delete, "司机", this.driversVO.
					getID(), "营业厅业务员" + Login.id);
			}
		}
		return resultMessage;
	}

	@Override
	public ResultMessage modify(DriversVO driversVO) {
		driversPO = new DriversPO();
		this.driversVO = driversVO;
		
		VOtoPO();
		try {
			resultMessage = driversInfordataservice.update(driversPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	public String generateID() {
		//城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
		//直接截取营业厅编号大部分，后面三位需要数据层生成
		return null;
	}

	public void VOtoPO() {
		driversPO.setID(driversVO.getID());
//		driversPO.setCity(driversVO.getCity());
		driversPO.setBirthDate(driversVO.getBirthDate());
		driversPO.setDriveLimitDate(driversVO.getDriveLimitDate());
		driversPO.setGender(driversVO.getGender());
		driversPO.setIdentyNum(driversVO.getIdentyNum());
		driversPO.setName(driversVO.getName());
		driversPO.setPhone(driversVO.getPhone());
//		driversPO.setRegion(driversVO.getRegion());
	}
	
}
