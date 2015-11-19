package businesslogicservice_client_Stub.informngmtblservice_Stub;

import state.ResultMessage;
import vo_client.inforManagementVO.BankAccountVO;
import vo_client.lineitemVO.inforManagementlineitemVO.BankAccountlineitemVO;
import businesslogicservice_client.inforManagementblservice.BankAccountInforblservice;

public class BankAccountInforblservice_Stub implements BankAccountInforblservice{
	String accountName;
	String agency;
	String id4staff;
	String id4Vehics;
	String keyword;
	
	@Override
	public BankAccountVO initialize(String accountName, String agency,
			String id4staff, String id4Vehics) {
		// TODO Auto-generated method stub
		
		end();
		return null;
	}

	@Override
	public ResultMessage delete(String accountName) {
		// TODO Auto-generated method stub
		
		end();
		return null;
	}

	@Override
	public BankAccountVO modify(String accountName) {
		// TODO Auto-generated method stub
		
		end();
		return null;
	}

	@Override
	public BankAccountlineitemVO inquire(String keyword) {
		// TODO Auto-generated method stub
		
		System.out.println("找到相关记录x条");
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
		//调用数据层的update方法
		
	}

}
