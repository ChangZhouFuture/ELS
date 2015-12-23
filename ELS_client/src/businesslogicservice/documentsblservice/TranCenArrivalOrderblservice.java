package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.TranCenArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;

/**
 * 
 * @author 朱俊文
 * 处理与中转中心到达单相关的业务逻辑
 *
 */
public interface TranCenArrivalOrderblservice {
	/**
	 * 前置：已打开中转中心到达单输入页面
	 * 判断中转单是否存在
	 * @param id
	 * @return 是否存在
	 */
	public TransferOrderlineitemVO addTransferOrder(String id);
	
	/**
	 * 前置：中转中心业务员已输入所有参数
	 * 后置：增加一个中转中心到达单，更新VO，PO，返回VO信息到展示层
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
 	 * @param gs
	 * @param tcid
	 * @return 一个中转中心到达单
	 */
	public JavaBean1 addTranCenArivalOrder(TranCenArrivalOrderVO tranCenArrivalOrderVO);
	
	/**
+	 * 前置：要修改的中转中心到达单在持久化数据中有记录
+	 * 后置：更改一个中转中心到达单，更新VO，PO，返回VO信息到展示层
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
 	 * @param gs
	 * @param tcid
	 * @return 更改后的中转中心到达单
	 */
	public ResultMessage modify(TranCenArrivalOrderVO arrivalOrder4TranCenVO);
	
	/**
	 * 前置：要删除的中转中心到达单在持久化数据中有记录
	 * 后置：删除多个中转中心到达单
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * 前置：要查询的中转中心到达单在持久化数据中有记录
	 * 后置：根据时间查询某中转中心到达单,返回中转中心到达单VO信息
	 * @param id
	 * @return 中转中心到达单信息
	 */
	public JavaBean1 inquireA(String id);
	
	/**
	 * 前置：要查询的中转中心到达单在持久化数据中有记录
	 * 后置：根据时间查询某中转中心到达单,返回中转中心到达单VO信息
	 * @param time
	 * @return 中转中心到达单列表
	 */
	public JavaBean1 inquireB(String time);
	
}
