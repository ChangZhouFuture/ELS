package businesslogicservice.documentsblservice;
import java.util.ArrayList;

import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.BusiHallLoadingListVO;
import vo.lineitemVO.documentslineitemVO.BusiHallLoadingListlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

/**
 * 
 * @author 朱俊文
 * 处理与装车单相关的业务逻辑
 *
 */
public interface BusiHallLoadingListblservice {
	
	/**
	 * 前置：启动一个新建或修改装车单回合
	 * 后置：在装车单中增加一个快件编号，返回展示层本单所有快件编号
	 * @param orderid
	 * @return 
	 */
	public OrderlineitemVO addOrder(String orderid);
	
	/**
	 * 前置：营业厅业务员已输入所有参数
	 * 后置：增加一个装车单，更新VO，PO，返回VO信息到展示层
	 * @param id
	 * @param bhid
	 * @param tlid
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param vid
	 * @param f
	 * @param Jzy
	 * @param Yyy
	 * @return 一个装车单
	 */
	public JavaBean1 addBusinessHallLoadingList(BusiHallLoadingListVO businessHallLoadingListVO);
 	
 	/**
 	 * 前置：要修改的装车单在持久化数据中有记录
 	 * 后置：更改一个装车单，更新VO，PO，返回VO信息到展示层
 	 * @param id
 	 * @param bhid
 	 * @param tlid
 	 * @param ea
 	 * @param orderidlist
 	 * @param d
 	 * @param vid
 	 * @param f
 	 * @param Jzy
 	 * @param Yyy
 	 * @return 更改后的装车单
 	 */
 	public JavaBean1 modify(BusiHallLoadingListVO businessHallLoadingListVO);
 	
 	/**
 	 * 前置：要删除的装车单在持久化数据中有记录
 	 * 后置：删除多个装车单
 	 * @param id
 	 */
public ResultMessage deleteMany(ArrayList<String> idlist);
 	
 	/**
 	 * 前置：要查询的装车单在持久化数据中有记录
 	 * 后置：根据时间查询某装车单,返回装车单VO信息
 	 * @param id
 	 * @return 装车单信息
 	 */
 	public JavaBean1 inquireA(String id);
 	
 	/**
 	 * 前置：要查询的装车单在持久化数据中有记录
 	 * 后置：根据时间查询某装车单,返回装车单VO信息
 	 * @param time
 	 * @return 装车单列表
 	 */
 	public JavaBean1 inquireB(String time);
 	
 }
