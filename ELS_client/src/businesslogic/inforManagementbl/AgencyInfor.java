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
	public ResultMessage deleteOne(String ID) {
		// TODO Auto-generated method stub
		return null;
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
		
		return null;
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
			id += agencyInfordataservice.generateID();
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
//		resultMessage = agencyInfordataservice.
		return null;
	}
	
}
