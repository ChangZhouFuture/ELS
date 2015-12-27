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
	public JavaBean1 modify(OutBoundOrderVO outBoundOrderVO);
	
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

}
