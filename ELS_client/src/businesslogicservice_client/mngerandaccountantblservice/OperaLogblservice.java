package businesslogicservice_client.mngerandaccountantblservice;

import vo_client.OperaLogVO;
import vo_client.lineitemVO.OperaLoglineitemVO;

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
     public OperaLoglineitemVO inquireB(String id);
     
     /**
 	 * ǰ������������һ����ѯ��־�غ�
 	 * ����������ͨ�����ڲ�ѯĳ����־
 	 * @param date
 	 * @return
 	 */
     public OperaLoglineitemVO inquireC(String date);
     
}
