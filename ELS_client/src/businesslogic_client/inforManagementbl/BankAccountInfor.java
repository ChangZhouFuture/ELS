package businesslogic_client.inforManagementbl;

import state.ResultMessage;
import vo_client.inforManagementVO.BankAccountVO;
import vo_client.lineitemVO.inforManagementlineitemVO.BankAccountlineitemVO;
import businesslogicservice_client.inforManagementblservice.BankAccountInforblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class BankAccountInfor implements BankAccountInforblservice {

	@Override
	public BankAccountVO initialize(String accountName, String agency,
			String id4staff, String id4Vehics) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String accountName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountVO modify(String accountName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountlineitemVO inquire(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
