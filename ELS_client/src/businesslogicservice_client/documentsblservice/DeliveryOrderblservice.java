package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.OrderVO;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;
import vo_client.userVO.CourierVO;
/**
 * 
 * @author �쿡��
 * �������ɼ�����ص�ҵ���߼�
 *
 */
public interface DeliveryOrderblservice {
	/**
	 * ͨ���ɼ�ԱID��ȡ�ɼ�Ա����
	 * @param id
	 * @return �ɼ�Ա������Ϣ
	 */
	public String getDeliverier(String id);
	
	/**
	 * �Ѵ��ɼ�������ҳ��
	 * �жϿ��Ա�Ƿ����
	 * @param id
	 * @return �Ƿ����
	 */
	public ResultMessage addDeliverier(String id);
	
	/**
	 * �Ѵ��ɼ�������ҳ��
	 * ���Ӷ���
	 * @param orderid
	 * @return 
	 */
	public ArrayList<String> addOrder(String orderid);
	
	/**
	 * �Ѵ��ɼ�������ҳ��
	 * ϵͳ�Զ���������
	 * @return ����
	 */
	public String getDate();
	
	/**
	 * ѡ�������ɼ���
	 * ����һ���ɼ���������VO��PO������VO��Ϣ��չʾ��
	 * @param id
	 * @param orsderidlist
	 * @param dn
	 * @param did
	 * @param d
	 * @return һ���ɼ���
	 */
	public DeliveryOrderVO addDeliveryOrder(String id,ArrayList<String> orsderidlist,String dn,String did,String d);
	
	/**
	 * ǰ�ã���ѡ�������ɼ��������������Ϣ
	 * �Զ������ɼ������
	 * @return �ɼ������
	 */
	public String generateId();
	
	/**
	 * ǰ�ã���ѡ����ĵ��ɼ���
	 * ����һ���ɼ���������VO��PO������VO��Ϣ��չʾ��
	 * @param dn
	 * @param d
	 * @param orsderidlist
	 * @param id
	 * @return ���ĺ���ɼ���
	 */
	public DeliveryOrderVO modify(String id,ArrayList<String> orsderidlist,String dn,String did,String d);
	
	/**
	 * ǰ�ã�����һ���ɼ��غ�
	 * ɾ��һ���ɼ���
	 * @param id
	 */
	public void deleteone(String id);
	
	/**
	 * ǰ�ã�����һ���ɼ��غ�
	 * ɾ������ɼ���
	 * @param id
	 */
	public void deleteMany(ArrayList<String> id);
	
	/**
	 * ǰ�ã�����һ���ɼ��غ�
	 * ͨ��ID����ĳ���ɼ���
	 * @param id
	 * @return �ɼ�����Ϣ
	 */
	public DeliveryOrderVO inquireA(String id);
	
	/**
	 * ǰ�ã�����һ���ɼ��غ�
	 * ��ʱ������ɼ����б�
	 * @param time
	 * @return �ɼ����б�
	 */
	public DeliveryOrderlineitemVO inquireB(String time);
	
	/**
	 * ǰ�ã���������ɾ�Ĳ����
	 * �����˴��ɼ��غϣ��־û�������Ƶ�������������
	 */
	public void end();
}
