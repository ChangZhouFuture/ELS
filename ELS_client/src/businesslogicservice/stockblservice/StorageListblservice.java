package businesslogicservice.stockblservice;

import java.util.ArrayList;

import bean.JavaBean1;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.stockVO.StorageListVO;
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
	public OrderlineitemVO addExpress(String expressID);
	
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 增加一个入库单，更新变动到PO，把VO信息返回到展示层
	 */
	public JavaBean1 add(StorageListVO storageListVO);
	
	/**
	 * 
	 * @param id4obo
	 * 删除一个入库单
	 */
	public ResultMessage deleteone(String id4obo);
	
	/**
	 * 
	 * @param id4obo
	 * 删除多个入库单
	 */ 
	public ResultMessage deleteMany(ArrayList<String> IDList);
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 修改一个入库单，更新相关信息到VO和PO，把VO信息返回到展示层
	 */
	public ResultMessage modify(StorageListVO storageListVO);
	
	/**
	 * 
	 * @param id
	 * @return 根据id查询某入库单,返回入库单VO信息
	 */
	public JavaBean1 inquireA(String ID);
	
	/**
	 * 
	 * @param id
	 * @return 根据时间查询某出库单,返回入库单VO信息
	 */
	public JavaBean1 inquireB(String date);
}
