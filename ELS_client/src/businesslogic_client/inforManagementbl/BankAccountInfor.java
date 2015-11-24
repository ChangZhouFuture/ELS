package businesslogic_client.inforManagementbl;

import state.ResultMessage;
import vo_client.inforManagementVO.BankAccountVO;
import java.util.ArrayList;
import businesslogicservice_client.inforManagementblservice.BankAccountInforblservice;
import dataservice_client.inforManagementdataservice.BankAccountInfordataservice;
import po_client.inforManagementPO.BankAccountPO;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class BankAccountInfor implements BankAccountInforblservice {
    
	private BankAccountVO vo;
	private BankAccountPO po;
	private ResultMessage rm;
	private BankAccountInfordataservice bankaccountservice;
	@Override
	public ResultMessage add(BankAccountVO vo) {
		// TODO Auto-generated method stub
		po=new BankAccountPO();
		po.setName(vo.getName());
		po.setAmount(vo.getAmount());
		rm=bankaccountservice.add(po);
		return rm;
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		rm=bankaccountservice.deleteOne(Id);
		return rm;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		rm=bankaccountservice.deleteMany(Ids);
		return rm;
	}

	@Override
	public ResultMessage modify(BankAccountVO vo) {
		// TODO Auto-generated method stub
		po=new BankAccountPO();
		po.setName(vo.getName());
		po.setAmount(vo.getAmount());
		rm=bankaccountservice.update(po);
		return rm;
	}

	@Override
	public BankAccountVO find(String Id) {
		// TODO Auto-generated method stub
		po=bankaccountservice.find(Id);
		vo=new BankAccountVO();
		vo.setName(po.getName());
		vo.setAmount(po.getAmount());
		return vo;
	}

	

}
