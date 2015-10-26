package businesslogicservice_client.mngerandaccountantblservice;

import vo_client.ParentVO;
import vo_client.lineitemVO.ParentlineitemVO;

/**
 * 
 * @author zt
 * ���ദ������������ص�ҵ���߼�
 */
public interface ApproDocmblservice {
	/**
	 * ǰ������������һ��������������
	 * ����������ѡ��һ�ֵ��ݣ���ʾ���б�
	 * @param kind
	 * @return
	 */
	public ParentlineitemVO chooseKind(String kind);
	
	/**
	 * ǰ����������һ�ֵ����б�
	 * ������������ѯһ�����ݵ�����
	 * @param id
	 * @return
	 */
	public ParentVO inquire(String id);
	
	/**
	 * ǰ����������ʾһ�����ݵ�����
	 * �����������޸�һ�����ݵ�����
	 * @return
	 */
	public ParentVO modify();
	
	/**
	 * ǰ������������һ��������������
	 * ����������ɾ��һ������
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * ǰ��������������
	 * ������������ǵ���Ϊ������
	 * @param id
	 */
	public void finishApprove(String id);
	
	/**
	 * ǰ��������������
	 * ������������Ƕ������Ϊ������״̬
	 */
	public void mark();
	
	/**
	 * ǰ�������������������
	 * ���������������������ݣ��־û������漰��������������
	 */
	public void endAD();
	
}
