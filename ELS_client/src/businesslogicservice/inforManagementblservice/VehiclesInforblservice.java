package businesslogicservice.inforManagementblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.inforManagementVO.VehiclesVO;

public interface VehiclesInforblservice {
	/**
	 * 
	 * @param vo
	 * @return
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µĳ�����Ϣ
	 */
	public JavaBean1 add(VehiclesVO vehiclesVO);

	/**
	 * 
	 * @param id4Vehicles
	 * ǰ��������Ҫɾ���ĳ�����Ϣ�ڳ־û��������м�¼
	 * ����������ɾ������������Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> IDList);
	
	/**
	 * 
	 * @param Id
	 * @return
	 * ǰ��������Ҫ�޸ĵĳ�����Ϣ��PO���м�¼
	 * �����������޸ĳ�����Ϣ��������VO��PO
	 */
	public ResultMessage modify(VehiclesVO vehiclesVO);
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public JavaBean1 inquireA(String ID);
	
	public JavaBean1 inquireB(String busiHallID);
	
}
