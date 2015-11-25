package dataservice_client.orderdataservice;

import java.util.ArrayList;

import po_client.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po_client.orderPO.OrderPO;
import state.ExpressType;
import state.ResultMessage;

public interface Orderdataservice {
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
	public OrderPO add(OrderPO orderPO);
	
	/**
	 * ǰ��������Ҫɾ���Ķ�����PO���м�¼
	 * ����������ɾ��һ������������PO
	 * @param orderid
	 */
    public ResultMessage deleteOne(String id);
    
    public ResultMessage deleteMany(ArrayList<String> idList);
	
    /**
     * ǰ��������
     * ��������������id��ѯ����������po��Ϣ���߼���
     * @param id
     * @return
     */
    public OrderPO findA(String id);
    
    /**
     * ǰ��������
     * ��������������ʱ���ѯ����������po��Ϣ���߼���
     * @param id
     * @return
     */
    public ArrayList<OrderlineitemPO> findB(String date);
    
    /**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public ResultMessage update(OrderPO orderPO);
	
	public OrderlineitemPO getOrderlineitemPO(String id);
	
	public void generateId();

}
