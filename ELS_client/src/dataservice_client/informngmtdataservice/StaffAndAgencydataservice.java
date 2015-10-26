package dataservice_client.informngmtdataservice;

import po_client.informngmtPO.StaffAndAgencyPO;
import state.Gender;
import state.PayType;
import state.Position;
import vo_client.lineitemVO.informngmtlineitemVO.StaffAndAgencylineitemVO;

public interface StaffAndAgencydataservice {
     
	/**
	 * ǰ��������
	 * ��������������Ա�����б��ظ��߼���1
	 * @return
	 */
    public StaffAndAgencylineitemVO inquireList();
    
    /**
     * ǰ��������id��Ӧ����Ա����Ϣ����
     * �������������б��и���id��ѯ��Ա��Ϣ�����ظ��߼���
     * @param id
     * @return
     */
    public StaffAndAgencyPO inquire(String id);
    
    /**
     * ǰ����������������Ա��Ϣ��������
     * ��������������һ���µ���Ա��Ϣ�����ظ��߼���
     * @param id
     * @param name
     * @param age
     * @param Gender
     * @param position
     * @param paytype
     * @param amount
     * @return
     */
    public StaffAndAgencyPO add(String id,String name,int age,Gender Gender,Position position,
    		PayType paytype,double amount);
    
    /**
     * ǰ��������Ҫ�޸ĵ���Ա�����ݿ���
     * �����������޸�һ����Ա����Ϣ�����ظ��߼���
     * @param id
     * @param name
     * @param age
     * @param gender
     * @param position
     * @param paytype
     * @param amount
     * @return
     */
    public StaffAndAgencyPO modify(String id,String name,int age,Gender gender,Position position,
    		PayType paytype,double amount);
    
    /**
     * ǰ��������Ҫɾ������Ա�����ݿ���
     * ����������ɾ��һ����Ա��Ϣ�������߼���
     * @param id
     */
    public void delete(String id);
    
    /**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public void update();

}
