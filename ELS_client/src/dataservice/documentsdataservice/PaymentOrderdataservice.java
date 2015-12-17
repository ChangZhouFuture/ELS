package dataservice.documentsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.documentsPO.PaymentOrderPO;
import po.inforManagementPO.BankAccountPO;
import state.ResultMessage;

public interface PaymentOrderdataservice extends ParentDocumentsdataservice{
	
	public BankAccountPO addPaymentAccount(String accountName) throws RemoteException;
	
	/**
	 * 
	 * @param date4PaymentOrder
	 * @param amount4PaymentOrder
	 * @param remitter
	 * @param account4PaymentOrder
	 * @param item4Vehicles
	 * @param remark1
	 * @param remark2
	 * @return
	 * ǰ��������������Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µĸ����Ϣ
	 */
	public ResultMessage add(PaymentOrderPO paymentOrderPO) throws RemoteException;
	/**
	 * 
	 * @param id
	 * @param bussinessHall
	 * @return
	 * ǰ��������Ҫɾ���ĸ����Ϣ��PO���м�¼
	 * ����������ɾ��һ�������Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String id) throws RemoteException;

	/**
	 * 
	 * @param bussinessHall
	 * @param date
	 * ǰ��������Ҫɾ�����տ��Ϣ�ڳ־û��������м�¼
	 * ����������ɾ�������տ��Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList) throws RemoteException;
	
//	/**
//	 * 
//	 * @param bussinessHall
//	 * @param date
//	 * @return
//	 * ǰ��������Ҫ�޸ĵĸ����Ϣ��PO���м�¼
//	 * �����������޸ĸ����Ϣ��������VO��PO
//	 */
//	public PaymentOrderPO modify(String bussinessHall,String date);
//	
	/**
	 * 
	 * @param keyword
	 * @return
	 * ǰ��������Ҫ��ѯ�ĸ����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public JavaBean1 findA(String id) throws RemoteException;
	
	public JavaBean1 findB(String date) throws RemoteException;
	
	/**
	 * ǰ�������������Ϣ�������
	 * ����������������θ����Ϣ�����������ݳ־û�����
	 */
	public ResultMessage update(PaymentOrderPO paymentOrderPO) throws RemoteException;
	
	public String generaId(String date)throws RemoteException;
}
