package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.documentsPO.BusiHallArrivalOrderPO;
import po.lineitemPO.documentslineitemPO.BusiHallArrivalOrderlineitemPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;

/**
 * 
 * @author �쿡��
 * �ýӿ��ṩ��Ӫҵ�����ﵥ����ص����ݲ㷽��
 *
 */
 public interface BusiHallArrivalOrderdataservice extends Remote{
 
	 /**
		 * ǰ�ã�
		 * ���ã������ת��
		 * @param id
		 * @return
		 */
		 public TransferOrderlineitemPO addTransferOrder(String id);
		 
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
		public ResultMessage addBusiHallArrivalOrder(BusiHallArrivalOrderPO busiHallArrivalOrder);
		
		/**
		 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ��PO���м�¼
		 * ���ã�ɾ��һ��Ӫҵ�����ﵥ������PO����
		 * @param id
		 */
		public ResultMessage deleteOne(String id);
		
		/**
		 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ�ڳ־û��������м�¼
		 * ���ã�ɾ�����Ӫҵ�����ﵥ������PO����
		 * @param id
		 */
		public ResultMessage deleteMany(ArrayList<String> idlist);
		
		/**
		 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ��PO���м�¼
		 * ���ã�����id��ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥPO��Ϣ��ҵ���߼���
		 * @param id
		 * @return Ӫҵ�����ﵥ��Ϣ
		 */
		public ArrayList<BusiHallArrivalOrderPO> findA(String id);
		
		/**
		 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ��PO���м�¼
		 * ���ã�����ʱ���ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥPO��Ϣ
		 * @param time
		 * @return Ӫҵ�����ﵥ�б�
		 */
		public ArrayList<BusiHallArrivalOrderPO> findB(String time);
		
		/**
		 * ǰ�ã�
		 * ���ã���ѯ����Ӫҵ�����ﵥ
		 * @param time
		 * @return
		 */
		public ArrayList<BusiHallArrivalOrderPO> findC();
		
		/**
		 * ǰ�ã���Ϊ������Ѿ����
		 * ���ã��޸���ص���
		 */
		public ResultMessage update(BusiHallArrivalOrderPO busiHallArrivalOrder);
		
		public String generateStartAdd(String transferOrderId);
		
		public String generateId();
 }
