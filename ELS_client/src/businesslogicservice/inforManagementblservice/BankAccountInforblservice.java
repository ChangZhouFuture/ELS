package businesslogicservice.inforManagementblservice;

import java.util.ArrayList;

import bean.JavaBean1;
import state.ResultMessage;
import vo.inforManagementVO.BankAccountVO;

/**
 * 
 * @author 周畅
 * 该类主要处理与银行账户信息相关的业务逻辑
 */
public interface BankAccountInforblservice {
	
	public JavaBean1 add(BankAccountVO vo);
	
	public ResultMessage deleteOne(String Id);
	
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	public ResultMessage modify(BankAccountVO vo);
	
	public JavaBean1 find(String Id);
}
