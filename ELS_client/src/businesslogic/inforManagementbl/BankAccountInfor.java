package businesslogic.inforManagementbl;

import state.OperaType;
import state.ResultMessage;
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
 * @author �ܳ�
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
		
		this.bankAccountVO.setAmount(0);
		this.bankAccountVO.setUsage("no");
		VOtoPO();
		
		try {
			resultMessage = bankAccountInfordataservice.add(bankAccountPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			recordOperaLog.recordOperaLog(OperaType.Add, "�����˻�", this.bankAccountVO
					.getName(), "������Ա" + Login.id);
		}
		javaBean1.setObject(this.bankAccountVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		return null;
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
				recordOperaLog.recordOperaLog(OperaType.Delete, "�����˻�", name, 
						"������Ա" + Login.id);
			}
		}
		return resultMessage;
	}

	@Override
	public ResultMessage modify(String oldName, String newName) {
		//�������ݲ���޸ķ���,��������������ȥ
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			recordOperaLog.recordOperaLog(OperaType.Modify, "�����˻�", oldName + "->" +
			newName, "������Ա" + Login.id);
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
		double newBalance;
		if (operation=="add") {
			newBalance = amount;
		} 
		else if(operation=="deduct") {
			newBalance = -amount;
		}
		//�������ݲ㣬��Ĭ��ʹ�õ���һ�������޸�
		return resultMessage;
	}

	public void VOtoPO() {
		bankAccountPO.setName(bankAccountVO.getName());
		bankAccountPO.setAmount(bankAccountVO.getAmount());
		bankAccountPO.setUsage(bankAccountVO.getUsage());
	}

	@Override
	public ResultMessage use(String accountName) {
		//�������ݲ㣬��ѡ����˺�����Ϊ����ʹ�ã��Ȱ����е�����Ϊûʹ�ã�
		
		if (resultMessage == ResultMessage.Success) {
			recordOperaLog = new RecordOperaLog();
			recordOperaLog.recordOperaLog(OperaType.Use, "�����˻�", accountName, 
					"������Ա" + Login.id);
		}
		return null;
	}

}
