package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import bean.JavaBean1;
import po.documentsPO.TransferOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ResultMessage;
import state.TransportType;

/**
 * @author �쿡��
 * �ýӿ��ṩ����ת����ص����ݲ㷽��
 */
 public interface TransferOrderdataservice extends Remote{
 
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
	public ResultMessage addTransferOrder(String id,TransportType tst,String sa,String ea,ArrayList<String> oidl,String d,String hbid,String hgid,String Jzy);
	
	/**
	 * ǰ�ã�Ҫɾ������ת����PO���м�¼
	 * ���ã�ɾ��һ����ת��������PO����
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * ǰ�ã�Ҫɾ������ת����PO���м�¼
	 * ���ã�ɾ�������ת��������PO����
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת����PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת��,������ת��PO��Ϣ��ҵ���߼���
	 * @param id
	 * @return ��ת����Ϣ
	 */
	public JavaBean1 findA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת����PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת��,������ת��PO��Ϣ
	 * @param time
	 * @return ��ת���б�
	 */
	public JavaBean1 findB(String time);
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û�������Ƶ�������������
	 */
	public ResultMessage update(TransferOrderPO transferOrderPO);
	
	public TransferOrderlineitemPO getTransferOrderlineitemPO();
	
	public String generateId();
 }
