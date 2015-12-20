package dataservice.stockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.stockPO.StorageListPO;
import state.ResultMessage;

public interface StorageListdataservice extends ParentDocumentsdataservice{
	
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * ǰ����������������Ա�Ѿ�������������ⵥ����ֵ
	 * ��������������һ����ⵥ�����±䶯��PO
	 */
	public ResultMessage add(StorageListPO po) throws RemoteException;
	
	/**
	 * 
	 * @param id4obo
	 * ǰ������:Ҫɾ���ĵ�����PO���м�¼
	 * ��������:ɾ��һ����ⵥ,����PO����
	 */
	public ResultMessage deleteOne(String id) throws RemoteException;
	
	/**
	 * 
	 * @param id4obo
	 * ǰ��������Ҫɾ���ĵ�����PO���м�¼
	 * ����������ɾ�������ⵥ,����PO��¼
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList) throws RemoteException;
	
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
	public ResultMessage update(StorageListPO po) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĵ�����PO���м�¼
	 * ��������������id��ѯĳ��ⵥ,������ⵥPO��Ϣ��ҵ���߼���
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĵ�����PO���м�¼
	 * ��������������ʱ���ѯĳ��ⵥ,������ⵥPO��Ϣ
	 */
	public JavaBean1 findB(String date) throws RemoteException; 
	
	public String generateId(String date) throws RemoteException;
}
