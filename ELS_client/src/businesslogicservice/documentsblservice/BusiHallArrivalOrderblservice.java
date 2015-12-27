package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
 
 /**
  * 
  * @author 朱俊文
  * 处理与营业厅到达单相关的业务逻辑
  *
  */
 public interface BusiHallArrivalOrderblservice {
 	/**
 	 * 前置：要添加的中转单在数据持久化对象中有记录
 	 * 后置：添加中转单lineitem记录,并向展示层返回VO
 	 * @param id
 	 * @return 
 	 */
 	public TransferOrderlineitemVO addTransferOrder(String id);
 	
 	/**
 	 * 前置：营业厅业务员已输入所有参数
 	 * 后置：增加一个营业厅到达单，更新VO，PO，返回VO信息到展示层
 	 * @param id
 	 * @param toid
 	 * @param sa
 	 * @param d
 	 * @param gs
 	 * @return 一个营业厅到达单
 	 */
 	public JavaBean1 addBusiHallArrivalOrder(BusiHallArrivalOrderVO arrivalOrder4BusiHallVO);
 	
 	/**
 	 * 前置：要修改的营业厅到达单在持久化数据中有记录
 	 * 后置：更改一个营业厅到达单，更新VO，PO，返回VO信息到展示层
 	 * @param id
 	 * @param toid
 	 * @param sa
 	 * @param d
 	 * @param gs
 	 * @return 更改后的营业厅到达单
 	 */
 	public JavaBean1 modify(BusiHallArrivalOrderVO arrivalOrder4BusiHallVO);
 	
 	/**
 	 * 前置：要删除的营业厅到达单在持久化数据中有记录
-	 * 后置：删除多个营业厅到达单
 	 * @param id
 	 */
 	public ResultMessage deleteMany(ArrayList<String> idlist);
 	
 	/**
 	 * 前置：要查询的营业厅到达单在持久化数据中有记录
 	 * 后置：根据时间查询某营业厅到达单,返回营业厅到达单VO信息
 	 * @param id
 	 * @return 营业厅到达单信息
 	 */
 	public JavaBean1 inquireA(String id);
 	
 	/**
 	 * 前置：要查询的营业厅到达单在持久化数据中有记录
 	 * 后置：根据时间查询某营业厅到达单,返回营业厅到达单VO信息
 	 * @param time
 	 * @return 营业厅到达单列表
 	 */
 	public JavaBean1 inquireB(String time);
 	
}
