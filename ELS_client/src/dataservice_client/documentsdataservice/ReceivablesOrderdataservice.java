package dataservice_client.documentsdataservice;

import java.util.ArrayList;

import po_client.documentsPO.ReceivablesOrderPO;
import po_client.lineitemPO.documentslineitemPO.ReceivablesOrderlineitemPO;
import po_client.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;


public interface ReceivablesOrderdataservice {
	/**
	 * 
	 * @param date4RO
	 * @param amount4RO
	 * @param courier4RO
	 * @param barCode
	 * @return
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µ��տ��Ϣ
	 */
	public ResultMessage add(ReceivablesOrderPO receivablesOrderPO);
		
	/**
	 * 
	 * @param id
	 * @return
	 * ǰ��������Ҫɾ�����տ��Ϣ��PO���м�¼
	 * ����������ɾ��һ���տ��Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String id);

	/**
	 * 
	 * @param id4courier
	 * @param date
	 * ǰ��������Ҫɾ�����տ��Ϣ�ڳ־û��������м�¼
	 * ����������ɾ�������տ��Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList);
	
//	/**
//	 * 
//	 * @param id4courier
//	 * @param date
//	 * @return
//	 * ǰ��������Ҫ�޸ĵ��տ��Ϣ��PO���м�¼
//	 * �����������޸��տ��Ϣ��������VO��PO
//	 */
//	public ReceivablesOrderPO modify(String id4courier,String date);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * ǰ��������Ҫ��ѯ���տ��Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public ReceivablesOrderPO findA(String id);
	
	public ReceivablesOrderlineitemPO findB(String date);
	
	public ArrayList<OrderlineitemPO> generateOrder(String courierId);
	
	public double generateFreight();
	/**
	 * ǰ���������տ��Ϣ�������
	 * ������������������տ��Ϣ�����������ݳ־û�����
	 */
	public ResultMessage update(ReceivablesOrderPO receivablesOrderPO);
}
