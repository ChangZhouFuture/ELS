package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4TranCenVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4TranCenlineitemVO;

/**
 * 
 * @author 朱俊文
 * 处理与中转中心到达单相关的业务逻辑
 *
 */
public interface ArrivalOrder4TranCenblservice {
	/**
	 * 已打开中转中心到达单输入页面
	 * 通过中转单ID获取出发地
	 * @param id
	 * @return 出发地
	 */
	public String getStartAddress(String toid);
	
	/**
	 * 已打开中转中心到达单输入页面
	 * 判断中转单是否存在
	 * @param id
	 * @return 是否存在
	 */
	public ResultMessage addTransferOrder(String id);
	
	/**
	 * 已打开中转中心到达单输入页面
	 * 系统自动返回日期
	 * @return 日期
	 */
	public String getDate();
	
	/**
	 * 已打开中转中心到达单输入页面
	 * 选择货物状态
	 * @return 货物到达状态
	 */
	public GoodState getGoodState();
	
	/**
	 * 选择增加中转中心到达单
	 * 增加一个中转中心到达单，更新VO，PO，返回VO信息到展示层
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @param tcid
	 * @return 一个中转中心到达单
	 */
	public ArrivalOrder4TranCenVO addArrivalOrder4TranCen(String id,String toid,String sa,String d,String gs,String tcid);
	
	/**
	 * 前置：已选择新增中转中心到达单并输入相关信息
	 * 自动生成中转中心到达单编号
	 * @return 中转中心到达单
	 */
	public String generateId();
	
	/**
	 * 前置：已选择更改的中转中心到达单
	 * 更改一个中转中心到达单，更新VO，PO，返回VO信息到展示层
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @param tcid
	 * @return 更改后的中转中心到达单
	 */
	public ArrivalOrder4TranCenVO modify(String id,String toid,String sa,String d,String gs,String tcid);
	
	/**
	 * 前置：启动一个中转接收回合
	 * 删除一个中转中心到达单
	 * @param id
	 */
	public void deleteone(String id);
	
	/**
	 * 前置：启动一个中转接收回合
	 * 删除多个中转中心到达单
	 * @param id
	 */
	public void deleteMany(ArrayList<String> id);
	
	/**
	 * 前置：启动一个中转接收回合
	 * 通过ID查找某个中转中心到达单
	 * @param id
	 * @return 中转中心到达单信息
	 */
	public ArrivalOrder4TranCenVO inquireA(String id);
	
	/**
	 * 前置：启动一个中转接收回合
	 * 按时间查找中转中心到达单列表
	 * @param time
	 * @return 中转中心到达单列表
	 */
	public ArrivalOrder4TranCenlineitemVO inquireB(String time);
	
	/**
	 * 前置：已做出增删改查操作
	 * 结束此次中转接收回合，持久化更新设计的领域对象的数据
	 */
	public void end();
}
