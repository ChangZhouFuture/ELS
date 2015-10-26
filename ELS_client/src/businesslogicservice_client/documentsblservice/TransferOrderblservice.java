package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.ResultMessage;
import state.TransportType;
import vo_client.documentsVO.TransferOrderVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;

/**
 * 
 * @author 朱俊文
 * 处理与中转单相关的业务逻辑
 *
 */
public interface TransferOrderblservice {
	
	/**
	 * 已打开中转单输入页面
	 * 中转中心是否存在
	 * @param tcid
	 * @return 是否存在
	 */
	public ResultMessage addTransferCenter(String tcid);
	
	/**
	 * 已打开中转单输入页面
	 * 增加订单
	 * @param orderid
	 * @return 
	 */
	public ArrayList<String> addOrder(String orderid);
	
	/**
	 * 已打开中转单输入页面
	 * 系统自动返回日期
	 * @return 日期
	 */
	public String getDate();
	
	/**
	 * 已输入出发地目的地
	 * 系统自动计算运费
	 * @param sa
	 * @param ea
	 * @return 运费
	 */
	public int getFare(String sa,String ea);
	/**
	 * 选择增加中转单
	 * 增加一个中转单，更新VO，PO，返回VO信息到展示层
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
	public TransferOrderVO addTransferOrder(String id,TransportType tst,String sa,String ea,ArrayList<String> orderidlist,String d,String hbid,String hgid,String Jzy);
	
	/**
	 * 前置：已选择新增中转单并输入相关信息
	 * 自动生成中转单编号
	 * @return 中转单编号
	 */
	public String generateId();
	
	/**
	 * 前置：已选择更改的中转单
	 * 更改一个中转单，更新VO，PO，返回VO信息到展示层
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
	public TransferOrderVO modify(String id,TransportType tst,String sa,String ea,ArrayList<String> orderidlist,String d,String hbid,String hgid,String Jzy);
	
	/**
	 * 前置：启动一个中转回合
	 * 删除一个中转单
	 * @param id
	 */
	public void deleteone(String id);
	
	/**
	 * 前置：启动一个中转回合
	 * 删除多个中转单
	 * @param id
	 */
	public void deleteMany(ArrayList<String> id);
	
	/**
	 * 前置：启动一个中转回合
	 * 通过ID查找某个中转单
	 * @param id
	 * @return 中转单信息
	 */
	public TransferOrderVO inquireA(String id);
	
	/**
	 * 前置：启动一个中转回合
	 * 按时间查找中转单列表
	 * @param time
	 * @return 中转单列表
	 */
	public TransferOrderlineitemVO inquireB(String time);
	
	/**
	 * 前置：已做出增删改查操作
	 * 结束此次中转回合，持久化更新设计的领域对象的数据
	 */
	public void end();
}
