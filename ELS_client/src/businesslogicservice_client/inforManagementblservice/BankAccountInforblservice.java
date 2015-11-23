package businesslogicservice_client.inforManagementblservice;

import java.util.ArrayList;
import state.ResultMessage;
import vo_client.inforManagementVO.BankAccountVO;

/**
 * 
 * @author 周畅
 * 该类主要处理与银行账户信息相关的业务逻辑
 */
public interface BankAccountInforblservice {
	
	public ResultMessage add(BankAccountVO vo);
	
	public ResultMessage deleteOne(String Id);
	
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	public ResultMessage modify(BankAccountVO vo);
	
	public BankAccountVO find(String Id);
}
