package businesslogicservice_client.mngerandaccountantblservice;


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
	public Object chooseKind(String kind);
	
	/**
	 * ǰ����������һ�ֵ����б�
	 * ������������ѯһ�����ݵ�����
	 * @param id
	 * @return
	 */
	public Object inquire(String id);
	
	/**
	 * ǰ����������ʾһ�����ݵ�����
	 * �����������޸�һ�����ݵ�����
	 * @return
	 */
	public Object modify();
	
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
