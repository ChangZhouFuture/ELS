package dataservice_client.documentsdataservice;

import java.util.ArrayList;
import po_client.documentsPO.DeliveryOrderPO;
import po_client.lineitemPO.documentslineitemPO.DeliveryOrderlineitemPO;
import state.ResultMessage;
/**
 * @author �쿡��
 * �ýӿ��ṩ���ɼ�����ص����ݲ㷽��
 */
 public interface DeliveryOrderdataservice {
 
	/**
	 * ǰ�ã�Ӫҵ��ҵ��Ա���������в���
	 * ���ã�����һ���ɼ��������±䶯��PO
	 * @param id
	 * @param orsderidlist
	 * @param dn
	 * @param did
	 * @param d
	 * @return һ���ɼ���
	 */
	public DeliveryOrderPO addDeliveryOrder(String id,ArrayList<String> orsderidlist,String dn,String did,String d);
	
	/**
	 * ǰ�ã�Ҫɾ�����ɼ�����PO�м�¼
	 * ���ã�ɾ��һ���ɼ���������PO����
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * ǰ�ã�Ҫɾ�����ɼ�����PO���м�¼
	 * ���ã�ɾ������ɼ���������PO����
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * ǰ�ã�Ҫ�޸ĵ��ɼ�����PO���м�¼
	 * ���ã�����һ���ɼ���������PO�����Ϣ
	 * @param id
	 * @param orsderidlist
	 * @param dn
	 * @param did
	 * @param d
	 * @return ���ĺ���ɼ���
	 */
	public DeliveryOrderPO modify(String id,ArrayList<String> orsderidlist,String dn,String did,String d);
	/**
	 * ǰ�ã�Ҫ��ѯ���ɼ�����PO���м�¼
	 * ���ã�����ʱ���ѯĳ�ɼ���,�����ɼ���PO��Ϣ��ҵ���߼���
	 * @param id
	 * @return �ɼ�����Ϣ
	 */
	public DeliveryOrderPO inquireA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ���ɼ�����PO���м�¼
	 * ���ã�����ʱ���ѯĳ�ɼ���,�����ɼ���PO��Ϣ
	 * @param time
	 * @return �ɼ����б�
	 */
	public DeliveryOrderlineitemPO inquireB(String time);
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û������漰��������������
	 */
	public void update();
 }