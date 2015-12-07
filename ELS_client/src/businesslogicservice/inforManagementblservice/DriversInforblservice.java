package businesslogicservice.inforManagementblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.inforManagementVO.DriversVO;

public interface DriversInforblservice {
	/**
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µ�˾����Ϣ
	 * @param vo
	 * @return
	 */
	public JavaBean1 add(DriversVO driversVO);
	
	/**
	 * 
	 * @param Id
	 * @return
	 * ǰ��������Ҫ��ѯ��˾����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public JavaBean1 inquireA(String ID);
	
	public JavaBean1 inquireB(String city, String region);
		
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
	public ResultMessage deleteMany(ArrayList<String> IDList);
	
	/**
	 * 
	 * @param vo
	 * @return
	 * ǰ��������Ҫ�޸ĵ�˾����Ϣ��PO���м�¼
	 * �����������޸�˾����Ϣ��������VO��PO
	 */
	public ResultMessage modify(DriversVO driversVO);
	
	public String generateID();

}
