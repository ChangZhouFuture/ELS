package dataservice.stockdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import bean.JavaBean1;
import po.lineitemPO.stocklineitemPO.OutBoundOrderlineitemPO;
import po.stockPO.OutBoundOrderPO;
import state.ResultMessage;
/**
 * 
 * @author �ܳ�
 * �ýӿ��ṩ����ⵥ��ص����ݲ㷽��
 */
public interface OutBoundOrderdataservice extends Remote{
		
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * ǰ����������������Ա�Ѿ����������г��ⵥ����ֵ
	 * ��������������һ�����ⵥ�����±䶯��PO
	 */
	public ResultMessage add(OutBoundOrderPO outBoundOrderPO);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ������:Ҫɾ���ĵ�����PO���м�¼
	 * ��������:ɾ��һ�����ⵥ,����PO����
	 */
	public ResultMessage deleteone(String id4obo);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ��������Ҫɾ���ĵ�����PO���м�¼
	 * ����������ɾ��������ⵥ,����PO��¼
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4obo);
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * ǰ��������Ҫ�޸ĵĳ��ⵥ��PO���м�¼
	 * ��������:�޸�һ�����ⵥ�����������Ϣ��PO
	 */
	public OutBoundOrderPO modify(String id, String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĵ�����PO���м�¼
	 * ��������������id��ѯĳ���ⵥ,���س��ⵥPO��Ϣ��ҵ���߼���
	 */
	public JavaBean1 findA(String id);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĵ�����PO���м�¼
	 * ��������������ʱ���ѯĳ���ⵥ,���س��ⵥPO��Ϣ
	 */
	public JavaBean1 findB(String time);
	
	/**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public void update();
}
