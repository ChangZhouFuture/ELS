package dataservice_server.documentsdataservice;

import java.util.ArrayList;

import po_server.documentsPO.ArrivalOrder4BusiHallPO;
import po_server.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;

public interface ArrivalOrder4BusiHalldataservice {
	
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
		public ResultMessage addArrivalOrder4BusiHall(ArrivalOrder4BusiHallPO arrivalOrder4BusiHallPO);
		
		/**
		 * ǰ�ã�Ҫ�޸ĵ�Ӫҵ�����ﵥ��PO���м�¼
		 * ���ã�����һ��Ӫҵ�����ﵥ������PO�����Ϣ
		 * @param id
		 * @param toid
		 * @param sa
		 * @param d
		 * @param gs
		 * @return ���ĺ��Ӫҵ�����ﵥ
		 */
		public ResultMessage update(ArrivalOrder4BusiHallPO arrivalOrder4BusiHallPO);
		
		/**
		 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ��PO���м�¼
		 * ���ã�ɾ��һ��Ӫҵ�����ﵥ������PO����
		 * @param id
		 */
		public ResultMessage deleteone(String id);
		
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
		public ArrivalOrder4BusiHallPO findA(String id);
		
		/**
		 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ��PO���м�¼
		 * ���ã�����ʱ���ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥPO��Ϣ
		 * @param time
		 * @return Ӫҵ�����ﵥ�б�
		 */
		public ArrayList<ArrivalOrder4BusiHallPO> findB(String time);//****-**-** 
		
		/**
		 * ǰ�ã�
		 * ���ã���ѯ����Ӫҵ�����ﵥ
		 * @param time
		 * @return
		 */
		public ArrayList<ArrivalOrder4BusiHallPO> findC();
		
		
}
