package businesslogicservice_client.stockblservice;

import java.util.ArrayList;

import vo_client.OrderVO;
import vo_client.stockVO.OutBoundOrderVO;
import vo_client.stockVO.StorageListVO;
/**
 * 
 * @author 周畅
 * 该类处理与入库单相关的业务逻辑
 *
 */
public interface StorageListblservice {
	/**
	 * 
	 * @param id
	 * @return 在入库单中增加一个快件编号，返回展示层快件的部分信息（LineItem形式）
	 */
	public OrderVO addExpress(String id);
	
	/**
	 * 自动计算出入库单id
	 */
	public void generateId();
	
	/**
	 * 自动计算出生成入库单的日期
	 */
	public void generateTime();
		
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 增加一个入库单，更新变动到VO和PO，把VO信息返回到展示层
	 */
	public OutBoundOrderVO add(String desti, String dis, String row, String she, 
			String pos);
	
	/**
	 * 
	 * @param id4obo
	 * 删除一个入库单
	 */
	public void deleteone(String id4obo);
	
	/**
	 * 
	 * @param id4obo
	 * 删除多个入库单
	 */ 
	public void deleteMany(ArrayList<String> id4obo);
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 修改一个入库单，更新相关信息到VO和PO，把VO信息返回到展示层
	 */
	public OutBoundOrderVO modify(String id, String desti, String dis, String row, 
			String she, String pos);
	
	/**
	 * 
	 * @param id
	 * @return 根据id查询某入库单,返回入库单VO信息
	 */
	public OutBoundOrderVO inquireA(String id);
	
	/**
	 * 
	 * @param id
	 * @return 根据时间查询某出库单,返回入库单VO信息
	 */
	public OutBoundOrderVO inquireB(String time);
	
	/**
	 * 
	 * 结束此次与出库单相关的业务，持久化更新涉及的领域对象的数据
	 */
	public void endOBO();
}
