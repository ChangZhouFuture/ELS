package businesslogicservice_client.managerAndAccountantblservice;

import vo_client.utilityVO.OperaLogVO;
/**
 * 
 * @author zt
 * ���ദ���ѯ������־��ص�ҵ���߼�
 */
public interface OperaLogblservice {
	/**
	 * ǰ������������һ����ѯ��־�غ�
	 * ����������ͨ��id�����ڲ�ѯĳ��Աĳ����־
	 * @param id
	 * @param date
	 * @return
	 */
     public OperaLogVO inquireA(String id,String date);
     
     /**
 	 * ǰ������������һ����ѯ��־�غ�
 	 * ����������ͨ��id��ѯĳ��Ա����־
 	 * @param id
 	 * @return
 	 */
     public OperaLogVO inquireB(String id);
     
     /**
 	 * ǰ������������һ����ѯ��־�غ�
 	 * ����������ͨ�����ڲ�ѯĳ����־
 	 * @param date
 	 * @return
 	 */
     public OperaLogVO inquireC(String date);
}
