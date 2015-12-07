package businesslogic.userManagementbl;

import java.util.ArrayList;

import dataservice.userManagementdataservice.UserManagementdataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.userManagementblservice.UserManagementblservice;
import po.lineitemPO.userlineitemPO.UserlineitemPO;
import po.userPO.UserPO;
import state.ResultMessage;
import vo.userVO.UserVO;

public class UserManagement implements UserManagementblservice{
	private UserManagementdataservice userManagementdataservice;
	private UserPO userPO;
	private UserVO userVO;
	private UserlineitemPO userlineitemPO;
//	private UserlineitemVO user
	private ArrayList<UserlineitemPO> arrayList;
//	private
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
	public ResultMessage modify(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireA(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireB(String position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateID() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
