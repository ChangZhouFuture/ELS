package businesslogicservice_client.inforManagementblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.inforManagementVO.DriversVO;

public interface DriversInforblservice {
	/**
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µ�˾����Ϣ
	 * @param vo
	 * @return
	 */
	public ResultMessage add(DriversVO vo);
	
	/**
	 * 
	 * @param Id
	 * @return
	 * ǰ��������Ҫ��ѯ��˾����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public DriversVO inquire(String Id);
		
	/**
	 * 
	 * @param Id
	 * @return
	 * ǰ��������Ҫɾ����˾����Ϣ��PO���м�¼
	 * ����������ɾ��һ��˾����Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String Id);

	/**
	 * 
	 * @param Ids
	 * ǰ��������Ҫɾ����˾����Ϣ�ڳ־û��������м�¼
	 * ����������ɾ������˾����Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	/**
	 * 
	 * @param vo
	 * @return
	 * ǰ��������Ҫ�޸ĵ�˾����Ϣ��PO���м�¼
	 * �����������޸�˾����Ϣ��������VO��PO
	 */
	public ResultMessage modify(DriversVO vo);
	


}
