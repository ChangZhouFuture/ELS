package businesslogicservice.managerAndAccountantblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.DocumentsType;
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
	public JavaBean1 inquireA(String id, DocumentsType documentType);
	
	public JavaBean1 inquireB(DocumentsType documentsType, String date);
	
	public ResultMessage approveDocuments(ArrayList<String> IDList, DocumentsType 
			documentsType);
	
}
