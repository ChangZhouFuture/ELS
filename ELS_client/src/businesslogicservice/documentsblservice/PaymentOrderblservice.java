package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.PaymentOrderVO;


public interface PaymentOrderblservice {
	/**
	 * 
	 * @param date4PaymentOrder
	 * @param amount4PaymentOrder
	 * @param remitter
	 * @param account4PaymentOrder
	 * @param item4Vehicles
	 * @param remark1
	 * @param remark2
	 * @return
	 * 前置条件：财务人员已经被授权和登录
	 * 后置条件：添加新的付款单信息
	 */
	public JavaBean1 add(PaymentOrderVO paymentOrderVO);

	/**
	 * 
	 * @param bussinessHall
	 * @param date
	 * 前置条件：要删除的收款单信息在持久化数据中有记录
	 * 后置条件：删除多条收款单信息
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList);
	
	/**
	 * 
	 * @param bussinessHall
	 * @param date
	 * @return
	 * 前置条件：要修改的付款单信息在PO中有记录
	 * 后置条件：修改付款单信息，并更新VO和PO
	 */
	public JavaBean1 modify(PaymentOrderVO paymentOrderVO);
	
	/**
	 * 
	 * @param id
	 * @return
	 * 前置条件：要查询的付款单信息在数据持久化对象中有记录
	 * 后置条件：返回付款单VO对象
	 */
	public JavaBean1 inquireA(String id);
	
	/**
	 * time
	 * @param 
	 * @return
	 * 前置条件：要查询的付款单信息在数据持久化对象中有记录
	 * 后置条件：返回相关记录的列表
	 */
	public JavaBean1 inquireB(String date);
	
}
