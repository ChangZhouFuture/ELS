package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.DeliveryOrderPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
/**
 * @author �쿡��
 * �ýӿ��ṩ���ɼ�����ص����ݲ㷽��
 */
 public interface DeliveryOrderdataservice extends ParentDocumentsdataservice{
 
	 public OrderlineitemPO addOrder(String id) throws RemoteException;
	 
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
	public ResultMessage addDeliveryOrder(DeliveryOrderPO deliveryOrderPO) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫɾ�����ɼ�����PO�м�¼
	 * ���ã�ɾ��һ���ɼ���������PO����
	 * @param id
	 */
	public ResultMessage deleteone(String id) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫɾ�����ɼ�����PO���м�¼
	 * ���ã�ɾ������ɼ���������PO����
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist) throws RemoteException;
	
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
	public JavaBean1 findA(String id) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫ��ѯ���ɼ�����PO���м�¼
	 * ���ã�����ʱ���ѯĳ�ɼ���,�����ɼ���PO��Ϣ
	 * @param time
	 * @return �ɼ����б�
	 */
	public JavaBean1 findB(String time) throws RemoteException;
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û������漰��������������
	 */
	public ResultMessage update(DeliveryOrderPO deliveryOrderPO) throws RemoteException;
	
	public String generateId(String date) throws RemoteException;
	
 }