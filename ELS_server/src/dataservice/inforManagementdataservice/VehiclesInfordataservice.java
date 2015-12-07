package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bean.JavaBean1;
import po.inforManagementPO.VehiclesPO;
import state.ResultMessage;

public interface VehiclesInfordataservice extends Remote{
	/**
	 * 
	 * @param po
	 * @return
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µĳ�����Ϣ
	 */
	public ResultMessage add(VehiclesPO po) throws RemoteException;
		
	/**
	 * 
	 * @param Id
	 * @return
	 * ǰ��������Ҫɾ���ĳ�����Ϣ��PO���м�¼
	 * ����������ɾ��һ��������Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String Id) throws RemoteException;
	/**
	 * 
	 * @param Ids
	 * ǰ��������Ҫɾ���ĳ�����Ϣ�ڳ־û��������м�¼
	 * ����������ɾ������������Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> Ids) throws RemoteException;
	
	/**
	 * 
	 * @param Id
	 * @return
	 * ǰ��������Ҫ�޸ĵĳ�����Ϣ��PO���м�¼
	 * �����������޸ĳ�����Ϣ��������VO��PO
	 */
	public ResultMessage update(VehiclesPO po) throws RemoteException;
	
	/**
	 * 
	 * @param Id
	 * @return
	 * ǰ��������Ҫ��ѯ�ĳ�����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public JavaBean1 findA(String Id) throws RemoteException;
	
	public JavaBean1 findB() throws RemoteException;
	
	public String generateID() throws RemoteException;
}
