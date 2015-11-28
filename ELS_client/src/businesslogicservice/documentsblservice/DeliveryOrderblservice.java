package businesslogicservice.documentsblservice;

import java.util.ArrayList;

import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.lineitemVO.userlineitemVO.SenderlineitemVO;
 /**
  * 
  * @author �쿡��
  * �������ɼ�����ص�ҵ���߼�
  *
  */
 public interface DeliveryOrderblservice {
 	/**
 	 * ǰ�ã�Ҫ��ӵ��ɼ��������ݳ־û��������м�¼
 	 * ���ã�����ɼ��ˣ����ؿ��ԱlineitemVO��չʾ��
 	 * @param id
 	 * @return
 	 */
 	public SenderlineitemVO addDeliverier(String id);
 	
 	/**
 	 * ǰ�ã�����һ���½����޸��ɼ����غ�
 	 * ���ã����ɼ���������һ�������ţ�����չʾ�㶩��lineitem����
 	 * @param orderid
 	 * @return 
 	 */
 	public OrderlineitemVO addOrder(String orderid);
 	
 	/**
 	 * ǰ�ã��Ѵ��ɼ�������ҳ��
 	 * ���ã��Զ������ɼ�������
 	 * @return ����
 	 */
 	public String generateDate();
 	
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
 	public DeliveryOrderVO addDeliveryOrder(String id,ArrayList<String> orsderidlist,String dn,String did,String d);
 	
 	/**
 	 * ǰ�ã�����������ɼ�����Ϣ
 	 * ���ã��Զ������ɼ������
 	 * @return �ɼ������
 	 */
 	public void generateId();
 	
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
 	public DeliveryOrderVO modify(String id,ArrayList<String> orsderidlist,String dn,String did,String d);
 	
 	/**
 	 * ǰ�ã�Ҫɾ�����ɼ����ڳ־û��������м�¼
 	 * ���ã�ɾ��һ���ɼ���
 	 * @param id
 	 */

 	public ResultMessage deleteone(String id);
 	
 	/**
 	 * ǰ�ã�Ҫɾ�����ɼ����ڳ־û��������м�¼
 	 * ���ã�ɾ������ɼ���
 	 * @param id
 	 */
 	public ResultMessage deleteMany(ArrayList<String> idlist);
 	
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
 	
 	/**
 	 * ǰ�ã�ҵ���Ѿ��������
 	 * ���ã������˴��ɼ��غϣ��־û�������Ƶ�������������
 	 */
 	public void end();
}
