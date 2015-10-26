package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.LoadingListVO;
import vo_client.lineitemVO.documentslineitemVO.LoadingListlineitemVO;

/**
 * 
 * @author 朱俊文
 * 处理与装车单相关的业务逻辑
 *
 */
public interface LoadingListblservice {
	/**
	 * 前置：已打开装车单输入页面
	 * 营业厅是否存在
	 * @param bhid
	 * @return 是否存在
	 */
	public ResultMessage addBusiHall(String bhid);
	
	/**
	 * 前置：启动一个新建或修改装车单回合
	 * 后置：在装车单中增加一个快件编号，返回展示层本单所有快件编号
	 * @param orderid
	 * @return 
	 */
	public ArrayList<String> addOrder(String orderid);
	
	/**
	 * 前置：已打开装车单输入页面
	 * 后置：自动生成装车单日期
	 * @return 日期
	 */
	public String generateDate();
	
	/**
	 * 前置：营业厅业务员已输入营业厅编号和日期
	 * 后置：自动生成汽运编号
	 * @param bhid
	 * @param d
	 * @return
	 */
	public String generateTranLoadId(String bhid,String d);
	
	/**
	 * 前置：营业厅业务员已输入出发地目的地
	 * 后置：自动计算运费
	 * @param sa
	 * @param ea
	 * @return 运费
	 */
	public int generateFare(String sa,String ea);
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
	public LoadingListVO addLoadingList(String id,String bhid,String tlid,String ea,ArrayList<String> oidl,String d,String vid,int f,String Jzy,String Yyy);
	
	/**
	 * 前置：已添加所有装车信息
	 * 后置：自动生成装车单编号
	 * @return 装车单编号
	 */
	public String generateId();
	
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
	public LoadingListVO modify(String id,String bhid,String tlid,String ea,ArrayList<String> orderidlist,String d,String vid,int f,String Jzy,String Yyy);
	
	/**
	 * 前置：要删除的装车单在持久化数据中有记录
	 * 后置：删除一个装车单
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
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
	public LoadingListVO inquireA(String id);
	
	/**
	 * 前置：要查询的装车单在持久化数据中有记录
	 * 后置：根据时间查询某装车单,返回装车单VO信息
	 * @param time
	 * @return 装车单列表
	 */
	public LoadingListlineitemVO inquireB(String time);
	
	/**
	 * 前置：业务已经处理完成
	 * 后置：结束此次装车回合，持久化更新设计的领域对象的数据
	 */
	public void end();
}
