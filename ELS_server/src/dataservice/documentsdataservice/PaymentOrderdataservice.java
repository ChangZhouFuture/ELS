package dataservice.documentsdataservice;

import java.util.ArrayList;

import po.documentsPO.PaymentOrderPO;
import po.inforManagementPO.BankAccountPO;
import po.lineitemPO.documentslineitemPO.PaymentOrderlineitemPO;
import state.ResultMessage;

public interface PaymentOrderdataservice {
	
	public BankAccountPO addPaymentAccount(String accountName);
	
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
	public ResultMessage add(PaymentOrderPO paymentOrderPO);
	/**
	 * 
	 * @param id
	 * @param bussinessHall
	 * @return
	 * ǰ��������Ҫɾ���ĸ����Ϣ��PO���м�¼
	 * ����������ɾ��һ�������Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String id);

	/**
	 * 
	 * @param bussinessHall
	 * @param date
	 * ǰ��������Ҫɾ�����տ��Ϣ�ڳ־û��������м�¼
	 * ����������ɾ�������տ��Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList);
	
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
	public PaymentOrderPO findA(String id);
	
	public ArrayList<PaymentOrderlineitemPO> findB(String date);
	
	/**
	 * ǰ�������������Ϣ�������
	 * ����������������θ����Ϣ�����������ݳ־û�����
	 */
	public ResultMessage update(PaymentOrderPO paymentOrderPO);
	
	public String generaId();
}
