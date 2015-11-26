package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;


/**
 * 该接口提供审批单据相关的数据层方法
 * @author zt
 *
 */
public interface Approdocmdataservice extends Remote{

	/**
	 * 前置条件：数据层有查询的对应id的单据
	 * 后置条件：返回一个单据的数据给逻辑层
	 * @param id
	 * @return
	 */
	public Object inquireA(String id);
	
	/**
	 * 前置条件：
	 * 后置条件：返回一种单据列表给逻辑层
	 * @param kind
	 * @return
	 */
	public Object inquireB(String kind);
	
	/**
	 * 前置条件：
	 * 后置条件：返回某一日的单据列表给逻辑层
	 * @param kind
	 * @return
	 */
	public Object inquireC(String date);
	
	
	/**
	 * 前置条件：要修改的单据在数据层中
	 * 后置条件：修改某一单据
	 * @return
	 */
	public Object modify();
	
	/**
	 * 
	 * 前置条件：行为或操作已经完成
	 * 后置条件：持久化更新涉及的领域对象的数据
	 */
	public void update();

}
