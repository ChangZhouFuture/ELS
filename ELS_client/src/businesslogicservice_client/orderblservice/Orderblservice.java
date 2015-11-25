package businesslogicservice_client.orderblservice;

import java.util.ArrayList;

import state.ExpressType;
import state.ResultMessage;
import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo_client.orderVO.OrderVO;
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
	 public ResultMessage add(OrderVO orderVO);
	 
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
     public OrderVO inquireA(String id);
     
     /**
      * ǰ������������һ������
      * �����������鿴һ����������
      * @param time
      * @return
      */
     public ArrayList<OrderlineitemVO> inquireB(String date);
     
     /**
      * ǰ����������ɶ�����Ϣ����
      * ��������������һ���������������
      * @return
      */
     public void generateId();
     
     /**
      * ǰ����������ɶ�����Ϣ����
      * �������������ݶ�����Ϣ�����ܷ��� ���˷�+��װ��
      * @param senderadderss
      * @param recipientaddress
      * @param packprice
      * @return
      */
     public void calculateTotalPrice();
    
     public void generateExpectedArrivalDate();

     public OrderlineitemVO getOrderlineitemVO(String id);

	/**
      * ǰ������������ɶ�������
      * �����������������ζ��������־û������漰��������������
      */
     public void endOrder();
}
