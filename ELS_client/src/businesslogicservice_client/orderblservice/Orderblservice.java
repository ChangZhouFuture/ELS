package businesslogicservice_client.orderblservice;

import state.ExpressType;
import vo_client.OrderVO;
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
	 public OrderVO add(String sender, String addressee, String desti, String startingPlace,
				ExpressType eType, String name, String id, int num);
	 
	 /**
	  * ǰ��������չ��һ�������б�
	  * �����������ڶ����б���ɾ��һ������
	  * @param orderid
	  */
     public void delete(String id);
     
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
     public OrderVO modify(String sender, String addressee, String desti, String startingPlace,
 			ExpressType eType, String name, String id, int num);
     
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
     public OrderVO inquireB(String date);
     
     /**
      * ǰ����������ɶ�����Ϣ����
      * ��������������һ���������������
      * @return
      */
     public void generateId();
     
     /**
      * ǰ����������ɶ�����Ϣ����
      * �������������ݶ�����Ϣ�����ܷ���
      * @param senderadderss
      * @param recipientaddress
      * @param packprice
      * @return
      */
     public double getTotalPrice(String startingPlace,String desti,ExpressType eType,int num);
    
     /**
      * ǰ������������ɶ�������
      * �����������������ζ��������־û������漰��������������
      */
     public void endOrder();
}
