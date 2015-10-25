package businesslogicservice_client.informngmtblservice;

import state.ResultMessage;
import vo_client.informngmtVO.BankAccountVO;
import vo_client.lineitemVO.informngmtlineitemVO.BankAccountlineitemVO;

/**
 * 
 * @author 周畅
 * 该类主要处理与银行账户信息相关的业务逻辑
 */
public interface BankAccountInforblservice {
	
	/**
	 * 
	 * @param accountName
	 * @param agency
	 * @param id4staff
	 * @param id4Vehics
	 * @return
	 * 前置条件：财务人员已经被授权和登录
	 * 后置条件：完成账户初始化操作
	 */
	public BankAccountVO initialize(String accountName, String agency, String id4staff, String id4Vehics);
		
	/**
	 * 
	 * @param id
	 * @return
	 * 前置条件：要删除的账户在PO中有记录
	 * 后置条件：账户信息被删除
	 * 
	 */
	public ResultMessage delete(String accountName);
	
	/**
	 * 
	 * @param accountName
	 * @return
	 * 前置条件：要修改的账户在PO中有记录
	 * 后置条件：修改该账户账户名称，并更新VO和PO
	 */
	public BankAccountVO modify(String accountName);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * 前置条件：要查询的银行账户在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public BankAccountlineitemVO inquire(String keyword);
	
	/**
	 * 前置条件：业务处理完成
	 * 后置条件：结束这次业务处理，更新数据持久化对象
	 */
	public void end();
}
