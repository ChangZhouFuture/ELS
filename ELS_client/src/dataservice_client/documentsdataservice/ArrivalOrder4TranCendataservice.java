package dataservice_client.documentsdataservice;

import java.util.ArrayList;

import po_client.documentsPO.ArrivalOrder4TranCenPO;
import po_client.lineitemPO.documentslineitemPO.ArrivalOrder4TranCenlineitemPO;
import po_client.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
 
/**
 * @author 朱俊文
 * 该接口提供与中转中心到达单相关的数据层方法
 */
public interface ArrivalOrder4TranCendataservice {
	
	public TransferOrderlineitemPO addTransferOrder(String id);
	
	/**
	 * 前置：中转中心业务员已输入所有参数
	 * 后置：增加一个中转中心到达单，更新变动到PO
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @param tcid
	 * @return 一个中转中心到达单
	 */
	public ResultMessage addArrivalOrder4TranCen(ArrivalOrder4TranCenPO arrivalOrder4TranCenPO);
	
	/**
	 * 前置：要修改的中转中心到达单在PO中有记录
	 * 后置：更改一个中转中心到达单，更新PO相关信息
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @param tcid
	 * @return 更改后的中转中心到达单
	 */
	public ResultMessage modify(ArrivalOrder4TranCenPO arrivalOrder4TranCenPO);
	
	/**
	 * 前置：要删除的中转中心到达单在PO中有记录
	 * 后置：删除一个中转中心到达单，更新PO数据
	 * @param id
	 * @return 
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * 前置：要删除的中转中心到达单在持久化数据中有记录
	 * 后置：删除一个中转中心到达单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * 前置：要查询的中转中心到达单在PO中有记录
	 * 后置：根据时间查询某中转中心到达单,返回中转中心到达单PO信息到业务逻辑层
	 * @param id
	 * @return 中转中心到达单信息
	 */
	public ArrivalOrder4TranCenPO inquireA(String id);
	
	/**
	 * 前置：要查询的中转中心到达单在PO中有记录
	 * 后置：根据时间查询某中转中心到达单,返回中转中心到达单PO信息
	 * @param time
	 * @return 中转中心到达单列表
	 */
	public ArrivalOrder4TranCenlineitemPO inquireB(String time);
	
	/**
	 * 前置：行为或操作已经完成
	 * 后置：持久化更新设计的领域对象的数据
	 */
	public void update();
 }
