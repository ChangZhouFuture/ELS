package businesslogicservice_client.stockblservice;

import java.util.ArrayList;

import vo_client.OrderVO;
import vo_client.stockVO.OutBoundOrderVO;
/**
 * 
 * @author �ܳ�
 * ���ദ������ⵥ��ص�ҵ���߼�
 *
 */
public interface OutBoundOrderblservice {
	
	/**
	 * 
	 * @param id
	 * @return �ڳ��ⵥ������һ�������ţ�����չʾ�����Ĳ�����Ϣ��LineItem��ʽ��
	 */
	public OrderVO addExpress(String id);
	
	/**
	 * �Զ���������ⵥid
	 */
	public void generateId();
	
	/**
	 * �Զ���������ɳ��ⵥ������
	 */
	public void generateTime();
		
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return ����һ�����ⵥ�����±䶯��VO��PO����VO��Ϣ���ص�չʾ��
	 */
	public OutBoundOrderVO add(String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id4obo
	 * ɾ��һ�����ⵥ
	 */
	public void deleteone(String id4obo);
	
	/**
	 * 
	 * @param id4obo
	 * ɾ��������ⵥ
	 */ 
	public void deleteMany(ArrayList<String> id4obo);
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return �޸�һ�����ⵥ�����������Ϣ��VO��PO����VO��Ϣ���ص�չʾ��
	 */
	public OutBoundOrderVO modify(String id, String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id
	 * @return ����id��ѯĳ���ⵥ,���س��ⵥVO��Ϣ
	 */
	public OutBoundOrderVO inquireA(String id);
	
	/**
	 * 
	 * @param id
	 * @return ����ʱ���ѯĳ���ⵥ,���س��ⵥVO��Ϣ
	 */
	public OutBoundOrderVO inquireB(String time);
	
	/**
	 * 
	 * �����˴�����ⵥ��ص�ҵ�񣬳־û������漰��������������
	 */
	public void endOBO();


}
