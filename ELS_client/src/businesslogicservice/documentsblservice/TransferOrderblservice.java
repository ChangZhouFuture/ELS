package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.TransferOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

/**
 * 
 * @author 朱俊文
 * 处理与中转单相关的业务逻辑
 *
 */
public interface TransferOrderblservice {
	
	/**
	 * 前置：启动一个新建或修改中转单回合
	 * 后置：在中转单中增加一个快件编号，返回展示层本单所有快件编号
	 * @param orderid
	 * @return 
	 */
	public OrderlineitemVO addOrder(String orderId);
	
	/**
	 * 前置：已打开中转单输入页面
	 * 后置：自动生成中转单日期
	 * @return 日期
	 */
	public String generateDate();
	
	/**
	 * 前置：中转中心业务员已输入出发地目的地
	 * 后置：自动计算运费
	 * @param sa
	 * @param ea
	 * @return 运费
	 */
	public double generateFare(String destination);
	
	/**
	 * 前置：中转中心业务员已输入所有参数
	 * 后置：增加一个中转单，更新VO，PO，返回VO信息到展示层
	 * @param id
	 * @param tst
	 * @param sa
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param hbid
	 * @param hgid
	 * @param Jzy
	 * @return 一个中转单
	 */
	public JavaBean1 addTransferOrder(TransferOrderVO transferOrderVO);
	
	/**
	 * 前置：已添加所有中转信息
	 * 后置：自动生成中转单编号
	 * @return 中转单编号
	 */
	public String generateId();
	
	/**
	 * 前置：要修改的中转单在持久化数据中有记录
	 * 后置：更改一个中转单，更新VO，PO，返回VO信息到展示层
	 * @param id
	 * @param tst
	 * @param sa
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param hbid
	 * @param hgid
	 * @param Jzy
	 * @return 更改后的中转单
	 */
	public ResultMessage modify(TransferOrderVO transferOrderVO);
	
	/**
	 * 前置：要删除的中转单在持久化数据中有记录
	 * 后置：删除一个中转单
	 * @param id
	 */
//	public ResultMessage deleteone(String id);
	
	/**
	 * 前置：要删除的中转单在持久化数据中有记录
	 * 后置：删除多个中转单
	 * @param id
	 */
	public ResultMessage delete(ArrayList<String> idList);
	
	/**
	 * 前置：要查询的中转单在持久化数据中有记录
	 * 后置：根据id查询某中转单,返回中转单VO信息
	 * @param id
	 * @return 中转单信息
	 */
	public JavaBean1 inquireA(String id);
	
	/**
	 * 前置：要查询的中转单在持久化数据中有记录
	 * 后置：根据时间查询某中转单,返回中转单VO信息
	 * @param time
	 * @return 中转单列表
	 */
	public JavaBean1 inquireB(String time);
	
	public TransferOrderlineitemVO getTransferOrderlineitemVO(String id);
	
	/**
	 * 前置：业务已经处理完成
	 * 后置：结束此次中转回合，持久化更新设计的领域对象的数据
	 */
	public void end();
	
	public void VOtoPO();
	
	public void lineitemPOtolineitemVO(int k);
}
