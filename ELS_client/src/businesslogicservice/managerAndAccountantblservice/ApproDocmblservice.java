package businesslogicservice.managerAndAccountantblservice;

import java.util.ArrayList;

import bean.JavaBean1;
import state.ResultMessage;


/**
 * 
 * @author zt
 * ���ദ������������ص�ҵ���߼�
 */
public interface ApproDocmblservice {
	/**
	 * ǰ����������һ�ֵ����б�
	 * ������������ѯһ�����ݵ�����
	 * @param id
	 * @return
	 */
	public JavaBean1 inquireA(String id, String documentType);
	
	public JavaBean1 inquireB(String documentsType);
	
	public ResultMessage approveDocuments(ArrayList<String> IDList, String 
			documentsType);
	
}
