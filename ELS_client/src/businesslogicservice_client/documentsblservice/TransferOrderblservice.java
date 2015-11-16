package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;
import state.ResultMessage;
import state.TransportType;
import vo_client.documentsVO.TransferOrderVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;

/**
 * 
 * @author 朱俊文
 * 处理与中转单相关的业务逻辑
 *
 */
public interface TransferOrderblservice {
	
	/**
	 * 前置：要添加的中转中心在数据持久化对象里有记录
	 * 后置：添加一个中转中心
	 * @param tcid
	 * @return 
	 */
	public void addTransferCenter(String tcid);
	
	/**
	 * 前置：启动一个新建或修改中转单回合
	 * 后置：在中转单中增加一个快件编号，返回展示层本单所有快件编号
	 * @param orderid
	 * @return 
	 */
	public OrderlineitemVO addOrder(String orderid);
	
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
	public int generateFare(String sa,String ea);
	
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
	public TransferOrderVO addTransferOrder(String id,TransportType tst,String sa,String ea,ArrayList<String> oidl,String d,String hbid,String hgid,String Jzy);
	
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
	public TransferOrderVO modify(String id,TransportType tst,String sa,String ea,ArrayList<String> oidl,String d,String hbid,String hgid,String Jzy);
	
	/**
	 * 前置：要删除的中转单在持久化数据中有记录
	 * 后置：删除一个中转单
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * 前置：要删除的中转单在持久化数据中有记录
	 * 后置：删除多个中转单
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * 前置：要查询的中转单在持久化数据中有记录
	 * 后置：根据id查询某中转单,返回中转单VO信息
	 * @param id
	 * @return 中转单信息
	 */
	public TransferOrderVO inquireA(String id);
	
	/**
	 * 前置：要查询的中转单在持久化数据中有记录
	 * 后置：根据时间查询某中转单,返回中转单VO信息
	 * @param time
	 * @return 中转单列表
	 */
	public TransferOrderlineitemVO inquireB(String time);
	
	/**
	 * 前置：业务已经处理完成
	 * 后置：结束此次中转回合，持久化更新设计的领域对象的数据
	 */
	public void end();
}
