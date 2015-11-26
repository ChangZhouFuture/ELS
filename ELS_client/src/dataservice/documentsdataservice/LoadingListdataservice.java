package dataservice.documentsdataservice;

import java.util.ArrayList;

import po.documentsPO.LoadingListPO;
import po.lineitemPO.documentslineitemPO.LoadingListlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;

/**
 * @author �쿡��
 * �ýӿ��ṩ��װ������ص����ݲ㷽��
 */
 public interface LoadingListdataservice {
 
	 public OrderlineitemPO addOrder(String id);
	 
	/**
	 * ǰ�ã�Ӫҵ��ҵ��Ա���������в���
	 * ���ã�����һ��װ���������±䶯��PO
     * @param id
	 * @param bhid
	 * @param tlid
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param vid
	 * @param f
	 * @param Jzy
	 * @param Yyy
	 * @return һ��װ����
	 */
	public ResultMessage addLoadingList(LoadingListPO loadingListPO);
	
//	/**
//	 * ǰ�ã�Ҫ�޸ĵ�װ������PO���м�¼
//	 * ���ã�����һ��װ����������PO�����Ϣ
//	 * @param id
//	 * @param bhid
//	 * @param tlid
//	 * @param ea
//	 * @param orderidlist
//	 * @param d
//	 * @param vid
//	 * @param f
//	 * @param Jzy
//	 * @param Yyy
//	 * @return ���ĺ��װ����
//	 */
//	public LoadingListPO modify(String id,String bhid,String tlid,String ea,ArrayList<String> orderidlist,String d,String vid,int f,String Jzy,String Yyy);
	
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
	public LoadingListPO findA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ��װ������PO���м�¼
	 * ���ã�����ʱ���ѯĳװ����,����װ����PO��Ϣ
	 * @param time
	 * @return װ�����б�
	 */
	public LoadingListlineitemPO findB(String time);
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û�������Ƶ�������������
	 */
	public ResultMessage update(LoadingListPO loadingListPO);
	
	public String generateId();
	
 }
