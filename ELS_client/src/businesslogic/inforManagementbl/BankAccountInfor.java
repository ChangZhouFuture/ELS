package businesslogic.inforManagementbl;

import state.ResultMessage;
import vo.inforManagementVO.BankAccountVO;

import java.util.ArrayList;

import dataservice.inforManagementdataservice.BankAccountInfordataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.inforManagementblservice.BankAccountInforblservice;
import po.inforManagementPO.BankAccountPO;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class BankAccountInfor implements BankAccountInforblservice {
	private BankAccountInfordataservice bankAccountInfordataservice;
	private BankAccountPO bankAccountPO;
	private BankAccountVO bankAccountVO;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	
	public BankAccountInfor() {
		try {
			bankAccountInfordataservice = RMIHelper.getBankAccountInfordataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 add(BankAccountVO bankAccountVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(BankAccountVO bankAccountVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquire(String bankAccountName) {
		// TODO Auto-generated method stub
		return null;
	}

}
