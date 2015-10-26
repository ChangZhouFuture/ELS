package businesslogicservice_client.informngmtblservice;

import state.ResultMessage;
import vo_client.informngmtVO.BankAccountVO;
import vo_client.lineitemVO.informngmtlineitemVO.BankAccountlineitemVO;

/**
 * 
 * @author �ܳ�
 * ������Ҫ�����������˻���Ϣ��ص�ҵ���߼�
 */
public interface BankAccountInforblservice {
	
	/**
	 * 
	 * @param accountName
	 * @param agency
	 * @param id4staff
	 * @param id4Vehics
	 * @return
	 * ǰ��������������Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������˻���ʼ������
	 */
	public BankAccountVO initialize(String accountName, String agency, String id4staff, String id4Vehics);
		
	/**
	 * 
	 * @param id
	 * @return
	 * ǰ��������Ҫɾ�����˻���PO���м�¼
	 * �����������˻���Ϣ��ɾ��
	 * 
	 */
	public ResultMessage delete(String accountName);
	
	/**
	 * 
	 * @param accountName
	 * @return
	 * ǰ��������Ҫ�޸ĵ��˻���PO���м�¼
	 * �����������޸ĸ��˻��˻����ƣ�������VO��PO
	 */
	public BankAccountVO modify(String accountName);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * ǰ��������Ҫ��ѯ�������˻������ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public BankAccountlineitemVO inquire(String keyword);
	
	/**
	 * ǰ��������ҵ�������
	 * �����������������ҵ�����������ݳ־û�����
	 */
	public void end();
}
