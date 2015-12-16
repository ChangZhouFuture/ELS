package businesslogicservice.managerAndAccountantblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.DocumentsType;
import state.ResultMessage;


/**
 * 
 * @author zt
 * 该类处理审批单据相关的业务逻辑
 */
public interface ApproDocmblservice {
	/**
	 * 前置条件：打开一种单据列表
	 * 后置条件：查询一个单据的数据
	 * @param id
	 * @return
	 */
	public JavaBean1 inquireA(String id, DocumentsType documentType);
	
	public JavaBean1 inquireB(DocumentsType documentsType, String date);
	
	public ResultMessage approveDocuments(ArrayList<String> IDList, DocumentsType 
			documentsType);
	
}
