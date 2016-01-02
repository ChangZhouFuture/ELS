package businesslogic.inforManagementbl;

import state.OperaType;
import state.Position;
import state.ResultMessage;
import state.UseState;
import vo.inforManagementVO.BankAccountVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.inforManagementdataservice.BankAccountInfordataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.userbl.Login;
import businesslogic.utilitybl.RecordOperaLog;
import businesslogicservice.inforManagementblservice.BankAccountInforblservice;
import po.inforManagementPO.BankAccountPO;
/**
 * 
 * @author 周畅
 *
 */
public class BankAccountInfor implements BankAccountInforblservice {
	private BankAccountInfordataservice bankAccountInfordataservice;
	private BankAccountPO bankAccountPO;
	private BankAccountVO bankAccountVO;
	private RecordOperaLog recordOperaLog;
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
		bankAccountPO = new BankAccountPO();
		this.bankAccountVO = bankAccountVO;
		
		this.bankAccountVO.setUseState(UseState.NotInUse);
		VOtoPO();
		
		try {
			resultMessage = bankAccountInfordataservice.add(bankAccountPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			recordOperaLog.recordOperaLog(OperaType.Add, "银行账户", this.bankAccountVO
					.getName(), Position.Accountant1, Login.id);
		}
		javaBean1 = new JavaBean1();
		javaBean1.setObject(this.bankAccountVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		try {
			resultMessage = bankAccountInfordataservice.deleteMany(IDList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			String name;
			for (int i = 0; i < IDList.size(); i++) {
				name = IDList.get(i);
				recordOperaLog.recordOperaLog(OperaType.Delete, "银行账户", name, 
					Position.Accountant1, Login.id);
			}
		}
		return resultMessage;
	}

	@Override
	public ResultMessage modify(String oldName, String newName) {
		//调用数据层的修改方法,两个参数都传下去
		try {
			resultMessage = bankAccountInfordataservice.update(oldName, newName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			recordOperaLog.recordOperaLog(OperaType.Modify, "银行账户", oldName + "->" +
			newName, Position.Accountant1, Login.id);
		}
		return resultMessage;
	}

	@Override
	public JavaBean1 inquire(String bankAccountName) {
		try {
			javaBean1 = bankAccountInfordataservice.find(bankAccountName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		bankAccountPO = (BankAccountPO)javaBean1.getObject();
		bankAccountVO = new BankAccountVO();
		
		bankAccountVO.setName(bankAccountPO.getName());
		bankAccountVO.setAmount(bankAccountPO.getAmount());
		
		javaBean1.setObject(bankAccountVO);
		return javaBean1;
	}

	public ResultMessage updateBalance(String operation, double amount) {
		double change = 0;
		if (operation=="add") {
			change = amount;
		} 
		else if(operation=="deduct") {
			change = -amount;
		}
		//调用数据层，对默认使用的那一套帐做修改
		
		try {
			resultMessage = bankAccountInfordataservice.updateBalance(change);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	public void VOtoPO() {
		bankAccountPO.setName(bankAccountVO.getName());
		bankAccountPO.setAmount(bankAccountVO.getAmount());
		bankAccountPO.setUseState(bankAccountVO.getUseState());
	}

	public String whichIsUsing() {
		String accountName = null;
		try {
			accountName = bankAccountInfordataservice.getInUse();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return accountName;
	}
	
	@Override
	public ResultMessage use(String accountName) {
		//调用数据层，把选择的账号设置为正在使用（先把所有的设置为没使用）
		try {
			resultMessage = bankAccountInfordataservice.setInUse(accountName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			recordOperaLog.recordOperaLog(OperaType.Use, "银行账户", accountName, 
					Position.Accountant1, Login.id);
		}
		return resultMessage;
	}

}
