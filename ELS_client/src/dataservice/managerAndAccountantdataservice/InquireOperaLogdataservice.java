package dataservice.managerAndAccountantdataservice;

import po.utilityPO.OperaLogPO;

/**
 * ���ദ���йز�ѯ������־������
 * @author zt
 *
 */
public interface InquireOperaLogdataservice {
	/**
	 * ǰ����������ѯ�Ĳ�����־�����ݿ���
	 * ������������ĳ��Աĳ����־���ظ��߼���
	 * @param id
	 * @param date
	 * @return
	 */
     public OperaLogPO inquireA(String id,String date);
     
     /**
 	 * ǰ����������ѯ�Ĳ�����־�����ݿ���
 	 * ������������ĳ��Ա��־�б��ظ��߼���
 	 * @param id
 	 * @return
 	 */
     public OperaLogPO inquireB(String id);
     
     /**
 	 * ǰ����������ѯ�Ĳ�����־�����ݿ���
 	 * ������������ĳ����־�б��ظ��߼���
 	 * @param date
 	 * @return
 	 */
     public OperaLogPO inquireC(String date);
     
}
