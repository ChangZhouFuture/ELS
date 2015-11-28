package businesslogic.inforManagementbl;

import java.util.ArrayList;

import dataservice.inforManagementdataservice.DriversInfordataservice;
import state.ResultMessage;
import vo.inforManagementVO.DriversVO;
import vo.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;
import bean.JavaBean1;
import businesslogicservice.inforManagementblservice.DriversInforblservice;
import po.inforManagementPO.DriversPO;
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
	public JavaBean1 add(DriversVO vo) {
		// TODO Auto-generated method stub
		po=new DriversPO();
        po.setID(vo.getID());
        po.setBirthDate(vo.getBirthDate());
        po.setIdentyNum(vo.getIdentyNum());
        po.setName(vo.getName());
        po.setPhone(vo.getPhone());
        po.setDriveLimitDate(vo.getDriveLimitDate());
        po.setGender(vo.getGender());
//		return driversdataservice.add(po);
        return null;
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
	public JavaBean1 inquire(String Id) {
		// TODO Auto-generated method stub
//		po=driversdataservice.find(Id);
		vo=new DriversVO();
		vo.setID(po.getID());
		vo.setName(po.getName());
		vo.setBirthDate(po.getBirthDate());
		vo.setIdentyNum(po.getIdentyNum());
		vo.setPhone(po.getPhone());
		vo.setDriveLimitDate(po.getDriveLimitDate());
		vo.setGender(po.getGender());
		return null;
	}

	
	
}
