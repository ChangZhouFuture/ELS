package dataservice_client.orderdataservice;

import po_client.OrderPO;
import state.ExpressType;

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
	public OrderPO add(String sender, String addressee, String desti, String startingPlace,
			ExpressType eType, String name, String id, int num);
	
	/**
	 * ǰ��������Ҫɾ���Ķ�����PO���м�¼
	 * ����������ɾ��һ������������PO
	 * @param orderid
	 */
    public void delete(String id);
    
    /**
     * ǰ��������Ҫ�޸ĵĶ�����PO���м�¼
     * �����������޸�һ�����������ݣ�����PO
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
    public OrderPO modify(String sender, String addressee, String desti, String startingPlace,
 			ExpressType eType, String name, String id, int num);
    
    /**
     * ǰ��������
     * ��������������id��ѯ����������po��Ϣ���߼���
     * @param id
     * @return
     */
    public OrderPO inquireA(String id);
    
    /**
     * ǰ��������
     * ��������������ʱ���ѯ����������po��Ϣ���߼���
     * @param id
     * @return
     */
    public OrderPO inquireB(String date);
    
    /**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public void update();

}
