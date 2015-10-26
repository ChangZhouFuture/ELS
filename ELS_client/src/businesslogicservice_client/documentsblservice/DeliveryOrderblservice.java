package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.OrderVO;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;
import vo_client.userVO.CourierVO;
/**
 * 
 * @author 朱俊文
 * 处理与派件单相关的业务逻辑
 *
 */
public interface DeliveryOrderblservice {
	/**
	 * 通过派件员ID获取派件员姓名
	 * @param id
	 * @return 派件员部分信息
	 */
	public String getDeliverier(String id);
	
	/**
	 * 已打开派件单输入页面
	 * 判断快递员是否存在
	 * @param id
	 * @return 是否存在
	 */
	public ResultMessage addDeliverier(String id);
	
	/**
	 * 已打开派件单输入页面
	 * 增加订单
	 * @param orderid
	 * @return 
	 */
	public ArrayList<String> addOrder(String orderid);
	
	/**
	 * 已打开派件单输入页面
	 * 系统自动返回日期
	 * @return 日期
	 */
	public String getDate();
	
	/**
	 * 选择增加派件单
	 * 增加一个派件单，更新VO，PO，返回VO信息到展示层
	 * @param id
	 * @param orsderidlist
	 * @param dn
	 * @param did
	 * @param d
	 * @return 一个派件单
	 */
	public DeliveryOrderVO addDeliveryOrder(String id,ArrayList<String> orsderidlist,String dn,String did,String d);
	
	/**
	 * 前置：已选择新增派件单并输入相关信息
	 * 自动生成派件单编号
	 * @return 派件单编号
	 */
	public String generateId();
	
	/**
	 * 前置：已选择更改的派件单
	 * 更改一个派件单，更新VO，PO，返回VO信息到展示层
	 * @param dn
	 * @param d
	 * @param orsderidlist
	 * @param id
	 * @return 更改后的派件单
	 */
	public DeliveryOrderVO modify(String id,ArrayList<String> orsderidlist,String dn,String did,String d);
	
	/**
	 * 前置：启动一个派件回合
	 * 删除一个派件单
	 * @param id
	 */
	public void deleteone(String id);
	
	/**
	 * 前置：启动一个派件回合
	 * 删除多个派件单
	 * @param id
	 */
	public void deleteMany(ArrayList<String> id);
	
	/**
	 * 前置：启动一个派件回合
	 * 通过ID查找某个派件单
	 * @param id
	 * @return 派件单信息
	 */
	public DeliveryOrderVO inquireA(String id);
	
	/**
	 * 前置：启动一个派件回合
	 * 按时间查找派件单列表
	 * @param time
	 * @return 派件单列表
	 */
	public DeliveryOrderlineitemVO inquireB(String time);
	
	/**
	 * 前置：已做出增删改查操作
	 * 结束此次派件回合，持久化更新设计的领域对象的数据
	 */
	public void end();
}
