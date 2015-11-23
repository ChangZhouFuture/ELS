package businesslogic_client.inforManagementbl;

import java.util.ArrayList;

import businesslogicservice_client.inforManagementblservice.AgencyInforblservice;
import dataservice_client.inforManagementdataservice.AgencyInfordataservice;
import po_client.inforManagementPO.AgencyPO;
import state.AgencyType;
import state.ResultMessage;
import vo_client.inforManagementVO.AgencyVO;

public class AgencyInfor implements AgencyInforblservice{

	private AgencyPO po;
	private AgencyVO vo;
	private ResultMessage rm;
	private AgencyInfordataservice agencydataservice;
	@Override
	public ResultMessage add(AgencyVO vo) {
		// TODO Auto-generated method stub
		po=new AgencyPO();
		po.setID(vo.getID());
		po.setCity(vo.getCity());
		switch(vo.getAgencyType()){
		case BUSIHALL:po.setAgencyType(1);break;
		case TRANCEN:po.setAgencyType(2);break;
		case SUPRECOMP:po.setAgencyType(3);break;
		}
		rm=agencydataservice.add(po);
		return rm;
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		rm=agencydataservice.deleteOne(Id);
		return rm;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		rm=agencydataservice.deleteMany(Ids);
		return rm;
	}

	@Override
	public ResultMessage modify(AgencyVO vo) {
		// TODO Auto-generated method stub
		po=new AgencyPO();
		po.setID(vo.getID());
		po.setCity(vo.getCity());
		switch(vo.getAgencyType()){
		case BUSIHALL:po.setAgencyType(1);break;
		case TRANCEN:po.setAgencyType(2);break;
		case SUPRECOMP:po.setAgencyType(3);break;
		}
		rm=agencydataservice.update(po);
		return rm;
	}

	@Override
	public AgencyVO inquire(String Id) {
		// TODO Auto-generated method stub
		po=agencydataservice.find(Id);
		vo=new AgencyVO();
		vo.setID(Id);
		vo.setCity(po.getCity());
		switch(po.getAgencyType()){
		case 1:vo.setAgencyType(AgencyType.BUSIHALL);break;
		case 2:vo.setAgencyType(AgencyType.TRANCEN);break;
		case 3:vo.setAgencyType(AgencyType.SUPRECOMP);break;
		}
		return vo;
	}

}
