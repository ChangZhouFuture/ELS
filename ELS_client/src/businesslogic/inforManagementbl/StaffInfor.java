package businesslogic.inforManagementbl;

import po.userPO.UserPO;
import state.ResultMessage;
import dataservice.inforManagementdataservice.StaffInfordataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.inforManagementblservice.StaffInforblservice;

public class StaffInfor implements StaffInforblservice{
	private StaffInfordataservice staffInfordataservice;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	
	
	public StaffInfor() {
		try {
			staffInfordataservice = RMIHelper.getStaffInfordataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 inquireA(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireB(String position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifySalaryStrategy(UserPO userPO) {
		// TODO Auto-generated method stub
		return null;
	}

}
