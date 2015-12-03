package dataservice.stockdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import bean.JavaBean1;
import po.stockPO.StorageListPO;
import state.ResultMessage;

public interface StorageListdataservice extends Remote{
	
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * ǰ����������������Ա�Ѿ�������������ⵥ����ֵ
	 * ��������������һ����ⵥ�����±䶯��PO
	 */
	public ResultMessage add(StorageListPO po);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ������:Ҫɾ���ĵ�����PO���м�¼
	 * ��������:ɾ��һ����ⵥ,����PO����
	 */
	public ResultMessage deleteOne(String id);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ��������Ҫɾ���ĵ�����PO���м�¼
	 * ����������ɾ�������ⵥ,����PO��¼
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
	 * ��������:�޸�һ����ⵥ�����������Ϣ��PO
	 */
	public ResultMessage update(StorageListPO po);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĵ�����PO���м�¼
	 * ��������������id��ѯĳ��ⵥ,������ⵥPO��Ϣ��ҵ���߼���
	 */
	public JavaBean1 findA(String id);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĵ�����PO���м�¼
	 * ��������������ʱ���ѯĳ��ⵥ,������ⵥPO��Ϣ
	 */
	public JavaBean1 findB(String date); 
	
}
