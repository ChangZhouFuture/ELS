package dataservice_client.orderdataservice;

import po_client.OrderPO;
import state.ExpressType;

public interface Orderdataservice {
	/**
	 * 前置条件：输入所有订单参数
     * 后置条件：增加一个订单，更新同步到PO
	 * @param sender
	 * @param addressee
	 * @param desti
	 * @param startingPlace
	 * @param eType
	 * @param name
	 * @param id
	 * @param num
	 * @return
	 */
	public OrderPO add(String sender, String addressee, String desti, String startingPlace,
			ExpressType eType, String name, String id, int num);
	
	/**
	 * 前置条件：要删除的订单在PO中有记录
	 * 后置条件：删除一个订单，更新PO
	 * @param orderid
	 */
    public void delete(String id);
    
    /**
     * 前置条件：要修改的订单在PO中有记录
     * 后置条件：修改一个订单的内容，更新PO
     * @param sender
     * @param addressee
     * @param desti
     * @param startingPlace
     * @param eType
     * @param name
     * @param id
     * @param num
     * @return
     */
    public OrderPO modify(String sender, String addressee, String desti, String startingPlace,
 			ExpressType eType, String name, String id, int num);
    
    /**
     * 前置条件：
     * 后置条件：根据id查询订单，返回po信息给逻辑层
     * @param id
     * @return
     */
    public OrderPO inquireA(String id);
    
    /**
     * 前置条件：
     * 后置条件：根据时间查询订单，返回po信息给逻辑层
     * @param id
     * @return
     */
    public OrderPO inquireB(String date);
    
    /**
	 * 
	 * 前置条件：行为或操作已经完成
	 * 后置条件：持久化更新涉及的领域对象的数据
	 */
	public void update();

}
