package businesslogicservice_client.mngerandaccountantblservice;


/**
 * 
 * @author zt
 * 该类处理审批单据相关的业务逻辑
 */
public interface ApproDocmblservice {
	/**
	 * 前置条件：启动一个审批单据任务
	 * 后置条件：选择一种单据，显示其列表
	 * @param kind
	 * @return
	 */
	public Object chooseKind(String kind);
	
	/**
	 * 前置条件：打开一种单据列表
	 * 后置条件：查询一个单据的数据
	 * @param id
	 * @return
	 */
	public Object inquire(String id);
	
	/**
	 * 前置条件：显示一个单据的数据
	 * 后置条件：修改一个单据的数据
	 * @return
	 */
	public Object modify();
	
	/**
	 * 前置条件：启动一个审批单据任务
	 * 后置条件：删除一个单据
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * 前置条件：已审批
	 * 后置条件：标记单据为已审批
	 * @param id
	 */
	public void finishApprove(String id);
	
	/**
	 * 前置条件：已审批
	 * 后置条件：标记多个单据为已审批状态
	 */
	public void mark();
	
	/**
	 * 前置条件：完成审批单据
	 * 后置条件：结束审批单据，持久化更新涉及的领域对象的数据
	 */
	public void endAD();
	
}
