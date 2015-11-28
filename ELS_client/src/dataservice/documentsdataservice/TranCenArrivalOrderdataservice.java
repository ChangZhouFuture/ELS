package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import bean.JavaBean1;
import po.documentsPO.TranCenArrivalOrderPO;
import po.lineitemPO.documentslineitemPO.TranCenArrivalOrderlineitemPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
 
/**
 * @author �쿡��
 * �ýӿ��ṩ����ת���ĵ��ﵥ��ص����ݲ㷽��
 */
public interface TranCenArrivalOrderdataservice extends Remote{
	
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
	public ResultMessage addTranCenArrivalOrder(TranCenArrivalOrderPO tanCenArrivalOrderPO);
	
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
	public JavaBean1 findA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ��PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥPO��Ϣ
	 * @param time
	 * @return ��ת���ĵ��ﵥ�б�
	 */
	public JavaBean1 findB(String time);
	
	/**
	 * ���ã���ѯ������ת���ĵ��ﵥ
	 * @return
	 */
	public ArrayList<TranCenArrivalOrderPO> findC();
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û�������Ƶ�������������
	 */
	public ResultMessage update(TranCenArrivalOrderPO tranCenArrivalOrderPO);
	
	public String generateId();
	
	public String generateStartAdd();
 }
