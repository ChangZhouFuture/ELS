package businesslogic_client.userManagementbl;

import java.util.ArrayList;

import businesslogicservice_client.userManagementblservice.UserManagementblservice;
import dataservice_client.userManagementdataservice.UserManagementdataservice;
import po_client.userPO.UserPO;
import state.ResultMessage;
import vo_client.userVO.UserVO;

public class UserManagement implements UserManagementblservice{
    private UserPO po;
    private UserVO vo;
    private ResultMessage rm;
    private UserManagementdataservice usermanagementdataservice;
	@Override
	public ResultMessage add(UserVO vo) {
		// TODO Auto-generated method stub
		po=new UserPO();
		po.setId(vo.getId());
		po.setPassword(vo.getPassword());
		rm=usermanagementdataservice.add(po);
		return rm;
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		rm=usermanagementdataservice.deleteOne(Id);
		return rm;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		rm=usermanagementdataservice.deleteMany(Ids);
		return rm;
	}

	@Override
	public ResultMessage modify(UserVO vo) {
		// TODO Auto-generated method stub
		po=new UserPO();
		po.setId(vo.getId());
		po.setPassword(vo.getPassword());
		rm=usermanagementdataservice.update(po);
		return rm;
	}

	@Override
	public UserVO inquire(String Id) {
		// TODO Auto-generated method stub
		po=usermanagementdataservice.find(Id);
		vo=new UserVO();
		vo.setId(po.getId());
		vo.setPassword(po.getPassword());
		return vo;
	}



}
