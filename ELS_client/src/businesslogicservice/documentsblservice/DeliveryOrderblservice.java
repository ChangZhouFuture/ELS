package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
 /**
  * 
  * @author �쿡��
  * �������ɼ�����ص�ҵ���߼�
  *
  */
 public interface DeliveryOrderblservice {
 	
 	/**
 	 * ǰ�ã�����һ���½����޸��ɼ����غ�
 	 * ���ã����ɼ���������һ�������ţ�����չʾ�㶩��lineitem����
 	 * @param orderid
 	 * @return 
 	 */
 	public OrderlineitemVO addOrder(String orderID);
 	
 	/**
 	 * ǰ�ã�Ӫҵ��ҵ��Ա���������в���
 	 * ���ã�����һ���ɼ���������VO��PO������VO��Ϣ��չʾ��
 	 * @param id
 	 * @param orsderidlist
 	 * @param dn
 	 * @param did
 	 * @param d
 	 * @return һ���ɼ���
 	 */
 	public JavaBean1 addDeliveryOrder(DeliveryOrderVO deliveryOrderVO);
 	
 	/**
 	 * ǰ�ã�Ҫ�޸ĵ��ɼ����ڳ־û��������м�¼
 	 * ���ã�����һ���ɼ���������VO��PO������VO��Ϣ��չʾ��
 	 * @param id
 	 * @param orsderidlist
 	 * @param dn
 	 * @param did
 	 * @param d
 	 * @return ���ĺ���ɼ���
 	 */
 	public ResultMessage modify(DeliveryOrderVO deliveryOrderVO);
 	
 	/**
 	 * ǰ�ã�Ҫɾ�����ɼ����ڳ־û��������м�¼
 	 * ���ã�ɾ������ɼ���
 	 * @param id
 	 */
 	public ResultMessage deleteMany(ArrayList<String> idList);
 	
 	/**
 	 * ǰ�ã�Ҫ��ѯ���ɼ����ڳ־û��������м�¼
 	 * ���ã�����id��ѯĳ�ɼ���,�����ɼ���VO��Ϣ
 	 * @param id
 	 * @return �ɼ�����Ϣ
 	 */
 	public JavaBean1 inquireA(String id);
 	
 	/**
 	 * ǰ�ã�Ҫ��ѯ���ɼ����ڳ־û��������м�¼
 	 * ���ã�����ʱ���ѯĳ�ɼ���,�����ɼ���lineitemVO��Ϣ
 	 * @param time
 	 * @return �ɼ����б�
 	 */
 	public JavaBean1 inquireB(String time);
 	
}
