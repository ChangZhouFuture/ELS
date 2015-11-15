package dataservice_client.stockdataservice;

import java.util.ArrayList;
import po_client.lineitemPO.stocklineitemPO.OutBoundOrderlineitemPO;
import po_client.stockPO.OutBoundOrderPO;
import state.ResultMessage;
/**
 * 
 * @author �ܳ�
 * �ýӿ��ṩ����ⵥ��ص����ݲ㷽��
 */
public interface OutBoundOrderdataservice {
		
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * ǰ����������������Ա�Ѿ����������г��ⵥ����ֵ
	 * ��������������һ�����ⵥ�����±䶯��PO
	 */
	public OutBoundOrderPO add(String id4obo, String time, String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ������:Ҫɾ���ĵ�����PO���м�¼
	 * ��������:ɾ��һ�����ⵥ,����PO����
	 */
	public ResultMessage deleteone(String id4obo);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ��������Ҫɾ���ĵ�����PO���м�¼
	 * ����������ɾ��������ⵥ,����PO��¼
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
	 * ��������:�޸�һ�����ⵥ�����������Ϣ��PO
	 */
	public OutBoundOrderPO modify(String id, String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĵ�����PO���м�¼
	 * ��������������id��ѯĳ���ⵥ,���س��ⵥPO��Ϣ��ҵ���߼���
	 */
	public OutBoundOrderPO inquireA(String id);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĵ�����PO���м�¼
	 * ��������������ʱ���ѯĳ���ⵥ,���س��ⵥPO��Ϣ
	 */
	public OutBoundOrderlineitemPO inquireB(String time);
	
	/**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public void update();
}
