package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bean.JavaBean1;
import po.inforManagementPO.DriversPO;
import state.ResultMessage;

public interface DriversInfordataservice extends Remote{
	/**
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µ�˾����Ϣ
	 * @param po
	 * @return
	 */
	public ResultMessage add(DriversPO po) throws RemoteException;
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public JavaBean1 findA(String Id) throws RemoteException;
	
	public JavaBean1 findB(String city, String region) throws RemoteException;
	
	/**
	 * 
	 * @param ID
	 * @return
	 * ǰ��������Ҫɾ����˾����Ϣ��PO���м�¼
	 * ����������ɾ��һ����Ϣ��Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String Id) throws RemoteException;
	
	/**
	 * 
	 * @param IDs
	 * ǰ��������Ҫɾ����˾����Ϣ�ڳ־û��������м�¼
	 * ����������ɾ������˾����Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> Ids) throws RemoteException;
	
	/**
	 * 
	 * @param po
	 * @return
	 * ǰ��������Ҫ�޸ĵ�˾����Ϣ��PO���м�¼
	 * �����������޸�˾����Ϣ��������VO��PO
	 */
	public ResultMessage update(DriversPO po) throws RemoteException;
	
	public String generateID() throws RemoteException;
}
