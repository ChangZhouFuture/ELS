package businesslogic.inforManagementbl;

import java.rmi.RemoteException;

import po.inforManagementPO.SalaryStrategyPO;
import state.ResultMessage;
import vo.inforManagementVO.SalaryStrategyVO;
import dataservice.inforManagementdataservice.StaffInfordataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.userManagementbl.UserManagement;
import businesslogicservice.inforManagementblservice.StaffInforblservice;

public class StaffInfor implements StaffInforblservice{
	private StaffInfordataservice staffInfordataservice;
	private SalaryStrategyPO salaryStrategyPO;
	private UserManagement userManagement;
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
		userManagement = new UserManagement();
		javaBean1 = userManagement.inquireA(Id);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String position) {
		//把这一职位的所有人查出来会不会太多了，待定，可能要改
		userManagement = new UserManagement();
		javaBean1 = userManagement.inquireB(position);
		return javaBean1;
	}

	@Override
	public ResultMessage modifySalaryStrategy(SalaryStrategyVO salaryStrategyVO) {
		salaryStrategyPO.setPayType(salaryStrategyVO.getPayType());
		salaryStrategyPO.setPayAmount(salaryStrategyVO.getPayAmount());//基本工资
		salaryStrategyPO.setPercentage(salaryStrategyVO.getPercentage());//提成策略
		salaryStrategyPO.setPosition(salaryStrategyVO.getPosition());
		try {
			staffInfordataservice.updateSalaryStrategy(salaryStrategyPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//调用数据层方法，修改工资策略
		return null;
	}

}
