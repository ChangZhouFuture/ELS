package businesslogicservice.stockblservice;

import java.util.ArrayList;

import bean.JavaBean1;
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
	public OrderlineitemVO addExpress(String expressID);
	
	/**
	 * 
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return ����һ����ⵥ�����±䶯��PO����VO��Ϣ���ص�չʾ��
	 */
	public JavaBean1 add(StorageListVO storageListVO);
	
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
	public ResultMessage deleteMany(ArrayList<String> IDList);
	
	/**
	 * 
	 * @param id
	 * @param id4e
	 * @param id4to
	 * @param desti
	 * @return �޸�һ����ⵥ�����������Ϣ��VO��PO����VO��Ϣ���ص�չʾ��
	 */
	public ResultMessage modify(StorageListVO storageListVO);
	
	/**
	 * 
	 * @param id
	 * @return ����id��ѯĳ��ⵥ,������ⵥVO��Ϣ
	 */
	public JavaBean1 inquireA(String ID);
	
	/**
	 * 
	 * @param id
	 * @return ����ʱ���ѯĳ���ⵥ,������ⵥVO��Ϣ
	 */
	public JavaBean1 inquireB(String date);
}
