package dataservice_client.inforManagementdataservice;

import po_client.inforManagementPO.BankAccountPO;
import po_client.lineitemPO.inforManagementlineitemPO.BankAccountlineitemPO;
import state.ResultMessage;

public interface BankAccountInfordataservice {
	
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
	public BankAccountPO initialize(String accountName, String agency, String id4staff, String id4Vehics);
		
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
	public BankAccountPO modify(String accountName);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * ǰ��������Ҫ��ѯ�������˻������ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public BankAccountlineitemPO inquire(String keyword);
	
	/**
	 * ǰ��������ҵ�������
	 * �����������������ݳ־û�����
	 */
	public void update();
}
