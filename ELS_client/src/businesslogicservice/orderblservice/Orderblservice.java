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
	  * 确认收件，返回javabean1（只含结果信息和收件时间）
	  * @param id
	  * @param trueAddresseeName
	  * @return
	  */
	 public JavaBean1 receive(String id, String trueAddresseeName);
	 
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
     public JavaBean1 modify(OrderVO orderVO);
     
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

}
