package businesslogicservice.stockblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.stockVO.StorageListVO;
/**
 * 
 * @author �ܳ�
 * ���ദ������ⵥ��ص�ҵ���߼�
 *
 */
public interface StorageListblservice {
	/**
	 * 
	 * @param id
	 * @return ����ⵥ������һ�������ţ�����չʾ�����Ĳ�����Ϣ��LineItem��ʽ��
	 */
	public OrderlineitemVO addExpress(String id);
	
	/**
	 * �Զ��������ⵥid
	 */
	public void generateId();
	
	/**
	 * �Զ������������ⵥ������
	 */
	public void generateTime();
		
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return ����һ����ⵥ�����±䶯��PO����VO��Ϣ���ص�չʾ��
	 */
	public StorageListVO add(String desti, String dis, String row, String she, 
			String pos);
	
	/**
	 * 
	 * @param id4obo
	 * ɾ��һ����ⵥ
	 */
	public ResultMessage deleteone(String id4obo);
	
	/**
	 * 
	 * @param id4obo
	 * ɾ�������ⵥ
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4obo);
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return �޸�һ����ⵥ�����������Ϣ��VO��PO����VO��Ϣ���ص�չʾ��
	 */
	public StorageListVO modify(String id, String desti, String dis, String row, 
			String she, String pos);
	
	/**
	 * 
	 * @param id
	 * @return ����id��ѯĳ��ⵥ,������ⵥVO��Ϣ
	 */
	public StorageListVO inquireA(String id);
	
	/**
	 * 
	 * @param id
	 * @return ����ʱ���ѯĳ���ⵥ,������ⵥVO��Ϣ
	 */
	public StorageListVO inquireB(String time);
	
	/**
	 * 
	 * �����˴�����ⵥ��ص�ҵ�񣬳־û������漰��������������
	 */
	public void endSL();
}
