package dataservice_client.stockdataservice;

import java.util.ArrayList;
import po_client.lineitemPO.stocklineitemPO.StorageListlineitemPO;
import po_client.stockPO.StorageListPO;
import state.ResultMessage;

public interface StorageListdataservice {
	
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * ǰ����������������Ա�Ѿ�������������ⵥ����ֵ
	 * ��������������һ����ⵥ�����±䶯��PO
	 */
	public StorageListPO add(String id4obo, String time, String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ������:Ҫɾ���ĵ�����PO���м�¼
	 * ��������:ɾ��һ����ⵥ,����PO����
	 */
	public ResultMessage deleteone(String id4obo);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ��������Ҫɾ���ĵ�����PO���м�¼
	 * ����������ɾ�������ⵥ,����PO��¼
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4obo);
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * ǰ��������Ҫ�޸ĵĳ��ⵥ��PO���м�¼
	 * ��������:�޸�һ����ⵥ�����������Ϣ��PO
	 */
	public StorageListPO modify(String id, String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĵ�����PO���м�¼
	 * ��������������id��ѯĳ��ⵥ,������ⵥPO��Ϣ��ҵ���߼���
	 */
	public StorageListPO inquireA(String id);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĵ�����PO���м�¼
	 * ��������������ʱ���ѯĳ��ⵥ,������ⵥPO��Ϣ
	 */
	public StorageListlineitemPO inquireB(String time);
	
	/**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public void update();
}
