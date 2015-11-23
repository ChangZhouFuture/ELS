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
		switch(vo.getGender()){
		case MALE:
			po.setGender(1);
			break;
		case FEMALE:
			po.setGender(2);
			break;
		}
		switch(vo.getPosition()){
		case COURIER:
			po.setPosition(1);break;
		case BUSINESSSALESMAN:
		    po.setPosition(2);break;
		case CHANGESALESMAN:
			po.setPosition(3);break;
		case MANAGER:
			po.setPosition(4);break;
		case FINANCIALSTUFF:
			po.setPosition(5);break;

		}
		switch(vo.getPayType()){
		case BYMONTH:
			po.setPayType(1);break;
		case BYDAY:
			po.setPayType(2);break;
		}
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
		switch(po.getGender()){
		case 1:vo.setGender(Gender.MALE);break;
		case 2:vo.setGender(Gender.FEMALE);break;
		}
		switch(po.getPosition()){
		case 1:vo.setPosition(Position.COURIER);break;
		case 2:vo.setPosition(Position.BUSINESSSALESMAN);break;
		case 3:vo.setPosition(Position.CHANGESALESMAN);break;
		case 4:vo.setPosition(Position.MANAGER);break;
		case 5:vo.setPosition(Position.FINANCIALSTUFF);break;
		}
		switch(po.getPayType()){
		case 1:vo.setPayType(PayType.BYMONTH);break;
		case 2:vo.setPayType(PayType.BYDAY);break;
		}
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
		switch(vo.getGender()){
		case MALE:
			po.setGender(1);break;
		case FEMALE:
			po.setGender(2);break;
		}
		switch(vo.getPosition()){
		case COURIER:
			po.setPosition(1);break;
		case BUSINESSSALESMAN:
		    po.setPosition(2);break;
		case CHANGESALESMAN:
			po.setPosition(3);break;
		case MANAGER:
			po.setPosition(4);break;
		case FINANCIALSTUFF:
			po.setPosition(5);break;

		}
		switch(vo.getPayType()){
		case BYMONTH:
			po.setPayType(1);break;
		case BYDAY:
			po.setPayType(2);break;
		}
		rm=staffdataservice.update(po);
		return rm;
	}

}
