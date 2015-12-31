package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import bean.JavaBean1;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.orderPO.OrderPO;
import state.ResultMessage;

public interface Orderdataservice extends ParentDocumentsdataservice{
	/**
	 * ǰ���������������ж�������
     * ��������������һ������������ͬ����PO
	 * @param sender
	 * @param addressee
	 * @param desti
	 * @param startingPlace
	 * @param eType
	 * @param name
	 * @param id
	 * @param num
	 * @return
	 */
	public ResultMessage add(OrderPO orderPO) throws RemoteException;
    
    public ResultMessage deleteMany(ArrayList<String> idList) throws RemoteException;
	
    /**
     * ǰ��������
     * ��������������id��ѯ����������po��Ϣ���߼���
     * @param id
     * @return
     */
    public JavaBean1 findA(String id) throws RemoteException;
    
    /**
     * ǰ��������
     * ��������������ʱ���ѯ����������po��Ϣ���߼���
     * @param id
     * @return
     */
    public JavaBean1 findB(String date) throws RemoteException;
    
    /**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public ResultMessage update(OrderPO orderPO) throws RemoteException;
	
	public ResultMessage receive(String id,String date,String trueAddresseeName) throws RemoteException;
	
	public OrderlineitemPO getOrderlineitemPO(String id) throws RemoteException;
	
	public String generateId(String date) throws RemoteException;

	public String expectedArrivalDate(String date,String senderAdd,String addresseeAdd) throws RemoteException, ParseException;//����Ϊ������������
	
	public double getOrderAmount(String orderID) throws RemoteException;
}
