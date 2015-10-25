package businesslogicservice_client.stockblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.OrderVO;
import vo_client.lineitemVO.OrderlineitemVO;
import vo_client.lineitemVO.stocklineitemVO.OutBoundOrderlineitemVO;
import vo_client.stockVO.OutBoundOrderVO;
/**
 * 
 * @author �ܳ�
 * �ýӿڴ�������ⵥ��ص�ҵ���߼�
 *
 */
public interface OutBoundOrderblservice {
	
	/**
	 * 
	 * @param id
	 * ǰ������������һ���½����޸ĳ��ⵥ�غ�
	 * �����������ڳ��ⵥ������һ�������ţ�����չʾ�����Ĳ�����Ϣ��LineItem��ʽ��
	 * 
	 */
	public OutBoundOrderlineitemVO addExpress(String id);
	
	/**
	 * ǰ����������������г��ⵥ��Ϣ
	 * �����������Զ���������ⵥid
	 */
	public void generateId();
	
	/**
	 * ǰ����������������г��ⵥ��Ϣ��������ʱ�䣩
	 * �����������Զ���������ɳ��ⵥ�����ں;���ʱ��
	 */
	public void generateTime();
		
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * ǰ����������������Ա�Ѿ����������г��ⵥ����ֵ
	 * ��������:����һ�����ⵥ�����±䶯��VO��PO����VO��Ϣ���ص�չʾ��
	 */
	public OutBoundOrderVO add(String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ��������Ҫɾ���ĳ��ⵥ�ڳ־û��������м�¼
	 * ����������ɾ��һ�����ⵥ
	 */
	public ResultMessage deleteone(String id4obo);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ��������Ҫɾ���ĳ��ⵥ�ڳ־û��������м�¼
	 * ����������ɾ��������ⵥ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4obo);
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * ǰ��������Ҫ�޸ĵĳ��ⵥ�ڳ־û��������м�¼
	 * �����������޸�һ�����ⵥ�����������Ϣ��VO��PO����VO��Ϣ���ص�չʾ��
	 */
	public OutBoundOrderVO modify(String id, String id4e, String id4to, String desti);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĳ��ⵥ�ڳ־û��������м�¼
	 * ��������������id��ѯĳ���ⵥ,���س��ⵥVO��Ϣ
	 */
	public OutBoundOrderVO inquireA(String id);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ����������������Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������ʱ���ѯĳ���ⵥ,���س��ⵥVO��Ϣ
	 */
	public OutBoundOrderVO inquireB(String time);
	
	/**
	 * 
	 * ǰ��������ҵ���Ѿ��������
	 * ���������������˴�����ⵥ��ص�ҵ�񣬳־û������漰��������������
	 */
	public void endOBO();


}
