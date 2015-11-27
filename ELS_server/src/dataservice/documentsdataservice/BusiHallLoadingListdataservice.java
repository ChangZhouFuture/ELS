package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.documentsPO.BusiHallLoadingListPO;
import po.lineitemPO.documentslineitemPO.BusiHallLoadingListlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;

/**
 * @author �쿡��
 * �ýӿ��ṩ��װ������ص����ݲ㷽��
 */
 public interface BusiHallLoadingListdataservice extends Remote{
 
	 public OrderlineitemPO addOrder(String id);
	 
	/**
	 * ǰ�ã�Ӫҵ��ҵ��Ա���������в���
	 * ���ã�����һ��װ���������±䶯��PO
	 */
	public ResultMessage addLoadingList(BusiHallLoadingListPO loadingListPO);
	

	/**
	 * ǰ�ã�Ҫɾ����װ������PO���м�¼
	 * ���ã�ɾ��һ��װ����������PO����
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * ǰ�ã�Ҫɾ����װ������PO���м�¼
	 * ���ã�ɾ�����װ����������PO����
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * ǰ�ã�Ҫ��ѯ��װ������PO���м�¼
	 * ���ã�����ʱ���ѯĳװ����,����װ����PO��Ϣ��ҵ���߼���
	 * @param id
	 * @return װ������Ϣ
	 */
	public BusiHallLoadingListPO findA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ��װ������PO���м�¼
	 * ���ã�����ʱ���ѯĳװ����,����װ����PO��Ϣ
	 * @param time
	 * @return װ�����б�
	 */
	public BusiHallLoadingListlineitemPO findB(String time);
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û�������Ƶ�������������
	 */
	public ResultMessage update(BusiHallLoadingListPO loadingListPO);
	
	public String generateId();
	
 }
