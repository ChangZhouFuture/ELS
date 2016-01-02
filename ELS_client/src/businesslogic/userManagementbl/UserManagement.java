package businesslogic.userManagementbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userManagementdataservice.UserManagementdataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.utilitybl.RecordOperaLog;
import businesslogicservice.userManagementblservice.UserManagementblservice;
import po.lineitemPO.userlineitemPO.UserlineitemPO;
import po.userPO.UserPO;
import state.OperaType;
import state.Position;
import state.ResultMessage;
import vo.lineitemVO.userlineitemVO.UserlineitemVO;
import vo.userVO.UserVO;

public class UserManagement implements UserManagementblservice{
	private UserManagementdataservice userManagementdataservice;
	private UserPO userPO;
	private UserVO userVO;
	private UserlineitemPO userlineitemPO;
	private UserlineitemVO userlineitemVO;
	private ArrayList<UserlineitemPO> arrayList;
	private ArrayList<UserlineitemVO> arrayList2;
	private RecordOperaLog recordOperaLog;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	
	
	public UserManagement() {
		try {
			userManagementdataservice = RMIHelper.getUserManagementdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 add(UserVO userVO) {
		userPO = new UserPO();
		this.userVO = userVO;
		
		this.userVO.setId(generateID(userVO.getPosition()));
		this.userVO.setPassword(userVO.getId());
		//调用工资管理的类的方法，根据职位生成默认工资支付方式
		//上面一行说的不需要了
		VOtoPO();
		
		try {
			resultMessage = userManagementdataservice.add(userPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			recordOperaLog.recordOperaLog(OperaType.Add, this.userVO.getPosition().
					toString(), this.userVO.getId(), "管理员");
		}
		javaBean1 = new JavaBean1();
		javaBean1.setObject(this.userVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		try {
			resultMessage = userManagementdataservice.deleteMany(IDList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			String id;
			for (int i = 0; i < IDList.size(); i++) {
				id = IDList.get(i);
				recordOperaLog.recordOperaLog(OperaType.Delete, this.userVO.
						getPosition().toString(), id, "管理员");
			}
		}
		return resultMessage;
	}

	@Override
	public ResultMessage modify(UserVO userVO) {
		userPO = new UserPO();
		this.userVO = userVO;
		
		VOtoPO();
		try {
			resultMessage = userManagementdataservice.update(userPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String Id) {
		try {
			javaBean1 = userManagementdataservice.findA(Id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		userPO = (UserPO)javaBean1.getObject();
		userVO = new UserVO();
		
		userVO.setId(userPO.getId());
		userVO.setAgencyID(userPO.getAgencyID());
		userVO.setBirthDate(userPO.getBirthDate());
		userVO.setCity(userPO.getCity());
		userVO.setGender(userPO.getGender());
		userVO.setIdentyNum(userPO.getIdentyNum());
		userVO.setName(userPO.getName());
		userVO.setPassword(userPO.getPassword());
		userVO.setPhone(userPO.getPhone());
		userVO.setPosition(userPO.getPosition());
		userVO.setRegion(userPO.getRegion());
		
		javaBean1.setObject(userVO);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(Position position) {
		try {
			javaBean1 = userManagementdataservice.findB(position);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<UserlineitemPO>)javaBean1.getObject();
		arrayList2 = new ArrayList<UserlineitemVO>();
		int k = arrayList.size();
		
		for (int i = 0; i < k; i++) {
			userlineitemPO = arrayList.get(i);
			
			userlineitemVO = new UserlineitemVO();
			userlineitemVO.setId(userlineitemPO.getId());
			userlineitemVO.setCity(userlineitemPO.getCity());
			userlineitemVO.setGender(userlineitemPO.getGender());
			userlineitemVO.setName(userlineitemPO.getName());
			userlineitemVO.setPhone(userlineitemPO.getPhone());
			userlineitemVO.setPosition(userlineitemPO.getPosition());
			userlineitemVO.setRegion(userlineitemPO.getRegion());
			
			arrayList2.add(userlineitemVO);
		}
		
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	public String generateID(Position position) {
		//调用数据层方法
		String id = null;
		
		try {
			id = userManagementdataservice.generateID(position);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return id;
	}
    
	public void VOtoPO() {
		userPO.setId(userVO.getId());
		userPO.setAgencyID(userVO.getAgencyID());
		userPO.setBirthDate(userVO.getBirthDate());
		userPO.setCity(userVO.getCity());
		userPO.setGender(userVO.getGender());
		userPO.setIdentyNum(userVO.getIdentyNum());
		userPO.setName(userVO.getName());
		userPO.setPassword(userVO.getPassword());
		userPO.setPhone(userVO.getPhone());
		userPO.setPosition(userVO.getPosition());
		userPO.setRegion(userVO.getRegion());
	}
	
}
