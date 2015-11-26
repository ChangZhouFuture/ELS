package dataservice.documentsdataservice;

import java.util.ArrayList;

import po.documentsPO.ArrivalOrder4TranCenPO;
import po.lineitemPO.documentslineitemPO.ArrivalOrder4TranCenlineitemPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
 
/**
 * @author �쿡��
 * �ýӿ��ṩ����ת���ĵ��ﵥ��ص����ݲ㷽��
 */
public interface ArrivalOrder4TranCendataservice {
	
	public TransferOrderlineitemPO addTransferOrder(String id);
	
	/**
	 * ǰ�ã���ת����ҵ��Ա���������в���
	 * ���ã�����һ����ת���ĵ��ﵥ�����±䶯��PO
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @param tcid
	 * @return һ����ת���ĵ��ﵥ
	 */
	public ResultMessage addArrivalOrder4TranCen(ArrivalOrder4TranCenPO arrivalOrder4TranCenPO);
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ĵ��ﵥ��PO���м�¼
	 * ���ã�ɾ��һ����ת���ĵ��ﵥ������PO����
	 * @param id
	 * @return 
	 */
	public ResultMessage deleteOne(String id);
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�ɾ��һ����ת���ĵ��ﵥ������PO����
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ��PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥPO��Ϣ��ҵ���߼���
	 * @param id
	 * @return ��ת���ĵ��ﵥ��Ϣ
	 */
	public ArrayList<ArrivalOrder4TranCenPO> findA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ��PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥPO��Ϣ
	 * @param time
	 * @return ��ת���ĵ��ﵥ�б�
	 */
	public ArrayList<ArrivalOrder4TranCenPO> findB(String time);
	
	/**
	 * ���ã���ѯ������ת���ĵ��ﵥ
	 * @return
	 */
	public ArrayList<ArrivalOrder4TranCenPO> findC();
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û�������Ƶ�������������
	 */
	public ResultMessage update(ArrivalOrder4TranCenPO arrivalOrder4TranCenPO);
	
	public String generateId();
	
	public String generateStartAdd();
 }
