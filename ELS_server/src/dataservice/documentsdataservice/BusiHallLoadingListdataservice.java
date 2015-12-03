package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import bean.JavaBean1;
import po.documentsPO.BusiHallLoadingListPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
/**
 * @author �쿡��
 * �ýӿ��ṩ��װ������ص����ݲ㷽��
 */
 public interface BusiHallLoadingListdataservice extends Remote{
 
	 public OrderlineitemPO addOrder(String id) throws RemoteException;
	 
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
	public ResultMessage addLoadingList(BusiHallLoadingListPO loadingListPO) throws
	RemoteException;
	
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
	public ResultMessage deleteone(String id) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫɾ����װ������PO���м�¼
	 * ���ã�ɾ�����װ����������PO����
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫ��ѯ��װ������PO���м�¼
	 * ���ã�����ʱ���ѯĳװ����,����װ����PO��Ϣ��ҵ���߼���
	 * @param id
	 * @return װ������Ϣ
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	/**
	 * ǰ�ã�Ҫ��ѯ��װ������PO���м�¼
	 * ���ã�����ʱ���ѯĳװ����,����װ����PO��Ϣ
	 * @param time
	 * @return װ�����б�
	 */
	public JavaBean1 findB(String time) throws RemoteException;
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û�������Ƶ�������������
	 */
	public ResultMessage update(BusiHallLoadingListPO loadingListPO) throws RemoteException;
	
	public String generateId(String date) throws RemoteException;
	
 }
