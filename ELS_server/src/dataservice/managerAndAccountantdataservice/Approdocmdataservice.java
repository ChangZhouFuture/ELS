package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * �ýӿ��ṩ����������ص����ݲ㷽��
 * @author zt
 *
 */
public interface Approdocmdataservice extends Remote{

	/**
	 * ǰ�����������ݲ��в�ѯ�Ķ�Ӧid�ĵ���
	 * ��������������һ�����ݵ����ݸ��߼���
	 * @param id
	 * @return
	 */
	public Object inquireA(String id) throws RemoteException;
	
	/**
	 * ǰ��������
	 * ��������������һ�ֵ����б���߼���
	 * @param kind
	 * @return
	 */
	public Object inquireB(String kind) throws RemoteException;
	
	/**
	 * ǰ��������
	 * ��������������ĳһ�յĵ����б���߼���
	 * @param kind
	 * @return
	 */
	public Object inquireC(String date) throws RemoteException;
	
	
	/**
	 * ǰ��������Ҫ�޸ĵĵ��������ݲ���
	 * �����������޸�ĳһ����
	 * @return
	 */
	public Object modify() throws RemoteException;
	
	/**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public void updateApproState(String ordername,String id) throws RemoteException;

}
