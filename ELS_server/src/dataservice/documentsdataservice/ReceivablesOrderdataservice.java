package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.ReceivablesOrderPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;


public interface ReceivablesOrderdataservice extends ParentDocumentsdataservice{
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
	public ResultMessage add(ReceivablesOrderPO receivablesOrderPO) throws 
	RemoteException;

	/**
	 * 
	 * @param id4courier
	 * @param date
	 * ǰ��������Ҫɾ�����տ��Ϣ�ڳ־û��������м�¼
	 * ����������ɾ�������տ��Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList) throws RemoteException;
	
	
	/**
	 * 
	 * @param keyword 
	 * @return
	 * ǰ��������Ҫ��ѯ���տ��Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	public JavaBean1 findB(String date) throws RemoteException;

	public JavaBean1 findC(String busiHallID) throws RemoteException;

	/**
	 * ǰ���������տ��Ϣ������� 
	 * ������������������տ��Ϣ�����������ݳ־û�����
	 */
	public ResultMessage update(ReceivablesOrderPO receivablesOrderPO) throws RemoteException;
	
	public double generateAmount(ArrayList<String> orderIdList)  throws RemoteException;
	
	public String generateId(String date) throws RemoteException;
}
