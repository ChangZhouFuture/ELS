package dataservice_client.documentsdataservice;

import java.util.ArrayList;

import po_client.documentsPO.DeliveryOrderPO;
import po_client.lineitemPO.documentslineitemPO.DeliveryOrderlineitemPO;
import po_client.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;
/**
 * @author �쿡��
 * �ýӿ��ṩ���ɼ�����ص����ݲ㷽��
 */
 public interface DeliveryOrderdataservice {
 
	 public OrderlineitemPO addOrder(String id);
	 
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
	public ResultMessage addDeliveryOrder(DeliveryOrderPO deliveryOrderPO);
	
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
	
//	/**
//	 * ǰ�ã�Ҫ�޸ĵ��ɼ�����PO���м�¼
//	 * ���ã�����һ���ɼ���������PO�����Ϣ
//	 * @param id
//	 * @param orsderidlist
//	 * @param dn
//	 * @param did
//	 * @param d
//	 * @return ���ĺ���ɼ���
//	 */
//	public ResultMessage modify(DeliveryOrderPO deliveryOrderPO);
	/**
	 * ǰ�ã�Ҫ��ѯ���ɼ�����PO���м�¼
	 * ���ã�����ʱ���ѯĳ�ɼ���,�����ɼ���PO��Ϣ��ҵ���߼���
	 * @param id
	 * @return �ɼ�����Ϣ
	 */
	public DeliveryOrderPO findA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ���ɼ�����PO���м�¼
	 * ���ã�����ʱ���ѯĳ�ɼ���,�����ɼ���PO��Ϣ
	 * @param time
	 * @return �ɼ����б�
	 */
	public ArrayList<DeliveryOrderlineitemPO> findB(String time);
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û������漰��������������
	 */
	public ResultMessage update(DeliveryOrderPO deliveryOrderPO);
	
	
	
 }