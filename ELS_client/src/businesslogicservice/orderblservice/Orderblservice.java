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
	  * ǰ��������չ��һ�������б�
	  * �����������ڶ����б���ɾ��һ������
	  * @param orderid
	  */
     public ResultMessage deleteOne(String id);
     
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
     public ResultMessage modify(OrderVO orderVO);
     
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
     
     /**
      * ǰ����������ɶ�����Ϣ����
      * ��������������һ���������������
      * @return
      */
     public String generateId();
     
     /**
      * ǰ����������ɶ�����Ϣ����
      * �������������ݶ�����Ϣ�����ܷ��� ���˷�+��װ��
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
      * ǰ������������ɶ�������
      * �����������������ζ��������־û������漰��������������
      */
     public void endOrder();
     
     public void lineitemPOtolineitemVO(int k);
     
     public String generateDate();
}
