package businesslogic.inforManagementbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.inforManagementdataservice.AgencyInfordataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.userbl.Login;
import businesslogic.utilitybl.RecordOperaLog;
import businesslogicservice.inforManagementblservice.AgencyInforblservice;
import po.inforManagementPO.AgencyPO;
import state.AgencyType;
import state.OperaType;
import state.ResultMessage;
import vo.inforManagementVO.AgencyVO;

public class AgencyInfor implements AgencyInforblservice{
	private AgencyInfordataservice agencyInfordataservice;
	private AgencyPO agencyPO;
	private AgencyVO agencyVO;
	private ArrayList<AgencyPO> arrayList;
	private ArrayList<AgencyVO> arrayList2;
	private RecordOperaLog recordOperaLog;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	
	public AgencyInfor() {
		try {
			agencyInfordataservice = RMIHelper.getAgencyInfordataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 add(AgencyVO agencyVO) {
		agencyPO = new AgencyPO();
		this.agencyVO = agencyVO;
		
		this.agencyVO.setID(generateID());
		VOtoPO();
		
		try {
			resultMessage = agencyInfordataservice.add(agencyPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			recordOperaLog.recordOperaLog(OperaType.Add, this.agencyVO.getAgencyType().
					toString(), this.agencyVO.getID(), "总经理" + Login.id);
		}
		javaBean1.setObject(this.agencyVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		try {
			resultMessage = agencyInfordataservice.deleteMany(IDList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			String agencyID;
			for (int i = 0; i < IDList.size(); i++) {
				agencyID = IDList.get(i);
				recordOperaLog.recordOperaLog(OperaType.Delete, this.agencyVO.
				getAgencyType().toString(), agencyID, "总经理" + Login.id);
			}
		}
		return resultMessage;
	}

	@Override
	public ResultMessage modify(AgencyVO agencyVO) {
		agencyPO = new AgencyPO();
		this.agencyVO = agencyVO;
		VOtoPO();
		
		try {
			resultMessage = agencyInfordataservice.update(agencyPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public JavaBean1 inquire(String ID) {
		try {
			javaBean1 = agencyInfordataservice.find(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		agencyPO = (AgencyPO)javaBean1.getObject();
		agencyVO = new AgencyVO();
		
		if (javaBean1.getResultMessage() == ResultMessage.NotExist) {
			return javaBean1;
		}
		
		agencyVO.setAgencyType(agencyPO.getAgencyType());
		agencyVO.setCity(agencyPO.getCity());
		agencyVO.setID(agencyPO.getID());
		agencyVO.setRegion(agencyPO.getRegion());
		
		javaBean1.setObject(this.agencyVO);
		return javaBean1;
	}

	public String generateID() {
		String id = null;
		
		switch (agencyVO.getCity()) {
		case "北京":
			id += "010";
			break;
		case "上海":
			id += "021";
			break;
		case "广州":
			id += "020";
			break;
		case "南京":
			id += "025";
			break;
		default:
			break;
		}
		
		if (agencyVO.getAgencyType()==AgencyType.BusinessHall) {
			id += "1";
		} else {
			id += "0";
		}
		
		try {
			id = agencyInfordataservice.generateID(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return id;
	}

	public void VOtoPO() {
		agencyPO.setID(agencyVO.getID());
		agencyPO.setAgencyType(agencyVO.getAgencyType());
		agencyPO.setCity(agencyVO.getCity());
		agencyPO.setRegion(agencyVO.getRegion());
		
	}

	@Override
	public JavaBean1 inquireB(AgencyType agencyType) {
		try {
			javaBean1 = agencyInfordataservice.findB(agencyType);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<AgencyPO>)javaBean1.getObject();
		int k =arrayList.size();
		
		for (int i = 0; i < k; i++) {
			agencyPO = arrayList.get(i);
			
			agencyVO = new AgencyVO();
			agencyVO.setAgencyType(agencyPO.getAgencyType());
			agencyVO.setCity(agencyPO.getCity());
			agencyVO.setID(agencyPO.getID());
			agencyVO.setRegion(agencyPO.getRegion());
			
			arrayList2.add(agencyVO);
		}
		javaBean1.setObject(arrayList2);
		
		return javaBean1;
	}
	
}
