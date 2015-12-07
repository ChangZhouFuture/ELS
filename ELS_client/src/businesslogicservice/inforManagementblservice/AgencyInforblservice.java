package businesslogicservice.inforManagementblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.inforManagementVO.AgencyVO;

/**
 * 
 * @author zt
 * 该类处理和人员机构管理有关的业务逻辑
 */
public interface AgencyInforblservice {
	public JavaBean1 add(AgencyVO agencyVO);
	
	public ResultMessage deleteOne(String ID);
	
	public ResultMessage deleteMany(ArrayList<String> IDList);
	
	public ResultMessage modify(AgencyVO agencyVO);
	
	public JavaBean1 inquire(String ID);
	
	public String generateID();
}
