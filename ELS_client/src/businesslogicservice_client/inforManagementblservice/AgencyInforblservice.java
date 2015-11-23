package businesslogicservice_client.inforManagementblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.inforManagementVO.AgencyVO;

/**
 * 
 * @author zt
 * 该类处理和人员机构管理有关的业务逻辑
 */
public interface AgencyInforblservice {
	public ResultMessage add(AgencyVO vo);
	
	public ResultMessage deleteOne(String Id);
	
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	public ResultMessage modify(AgencyVO vo);
	
	public AgencyVO inquire(String Id);
}
