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
	public JavaBean1 add(AgencyVO vo);
	
	public ResultMessage deleteOne(String Id);
	
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	public ResultMessage modify(AgencyVO vo);
	
	public JavaBean1 inquire(String Id);
}
