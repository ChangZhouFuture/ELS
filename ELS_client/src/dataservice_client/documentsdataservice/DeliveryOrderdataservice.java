package dataservice_client.documentsdataservice;

import java.util.ArrayList;
import po_client.documentsPO.DeliveryOrderPO;
import po_client.lineitemPO.documentslineitemPO.DeliveryOrderlineitemPO;
import state.ResultMessage;
/**
 * @author 朱俊文
 * 该接口提供与派件单相关的数据层方法
 */
 public interface DeliveryOrderdataservice {
 
	/**
	 * 前置：营业厅业务员已输入所有参数
	 * 后置：增加一个派件单，更新变动到PO
	 * @param id
	 * @param orsderidlist
	 * @param dn
	 * @param did
	 * @param d
	 * @return 一个派件单
	 */
	public DeliveryOrderPO addDeliveryOrder(String id,ArrayList<String> orsderidlist,String dn,String did,String d);
	
	/**
	 * 前置：要删除的派件单在PO有记录
	 * 后置：删除一个派件单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * 前置：要删除的派件单在PO中有记录
	 * 后置：删除多个派件单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * 前置：要修改的派件单在PO中有记录
	 * 后置：更改一个派件单，更新PO相关信息
	 * @param id
	 * @param orsderidlist
	 * @param dn
	 * @param did
	 * @param d
	 * @return 更改后的派件单
	 */
	public DeliveryOrderPO modify(String id,ArrayList<String> orsderidlist,String dn,String did,String d);
	/**
	 * 前置：要查询的派件单在PO中有记录
	 * 后置：根据时间查询某派件单,返回派件单PO信息给业务逻辑层
	 * @param id
	 * @return 派件单信息
	 */
	public DeliveryOrderPO inquireA(String id);
	
	/**
	 * 前置：要查询的派件单在PO中有记录
	 * 后置：根据时间查询某派件单,返回派件单PO信息
	 * @param time
	 * @return 派件单列表
	 */
	public DeliveryOrderlineitemPO inquireB(String time);
	
	/**
	 * 前置：行为或操作已经完成
	 * 后置：持久化更新涉及的领域对象的数据
	 */
	public void update();
 }