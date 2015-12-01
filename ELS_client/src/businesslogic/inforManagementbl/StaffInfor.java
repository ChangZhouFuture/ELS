package businesslogic.inforManagementbl;

import java.util.ArrayList;
import dataservice.inforManagementdataservice.StaffInfordataservice;
import bean.JavaBean1;
import businesslogicservice.inforManagementblservice.StaffInforblservice;
import state.ResultMessage;
import vo.inforManagementVO.StaffVO;

public class StaffInfor implements StaffInforblservice{

	private StaffVO vo;
//	private StaffPO po;
	private ResultMessage rm;
	private StaffInfordataservice staffdataservice;
	@Override
	public JavaBean1 add(StaffVO vo) {
		// TODO Auto-generated method stub
//		po=new StaffPO();
//		po.setID(vo.getID());
//		po.setName(vo.getName());
//		po.setBirthDate(vo.getBirthDate());
//		po.setIdentyNum(vo.getIdentyNum());
//		po.setPhone(vo.getPhone());
//		po.setPayAmount(vo.getPayAmount());
//		po.setPercentage(vo.getPercentage());
//		po.setGender(vo.getGender());
//		po.setPosition(vo.getPosition());
//		po.setPayType(vo.getPayType());
//		return staffdataservice.add(po);
		return null;
	}

	@Override
	public JavaBean1 inquire(String Id) {
		// TODO Auto-generated method stub
//		po=staffdataservice.find(Id);
//		vo=new StaffVO();
//		vo.setID(Id);
//		vo.setName(po.getName());
//		vo.setBirthDate(po.getBirthDate());
//		vo.setIdentyNum(vo.getIdentyNum());
//		vo.setPhone(po.getPhone());
//		vo.setPayAmount(po.getPayAmount());
//		vo.setPercentage(po.getPercentage());
//		vo.setGender(po.getGender());
//		vo.setPosition(po.getPosition());
//		vo.setPayType(po.getPayType());
		return null;
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
//		po=new StaffPO();
//		po.setID(vo.getID());
//		po.setName(vo.getName());
//		po.setBirthDate(vo.getBirthDate());
//		po.setIdentyNum(vo.getIdentyNum());
//		po.setPhone(vo.getPhone());
//		po.setPayAmount(vo.getPayAmount());
//		po.setPercentage(vo.getPercentage());
//		po.setGender(vo.getGender());
//		po.setPosition(vo.getPosition());
//		po.setPayType(vo.getPayType());
//		rm=staffdataservice.update(po);
		return rm;
	}

}
