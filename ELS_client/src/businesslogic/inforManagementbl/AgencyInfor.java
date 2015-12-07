package businesslogic.inforManagementbl;

import java.util.ArrayList;

import dataservice.inforManagementdataservice.AgencyInfordataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.inforManagementblservice.AgencyInforblservice;
import po.inforManagementPO.AgencyPO;
import state.ResultMessage;
import vo.inforManagementVO.AgencyVO;

public class AgencyInfor implements AgencyInforblservice{
	private AgencyInfordataservice agencyInfordataservice;
	private AgencyPO agencyPO;
	private AgencyVO agencyVO;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	
	public AgencyInfor() {
		try {
			agencyInfordataservice = RMIHelper.getAgencyInfordataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 add(AgencyVO agencyVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOne(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(AgencyVO agencyVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquire(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateID() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
