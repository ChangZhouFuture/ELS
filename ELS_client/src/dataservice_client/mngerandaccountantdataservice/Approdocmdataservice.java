package dataservice_client.mngerandaccountantdataservice;

import vo_client.ParentVO;

/**
 * �ýӿ��ṩ����������ص����ݲ㷽��
 * @author zt
 *
 */
public interface Approdocmdataservice {

	/**
	 * ǰ�����������ݲ��в�ѯ�Ķ�Ӧid�ĵ���
	 * ��������������һ�����ݵ����ݸ��߼���
	 * @param id
	 * @return
	 */
	public ParentVO inquireA(String id);
	
	/**
	 * ǰ��������
	 * ��������������һ�ֵ����б���߼���
	 * @param kind
	 * @return
	 */
	public ParentVO inquireB(String kind);
	
	/**
	 * ǰ��������
	 * ��������������ĳһ�յĵ����б���߼���
	 * @param kind
	 * @return
	 */
	public ParentVO inquireC(String date);
	
	
	/**
	 * ǰ��������Ҫ�޸ĵĵ��������ݲ���
	 * �����������޸�ĳһ����
	 * @return
	 */
	public ParentVO modify();
	
	/**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public void update();

}
