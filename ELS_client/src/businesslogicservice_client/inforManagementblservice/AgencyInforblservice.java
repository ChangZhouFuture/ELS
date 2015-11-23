package businesslogicservice_client.inforManagementblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.inforManagementVO.AgencyVO;

/**
 * 
 * @author zt
 * ���ദ�����Ա���������йص�ҵ���߼�
 */
public interface AgencyInforblservice {
	public ResultMessage add(AgencyVO vo);
	
	public ResultMessage deleteOne(String Id);
	
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	public ResultMessage modify(AgencyVO vo);
	
	public AgencyVO inquire(String Id);
}
