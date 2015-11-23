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
        po.setGender(vo.getGender());
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
        po.setGender(vo.getGender());
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
		vo.setGender(po.getGender());
		return vo;
	}

	
	
}
