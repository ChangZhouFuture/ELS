package businesslogicservice.orderblservice;

import java.util.ArrayList;

import bean.JavaBean1;
import state.ExpressType;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.orderVO.OrderVO;
/**
 * 
 * @author zt
 * 该类处理有关订单的业务逻辑
 */

public interface Orderblservice {
     /**
      * 前置条件：启动一个订单回合
      * 后置条件：在一个订单回合中，输入寄件单信息生成订单
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
	 public JavaBean1 add(OrderVO orderVO);
	 
	 /**
	  * 前置条件：展开一个订单列表
	  * 后置条件：在订单列表中删除一个订单
	  * @param orderid
	  */
     public ResultMessage deleteOne(String id);
     
     public ResultMessage deleteMany(ArrayList<String> idList);
     
     /**
      * 前置条件：选择一个订单
      * 后置条件：修改一个订单的内容
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
     public ResultMessage modify(OrderVO orderVO);
     
     /**
      * 前置条件：输入一个订单编号
      * 后置条件：查看一个订单的内容
      * @param orderid
      * @return
      */
     public JavaBean1 inquireA(String id);
     
     /**
      * 前置条件：输入一个日期
      * 后置条件：查看一个订单内容
      * @param time
      * @return
      */
     public JavaBean1 inquireB(String date);
     
     /**
      * 前置条件：完成订单信息输入
      * 后置条件：生成一个订单的条形码号
      * @return
      */
     public String generateId();
     
     /**
      * 前置条件：完成订单信息输入
      * 后置条件：根据订单信息计算总费用 ，运费+包装费
      * @param senderadderss
      * @param recipientaddress
      * @param packprice
      * @return
      */
     public double calculateFreight(String destination);
     
     public double calculatePackingCharge();
    
     public String generateExpectedArrivalDate();

     public void VOtoPO();
     
     public OrderlineitemVO getOrderlineitemVO(String id);

	/**
      * 前置条件：已完成订单处理
      * 后置条件：结束本次订单处理，持久化更新涉及的领域对象的数据
      */
     public void endOrder();
     
     public void lineitemPOtolineitemVO(int k);
     
     public String generateDate();
}
