package dataservice_client.managerAndAccountantdataservice;

import vo_client.utilityVO.OperaLogVO;
/**
 * ���ദ���йز�ѯ������־������
 * @author zt
 *
 */
public interface OperaLogdataservice {
	/**
	 * ǰ����������ѯ�Ĳ�����־�����ݿ���
	 * ������������ĳ��Աĳ����־���ظ��߼���
	 * @param id
	 * @param date
	 * @return
	 */
     public OperaLogVO inquireA(String id,String date);
     
     /**
 	 * ǰ����������ѯ�Ĳ�����־�����ݿ���
 	 * ������������ĳ��Ա��־�б��ظ��߼���
 	 * @param id
 	 * @return
 	 */
     public OperaLogVO inquireB(String id);
     
     /**
 	 * ǰ����������ѯ�Ĳ�����־�����ݿ���
 	 * ������������ĳ����־�б��ظ��߼���
 	 * @param date
 	 * @return
 	 */
     public OperaLogVO inquireC(String date);
     
}
