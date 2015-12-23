package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.BusiHallArrivalOrderPO;
import state.ResultMessage;

/**
 * 
 * @author �쿡��
 * �ýӿ��ṩ��Ӫҵ�����ﵥ����ص����ݲ㷽��
 *
 */
 public interface BusiHallArrivalOrderdataservice extends ParentDocumentsdataservice{
 

		 
		/**
		 * ǰ�ã�Ӫҵ��ҵ��Ա���������в���
		 * ���ã�����һ��Ӫҵ�����ﵥ������PO
		 * @param id
		 * @param toid
		 * @param sa
		 * @param d
		 * @param gs 
		 * @return һ��Ӫҵ�����ﵥ
		 */
		public ResultMessage addBusiHallArrivalOrder(BusiHallArrivalOrderPO busiHallArrivalOrder)
		throws RemoteException;
		
		
		/**
		 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ�ڳ־û��������м�¼
		 * ���ã�ɾ�����Ӫҵ�����ﵥ������PO����
		 * @param id
		 */
		public ResultMessage deleteMany(ArrayList<String> idlist) throws RemoteException;
		
		/**
		 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ��PO���м�¼
		 * ���ã�����id��ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥPO��Ϣ��ҵ���߼���
		 * @param id
		 * @return Ӫҵ�����ﵥ��Ϣ
		 */
		public JavaBean1 findA(String id) throws RemoteException;
		
		/**
		 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ��PO���м�¼
		 * ���ã�����ʱ���ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥPO��Ϣ
		 * @param time
		 * @return Ӫҵ�����ﵥ�б�
		 */
		public JavaBean1 findB(String time) throws RemoteException;
	
		
		/**
		 * ǰ�ã���Ϊ������Ѿ����
		 * ���ã��޸���ص���
		 */
		public ResultMessage update(BusiHallArrivalOrderPO busiHallArrivalOrder) throws
		RemoteException;
		
		public String generateStartAdd(String transferOrderId) throws RemoteException;
		
		public String generateId(String date) throws RemoteException;
 }
