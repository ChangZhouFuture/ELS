package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;


/**
 * �ýӿ��ṩ����������ص����ݲ㷽��
 * @author zt
 *
 */
public interface Approdocmdataservice extends Remote{

	/**
	 * ǰ�����������ݲ��в�ѯ�Ķ�Ӧid�ĵ���
	 * ��������������һ�����ݵ����ݸ��߼���
	 * @param id
	 * @return
	 */
	public Object inquireA(String id);
	
	/**
	 * ǰ��������
	 * ��������������һ�ֵ����б���߼���
	 * @param kind
	 * @return
	 */
	public Object inquireB(String kind);
	
	/**
	 * ǰ��������
	 * ��������������ĳһ�յĵ����б���߼���
	 * @param kind
	 * @return
	 */
	public Object inquireC(String date);
	
	
	/**
	 * ǰ��������Ҫ�޸ĵĵ��������ݲ���
	 * �����������޸�ĳһ����
	 * @return
	 */
	public Object modify();
	
	/**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public void update();

}
