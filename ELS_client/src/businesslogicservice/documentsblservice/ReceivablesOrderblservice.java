package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.ReceivablesOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public interface ReceivablesOrderblservice {
	/**
	 * 
	 * @param date4RO
	 * @param amount4RO
	 * @param courier4RO
	 * @param barCode
	 * @return
	 * 前置条件：营业厅业务员已经被授权和登录
	 * 后置条件：添加新的收款单信息
	 */
	public JavaBean1 add(ReceivablesOrderVO receivablesOrderVO);
		
	/**
	 * 
	 * @param id
	 * @return
	 * 前置条件：要删除的收款单信息在PO中有记录
	 * 后置条件：删除一条收款单信息
	 * 
	 */
	public ResultMessage deleteOne(String date,String courierId);

	/**
	 * 
	 * @param id4courier
	 * @param date
	 * 前置条件：要删除的收款单信息在持久化数据中有记录
	 * 后置条件：删除多条收款单信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList);
	
	/**
	 * 
	 * @param id4courier
	 * @param date
	 * @return
	 * 前置条件：要修改的收款单信息在PO中有记录
	 * 后置条件：修改收款单信息，并更新VO和PO
	 */
	public ResultMessage modify(ReceivablesOrderVO receivablesOrderVO);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * 前置条件：要查询的收款单信息在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public JavaBean1 inquireA(String id);
	
	public JavaBean1 inqurieB(String date);
	
	public String generateDate();
	
	public String generateID();
	
	public OrderlineitemVO addOrder(String orderId);
	
	public void VOtoPO();
	
	public void POtoVO(int k);
	
	public double calculateAmount(ArrayList<String> OrderId);
	/**
	 * 前置条件：收款单信息处理完成
	 * 后置条件：结束这次收款单信息处理，更新数据持久化对象
	 */
	public void end();

}
