package dataservice_client.documentsdataservice;

import java.util.ArrayList;
import po_client.documentsPO.TransferOrderPO;
import po_client.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;
import state.TransportType;

/**
 * @author 朱俊文
 * 该接口提供与中转单相关的数据层方法
 */
 public interface TransferOrderdataservice {
 
	/**
	 * 前置：中转中心业务员已输入所有参数
	 * 后置：增加一个中转单，更新变动到PO
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
	public TransferOrderPO addTransferOrder(String id,TransportType tst,String sa,String ea,ArrayList<String> oidl,String d,String hbid,String hgid,String Jzy);
	
	/**
	 * 前置：要修改的中转单在PO中有记录
	 * 后置：更改一个中转单，更新PO相关信息
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
	public TransferOrderPO modify(String id,TransportType tst,String sa,String ea,ArrayList<String> orderidlist,String d,String hbid,String hgid,String Jzy);
	
	/**
	 * 前置：要删除的中转单在PO中有记录
	 * 后置：删除一个中转单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * 前置：要删除的中转单在PO中有记录
	 * 后置：删除多个中转单，更新PO数据
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * 前置：要查询的中转单在PO中有记录
	 * 后置：根据时间查询某中转单,返回中转单PO信息给业务逻辑层
	 * @param id
	 * @return 中转单信息
	 */
	public TransferOrderPO inquireA(String id);
	
	/**
	 * 前置：要查询的中转单在PO中有记录
	 * 后置：根据时间查询某中转单,返回中转单PO信息
	 * @param time
	 * @return 中转单列表
	 */
	public TransferOrderlineitemPO inquireB(String time);
	
	/**
	 * 前置：行为或操作已经完成
	 * 后置：持久化更新设计的领域对象的数据
	 */
	public void update();
 }
