package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.TransferOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;

/**
 * @author �쿡��
 * �ýӿ��ṩ����ת����ص����ݲ㷽��
 */
 public interface TransferOrderdataservice extends ParentDocumentsdataservice{
 
	/**
	 * ǰ�ã���ת����ҵ��Ա���������в���
	 * ���ã�����һ����ת�������±䶯��PO
	 * @param id
	 * @param tst
	 * @param sa
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param hbid
	 * @param hgid
	 * @param Jzy
	 * @return һ����ת��
	 */
	public ResultMessage addTransferOrder(TransferOrderPO po) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫɾ������ת����PO���м�¼
	 * ���ã�ɾ��һ����ת��������PO����
	 * @param id
	 */
	public ResultMessage deleteOne(String id) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫɾ������ת����PO���м�¼
	 * ���ã�ɾ�������ת��������PO����
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת����PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת��,������ת��PO��Ϣ��ҵ���߼���
	 * @param id
	 * @return ��ת����Ϣ
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת����PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת��,������ת��PO��Ϣ
	 * @param time
	 * @return ��ת���б�
	 */
	public JavaBean1 findB(String date) throws RemoteException;
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û�������Ƶ�������������
	 */
	public ResultMessage update(TransferOrderPO po) throws RemoteException;


	public String generateId(String date,String trancenId) throws RemoteException;
	
	public TransferOrderlineitemPO getTransferOrderlineitemPO(String id) throws RemoteException;;
 }
