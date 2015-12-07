package businesslogicservice.inforManagementblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.inforManagementVO.AgencyVO;

/**
 * 
 * @author zt
 * ���ദ�����Ա���������йص�ҵ���߼�
 */
public interface AgencyInforblservice {
	public JavaBean1 add(AgencyVO agencyVO);
	
	public ResultMessage deleteOne(String ID);
	
	public ResultMessage deleteMany(ArrayList<String> IDList);
	
	public ResultMessage modify(AgencyVO agencyVO);
	
	public JavaBean1 inquire(String ID);
	
	public String generateID();
}
