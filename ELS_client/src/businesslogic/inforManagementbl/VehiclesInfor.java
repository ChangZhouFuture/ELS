package businesslogic.inforManagementbl;

import java.util.ArrayList;

import dataservice.inforManagementdataservice.VehiclesInfordataservice;
import state.ResultMessage;
import vo.inforManagementVO.VehiclesVO;
import businesslogicservice.inforManagementblservice.VehiclesInforblservice;
import po.inforManagementPO.VehiclesPO;
/**
 * 
 * @author �ܳ�
 *
 */
public class VehiclesInfor implements VehiclesInforblservice {

	private VehiclesVO vo;
	private VehiclesPO po;
	private ResultMessage rm;
	private VehiclesInfordataservice vehiclesdataservice;
	@Override
	public ResultMessage add(VehiclesVO vo) {
		// TODO Auto-generated method stub
		po=new VehiclesPO();
		po.setID(vo.getID());
		po.setPlateNum(vo.getPlateNum());
		po.setServiceTime(vo.getServiceTime());
		rm=vehiclesdataservice.add(po);
		return rm;
	}
	
	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		rm=vehiclesdataservice.deleteOne(Id);
		return rm;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		rm=vehiclesdataservice.deleteMany(Ids);
		return rm;
	}

	@Override
	public ResultMessage modify(VehiclesVO vo) {
		// TODO Auto-generated method stub
		po=new VehiclesPO();
		po.setID(vo.getID());
		po.setPlateNum(vo.getPlateNum());
		po.setServiceTime(vo.getServiceTime());
		rm=vehiclesdataservice.update(po);
		return rm;
	}

	@Override
	public VehiclesVO inquire(String Id) {
		// TODO Auto-generated method stub
		vo=new VehiclesVO();
		po=vehiclesdataservice.find(Id);
		vo.setID(Id);
		vo.setPlateNum(po.getPlateNum());
		vo.setServiceTime(po.getServiceTime());
		return vo;
	}

}