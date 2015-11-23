package businesslogic_client.inforManagementbl;

import java.util.ArrayList;

import state.Gender;
import state.ResultMessage;
import vo_client.inforManagementVO.DriversVO;
import vo_client.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;
import businesslogicservice_client.inforManagementblservice.DriversInforblservice;
import dataservice_client.inforManagementdataservice.DriversInfordataservice;
import po_client.inforManagementPO.DriversPO;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class DriversInfor implements DriversInforblservice {

	private DriversVO vo;
	private DriverslineitemVO llvo; 
	private DriversPO po;
	private ResultMessage rm;
	private DriversInfordataservice driversdataservice;
	@Override
	public ResultMessage add(DriversVO vo) {
		// TODO Auto-generated method stub
		po=new DriversPO();
        po.setID(vo.getID());
        po.setBirthDate(vo.getBirthDate());
        po.setIdentyNum(vo.getIdentyNum());
        po.setName(vo.getName());
        po.setPhone(vo.getPhone());
        po.setDriveLimitDate(vo.getDriveLimitDate());
        Gender x=vo.getGender();
        switch(x){
        	case MALE:
        		po.setGender(1);
        		break;
        	case FEMALE:
        		po.setGender(2);
        		break;
        }
		return driversdataservice.add(po);
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		rm=driversdataservice.deleteOne(Id);
		return rm;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		rm=driversdataservice.deleteMany(Ids);
		return rm;
	}


	@Override
	public ResultMessage modify(DriversVO vo) {
		// TODO Auto-generated method stub
		po=new DriversPO();
		po.setID(vo.getID());
        po.setBirthDate(vo.getBirthDate());
        po.setIdentyNum(vo.getIdentyNum());
        po.setName(vo.getName());
        po.setPhone(vo.getPhone());
        po.setDriveLimitDate(vo.getDriveLimitDate());
        Gender x=vo.getGender();
        switch(x){
        	case MALE:
        		po.setGender(1);
        		break;
        	case FEMALE:
        		po.setGender(2);
        		break;
        }
		return driversdataservice.update(po);
	}

	@Override
	public DriversVO inquire(String Id) {
		// TODO Auto-generated method stub
		po=driversdataservice.find(Id);
		vo=new DriversVO();
		vo.setID(po.getID());
		vo.setName(po.getName());
		vo.setBirthDate(po.getBirthDate());
		vo.setIdentyNum(po.getIdentyNum());
		vo.setPhone(po.getPhone());
		vo.setDriveLimitDate(po.getDriveLimitDate());
		switch(po.getGender()){
		case 1:
			vo.setGender(Gender.MALE);
		case 2:
			vo.setGender(Gender.FEMALE);
		}
		return vo;
	}

	
	
}
