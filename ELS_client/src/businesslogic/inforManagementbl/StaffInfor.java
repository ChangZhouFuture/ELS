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
		//����һְλ�������˲�����᲻��̫���ˣ�����������Ҫ��
		userManagement = new UserManagement();
		javaBean1 = userManagement.inquireB(position);
		return javaBean1;
	}

	@Override
	public ResultMessage modifySalaryStrategy(SalaryStrategyVO salaryStrategyVO) {
		salaryStrategyPO.setPayType(salaryStrategyVO.getPayType());
		salaryStrategyPO.setPayAmount(salaryStrategyVO.getPayAmount());//��������
		salaryStrategyPO.setPercentage(salaryStrategyVO.getPercentage());//��ɲ���
		salaryStrategyPO.setPosition(salaryStrategyVO.getPosition());
		try {
			staffInfordataservice.updateSalaryStrategy(salaryStrategyPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//�������ݲ㷽�����޸Ĺ��ʲ���
		return null;
	}

}
