package businesslogicservice.stockblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.stockVO.OutBoundOrderVO;
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
	public OrderlineitemVO addExpress(String expressID);
	
	/**
	 * ǰ����������������г��ⵥ��Ϣ
	 * �����������Զ���������ⵥid
	 */
	public String generateId();
	
	/**
	 * ǰ����������������г��ⵥ��Ϣ��������ʱ�䣩
	 * �����������Զ���������ɳ��ⵥ�����ں;���ʱ��
	 */
	public String generateTime();
		
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return 
	 * ǰ����������������Ա�Ѿ����������г��ⵥ����ֵ
	 * ��������:����һ�����ⵥ�����±䶯��VO��PO����VO��Ϣ���ص�չʾ��
	 */
	public JavaBean1 add(OutBoundOrderVO outBoundOrderVO);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ��������Ҫɾ���ĳ��ⵥ�ڳ־û��������м�¼
	 * ����������ɾ��һ�����ⵥ
	 */
	public ResultMessage deleteone(String ID);
	
	/**
	 * 
	 * @param id4obo
	 * ǰ��������Ҫɾ���ĳ��ⵥ�ڳ־û��������м�¼
	 * ����������ɾ��������ⵥ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> IDList);
	
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
	public ResultMessage modify(OutBoundOrderVO outBoundOrderVO);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ��������Ҫ��ѯ�ĳ��ⵥ�ڳ־û��������м�¼
	 * ��������������id��ѯĳ���ⵥ,���س��ⵥVO��Ϣ
	 */
	public JavaBean1 inquireA(String ID);
	
	/**
	 * 
	 * @param id
	 * @return 
	 * ǰ����������������Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������ʱ���ѯĳ���ⵥ,���س��ⵥVO��Ϣ
	 */
	public JavaBean1 inquireB(String date);
	
	/**
	 * 
	 * ǰ��������ҵ���Ѿ��������
	 * ���������������˴�����ⵥ��ص�ҵ�񣬳־û������漰��������������
	 */
	public void endOBO();


}
