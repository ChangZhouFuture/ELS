package dataservice_client.mngerandaccountantdataservice;

import vo_client.OperaLogVO;
import vo_client.lineitemVO.OperaLoglineitemVO;
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
     public OperaLoglineitemVO inquireB(String id);
     
     /**
 	 * ǰ����������ѯ�Ĳ�����־�����ݿ���
 	 * ������������ĳ����־�б��ظ��߼���
 	 * @param date
 	 * @return
 	 */
     public OperaLoglineitemVO inquireC(String date);
     
}
