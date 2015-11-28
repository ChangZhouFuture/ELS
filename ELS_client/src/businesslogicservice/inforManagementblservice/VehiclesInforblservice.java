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
	public JavaBean1 add(VehiclesVO vo);
		
	/**
	 * 
	 * @param id
	 * @return
	 * ǰ��������Ҫɾ���ĳ�����Ϣ��PO���м�¼
	 * ����������ɾ��һ��������Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String Id);
	/**
	 * 
	 * @param id4Vehicles
	 * ǰ��������Ҫɾ���ĳ�����Ϣ�ڳ־û��������м�¼
	 * ����������ɾ������������Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	/**
	 * 
	 * @param Id
	 * @return
	 * ǰ��������Ҫ�޸ĵĳ�����Ϣ��PO���м�¼
	 * �����������޸ĳ�����Ϣ��������VO��PO
	 */
	public ResultMessage modify(VehiclesVO vo);
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public JavaBean1 inquire(String Id);
}
