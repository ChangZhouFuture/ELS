package businesslogicservice.managerAndAccountantblservice;

import bean.JavaBean1;
/**
 * 
 * @author zt
 * ���ദ���ѯ������־��ص�ҵ���߼�
 */
public interface OperaLogblservice {
     /**
 	 * ǰ������������һ����ѯ��־�غ�
 	 * ����������ͨ�����ڲ�ѯĳ����־
 	 * @param date
 	 * @return
 	 */
     public JavaBean1 inquireOperaLog(String date);
}
