package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.TranCenArrivalOrderPO;
import state.ResultMessage;
 
/**
 * @author �쿡��
 * �ýӿ��ṩ����ת���ĵ��ﵥ��ص����ݲ㷽��
 */
public interface TranCenArrivalOrderdataservice extends ParentDocumentsdataservice{
	
	
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
	public ResultMessage addTranCenArrivalOrder(TranCenArrivalOrderPO tanCenArrivalOrderPO)
	throws RemoteException;
	
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�ɾ��һ����ת���ĵ��ﵥ������PO����
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist) throws RemoteException; 
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ��PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥPO��Ϣ��ҵ���߼���
	 * @param id
	 * @return ��ת���ĵ��ﵥ��Ϣ
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ��PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥPO��Ϣ
	 * @param time
	 * @return ��ת���ĵ��ﵥ�б�
	 */
	public JavaBean1 findB(String time) throws RemoteException;
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û�������Ƶ�������������
	 */
	public ResultMessage update(TranCenArrivalOrderPO tranCenArrivalOrderPO) throws 
	RemoteException;
	
	public String generateId(String date) throws RemoteException;
	
	public String generateStartAdd(String transferOrderId) throws RemoteException;
 }
