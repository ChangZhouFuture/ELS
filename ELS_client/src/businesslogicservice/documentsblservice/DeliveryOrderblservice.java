package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
 /**
  * 
  * @author 朱俊文
  * 处理与派件单相关的业务逻辑
  *
  */
 public interface DeliveryOrderblservice {
 	
 	/**
 	 * 前置：启动一个新建或修改派件单回合
 	 * 后置：在派件单中增加一个快件编号，返回展示层订单lineitem对象
 	 * @param orderid
 	 * @return 
 	 */
 	public OrderlineitemVO addOrder(String orderID);
 	
 	/**
 	 * 前置：已打开派件单输入页面
 	 * 后置：自动生成派件单日期
 	 * @return 日期
 	 */
 	public String generateDate();
 	
 	/**
 	 * 前置：营业厅业务员已输入所有参数
 	 * 后置：增加一个派件单，更新VO，PO，返回VO信息到展示层
 	 * @param id
 	 * @param orsderidlist
 	 * @param dn
 	 * @param did
 	 * @param d
 	 * @return 一个派件单
 	 */
 	public JavaBean1 addDeliveryOrder(DeliveryOrderVO deliveryOrderVO);
 	
 	/**
 	 * 前置：已添加所有派件单信息
 	 * 后置：自动生成派件单编号
 	 * @return 派件单编号
 	 */
 	public String generateId();
 	
 	/**
 	 * 前置：要修改的派件单在持久化数据中有记录
 	 * 后置：更改一个派件单，更新VO，PO，返回VO信息到展示层
 	 * @param id
 	 * @param orsderidlist
 	 * @param dn
 	 * @param did
 	 * @param d
 	 * @return 更改后的派件单
 	 */
 	public ResultMessage modify(DeliveryOrderVO deliveryOrderVO);
 	
 	/**
 	 * 前置：要删除的派件单在持久化数据中有记录
 	 * 后置：删除一个派件单
 	 * @param id
 	 */

 	public ResultMessage deleteone(String id);
 	
 	/**
 	 * 前置：要删除的派件单在持久化数据中有记录
 	 * 后置：删除多个派件单
 	 * @param id
 	 */
 	public ResultMessage deleteMany(ArrayList<String> idList);
 	
 	/**
 	 * 前置：要查询的派件单在持久化数据中有记录
 	 * 后置：根据id查询某派件单,返回派件单VO信息
 	 * @param id
 	 * @return 派件单信息
 	 */
 	public JavaBean1 inquireA(String id);
 	
 	/**
 	 * 前置：要查询的派件单在持久化数据中有记录
 	 * 后置：根据时间查询某派件单,返回派件单lineitemVO信息
 	 * @param time
 	 * @return 派件单列表
 	 */
 	public JavaBean1 inquireB(String time);
 	
 	public void VOtoPO();
 	
 	public void POtoVO(int k);
	
 	
 	/**
 	 * 前置：业务已经处理完成
 	 * 后置：结束此次派件回合，持久化更新设计的领域对象的数据
 	 */
 	public void end();
}
