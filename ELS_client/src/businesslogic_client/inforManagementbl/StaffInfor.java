package businesslogic_client.inforManagementbl;

import java.util.ArrayList;

import businesslogicservice_client.inforManagementblservice.StaffInforblservice;
import dataservice_client.inforManagementdataservice.StaffInfordataservice;
import po_client.inforManagementPO.StaffPO;
import po_client.lineitemPO.inforManagementlineitemPO.StafflineitemPO;
import state.Gender;
import state.PayType;
import state.Position;
import state.ResultMessage;
import vo_client.inforManagementVO.StaffVO;

public class StaffInfor implements StaffInforblservice{

	private StaffVO vo;
	private StaffPO po;
	private ResultMessage rm;
	private StaffInfordataservice staffdataservice;
	@Override
	public ResultMessage add(StaffVO vo) {
		// TODO Auto-generated method stub
		po=new StaffPO();
		po.setID(vo.getID());
		po.setName(vo.getName());
		po.setBirthDate(vo.getBirthDate());
		po.setIdentyNum(vo.getIdentyNum());
		po.setPhone(vo.getPhone());
		po.setPayAmount(vo.getPayAmount());
		po.setPercentage(vo.getPercentage());
		po.setGender(vo.getGender());
		po.setPosition(vo.getPosition());
		po.setPayType(vo.getPayType());
		return staffdataservice.add(po);
	}

	@Override
	public StaffVO inquire(String Id) {
		// TODO Auto-generated method stub
		po=staffdataservice.find(Id);
		vo=new StaffVO();
		vo.setID(Id);
		vo.setName(po.getName());
		vo.setBirthDate(po.getBirthDate());
		vo.setIdentyNum(vo.getIdentyNum());
		vo.setPhone(po.getPhone());
		vo.setPayAmount(po.getPayAmount());
		vo.setPercentage(po.getPercentage());
		vo.setGender(po.getGender());
		vo.setPosition(po.getPosition());
		vo.setPayType(po.getPayType());
		return vo;
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		rm=staffdataservice.deleteOne(Id);
		return rm;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		rm=staffdataservice.deleteMany(Ids);
		return rm;
	}

	@Override
	public ResultMessage modify(StaffVO vo) {
		// TODO Auto-generated method stub
		po=new StaffPO();
		po.setID(vo.getID());
		po.setName(vo.getName());
		po.setBirthDate(vo.getBirthDate());
		po.setIdentyNum(vo.getIdentyNum());
		po.setPhone(vo.getPhone());
		po.setPayAmount(vo.getPayAmount());
		po.setPercentage(vo.getPercentage());
		po.setGender(vo.getGender());
		po.setPosition(vo.getPosition());
		po.setPayType(vo.getPayType());
		rm=staffdataservice.update(po);
		return rm;
	}

}
