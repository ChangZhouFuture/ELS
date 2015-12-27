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
 * ���ദ���йض�����ҵ���߼�
 */

public interface Orderblservice {
     /**
      * ǰ������������һ�������غ�
      * ������������һ�������غ��У�����ļ�����Ϣ���ɶ���
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
	  * ȷ���ռ�������javabean1��ֻ�������Ϣ���ռ�ʱ�䣩
	  * @param id
	  * @param trueAddresseeName
	  * @return
	  */
	 public JavaBean1 receive(String id, String trueAddresseeName);
	 
     public ResultMessage deleteMany(ArrayList<String> idList);
     
     /**
      * ǰ��������ѡ��һ������
      * �����������޸�һ������������
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
      * ǰ������������һ���������
      * �����������鿴һ������������
      * @param orderid
      * @return
      */
     public JavaBean1 inquireA(String id);
     
     /**
      * ǰ������������һ������
      * �����������鿴һ����������
      * @param time
      * @return
      */
     public JavaBean1 inquireB(String date);

}
