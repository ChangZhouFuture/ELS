package dataservice.stockdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import bean.JavaBean1;
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
	public ResultMessage add(OutBoundOrderPO po);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ������:Ҫɾ���ĵ�����PO���м�¼
	 * ��������:ɾ��һ�����ⵥ,����PO����
	 */
	public ResultMessage deleteOne(String id);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ��������Ҫɾ���ĵ�����PO���м�¼
	 * ����������ɾ��������ⵥ,����PO��¼
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList);
	
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
	public ResultMessage update(OutBoundOrderPO po);
	
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
	public JavaBean1 findB(String date);
	
;
}
