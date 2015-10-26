package dataservice_client.documentsdataservice;

import java.util.ArrayList;

import po_client.documentsPO.ArrivalOrder4BusiHallPO;
import po_client.lineitemPO.documentslineitemPO.ArrivalOrder4BusiHalllineitemPO;
import state.GoodState;
import state.ResultMessage;

/**
 * 
 * @author 朱俊文
 * 该接口提供与营业厅到达单单相关的数据层方法
 *
 */
public interface ArrivalOrder4BusiHalldataservice {

	/**
	 * 前置：营业厅业务员已输入所有参数
	 * 后置：增加一个营业厅到达单，更新PO
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @return 一个营业厅到达单
	 */
	public ArrivalOrder4BusiHallPO addArrivalOrder4BusiHall(String id,String toid,String sa,String d,GoodState gs);
	
	/**
	 * 前置：要修改的营业厅到达单在PO中有记录
	 * 后置：更改一个营业厅到达单，更新PO相关信息
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @return 更改后的营业厅到达单
	 */
	public ArrivalOrder4BusiHallPO modify(String id,String toid,String sa,String d,GoodState gs);
	
	/**
	 * 前置：要删除的营业厅到达单在PO中有记录
	 * 后置：删除一个营业厅到达单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * 前置：要删除的营业厅到达单在持久化数据中有记录
	 * 后置：删除多个营业厅到达单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * 前置：要查询的营业厅到达单在PO中有记录
	 * 后置：根据时间查询某营业厅到达单,返回营业厅到达单PO信息给业务逻辑层
	 * @param id
	 * @return 营业厅到达单信息
	 */
	public ArrivalOrder4BusiHallPO inquireA(String id);
	
	/**
	 * 前置：要查询的营业厅到达单在PO中有记录
	 * 后置：根据时间查询某营业厅到达单,返回营业厅到达单PO信息
	 * @param time
	 * @return 营业厅到达单列表
	 */
	public ArrivalOrder4BusiHalllineitemPO inquireB(String time);
	
	/**
	 * 前置：行为或操作已经完成
	 * 后置：持久化更新设计的领域对象的数据
	 */
	public void update();
}
