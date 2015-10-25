package businesslogicservice_client.stockblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.OrderVO;
import vo_client.lineitemVO.OrderlineitemVO;
import vo_client.lineitemVO.stocklineitemVO.OutBoundOrderlineitemVO;
import vo_client.stockVO.OutBoundOrderVO;
/**
 * 
 * @author 周畅
 * 该接口处理与出库单相关的业务逻辑
 *
 */
public interface OutBoundOrderblservice {
	
	/**
	 * 
	 * @param id
	 * 前置条件：启动一个新建或修改出库单回合
	 * 后置条件：在出库单中增加一个快件编号，返回展示层快件的部分信息（LineItem形式）
	 * 
	 */
	public OutBoundOrderlineitemVO addExpress(String id);
	
	/**
	 * 前置条件：已添加所有出库单信息
	 * 后置条件：自动计算出出库单id
	 */
	public void generateId();
	
	/**
	 * 前置条件：已添加所有出库单信息（不包括时间）
	 * 后置条件：自动计算出生成出库单的日期和具体时间
	 */
	public void generateTime();
		
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * 前置条件：库存管理人员已经输入了所有出库单参数值
	 * 后置条件:增加一个出库单，更新变动到VO和PO，把VO信息返回到展示层
	 */
	public OutBoundOrderVO add(String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id4obo
	 * 前置条件：要删除的出库单在持久化数据中有记录
	 * 后置条件：删除一个出库单
	 */
	public ResultMessage deleteone(String id4obo);
	
	/**
	 * 
	 * @param id4obo
	 * 前置条件：要删除的出库单在持久化数据中有记录
	 * 后置条件：删除多个出库单
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4obo);
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * 前置条件：要修改的出库单在持久化数据中有记录
	 * 后置条件：修改一个出库单，更新相关信息到VO和PO，把VO信息返回到展示层
	 */
	public OutBoundOrderVO modify(String id, String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * 前置条件：要查询的出库单在持久化数据中有记录
	 * 后置条件：根据id查询某出库单,返回出库单VO信息
	 */
	public OutBoundOrderVO inquireA(String id);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * 前置条件：库存管理人员已经被授权和登录
	 * 后置条件：根据时间查询某出库单,返回出库单VO信息
	 */
	public OutBoundOrderVO inquireB(String time);
	
	/**
	 * 
	 * 前置条件：业务已经处理完成
	 * 后置条件：结束此次与出库单相关的业务，持久化更新涉及的领域对象的数据
	 */
	public void endOBO();


}
