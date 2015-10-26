package businesslogicservice_client.informngmtblservice;

import state.Gender;
import state.PayType;
import state.Position;
import vo_client.informngmtVO.StaffAndAgencyVO;
import vo_client.lineitemVO.informngmtlineitemVO.StaffAndAgencylineitemVO;
/**
 * 
 * @author zt
 * ���ദ�����Ա���������йص�ҵ���߼�
 */
public interface StaffAndAgencyblservice {
	/**
	 * ǰ������������һ����Ա��������غ�
	 * ��������������Ա�����б�
	 * @return
	 */
    public StaffAndAgencylineitemVO inquireList();
    
    /**
     * ǰ������������Ա�����б�
     * �������������б��и���id��ѯ��Ա��Ϣ
     * @param id
     * @return
     */
    public StaffAndAgencyVO inquire(String id);
    
    /**
     * ǰ��������������Ա����غ�
     * ��������������һ���µ���Ա��Ϣ
     * @param id
     * @param name
     * @param age
     * @param Gender
     * @param position
     * @param paytype
     * @param amount
     * @return
     */
    public StaffAndAgencyVO add(String id,String name,int age,Gender Gender,Position position,
    		PayType paytype,double amount);
    
    /**
     * ǰ��������������Ա����غ�
     * �����������޸�һ����Ա����Ϣ
     * @param id
     * @param name
     * @param age
     * @param gender
     * @param position
     * @param paytype
     * @param amount
     * @return
     */
    public StaffAndAgencyVO modify(String id,String name,int age,Gender gender,Position position,
    		PayType paytype,double amount);
    
    /**
     * ǰ��������������Ա����غ�
     * ����������ɾ��һ����Ա��Ϣ
     * @param id
     */
    public void delete(String id);
    
    /**
     * ǰ���������������Ա��������
     * ����������������Ա���������־û������漰��������������
     */
    public void endSAA();
}
