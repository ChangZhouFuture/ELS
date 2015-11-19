package dataservice_client.inforManagementdataservice;

import po_client.inforManagementPO.BankAccountPO;
import po_client.lineitemPO.inforManagementlineitemPO.BankAccountlineitemPO;
import state.ResultMessage;

public interface BankAccountInfordataservice {
	
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
	public BankAccountPO initialize(String accountName, String agency, String id4staff, String id4Vehics);
		
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
	public BankAccountPO modify(String accountName);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * 前置条件：要查询的银行账户在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public BankAccountlineitemPO inquire(String keyword);
	
	/**
	 * 前置条件：业务处理完成
	 * 后置条件：更新数据持久化对象
	 */
	public void update();
}
