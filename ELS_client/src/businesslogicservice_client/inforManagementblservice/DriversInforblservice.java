package businesslogicservice_client.inforManagementblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.inforManagementVO.DriversVO;
import vo_client.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;

public interface DriversInforblservice {
	/**
	 * 
	 * @param driverId
	 * @param driverName
	 * @param driverDob
	 * @param driverIdNum
	 * @param driverCPN
	 * @param VehicleUnit
	 * @param driverSex
	 * @param driverDLP
	 * @return
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µ�˾����Ϣ
	 */
	public DriversVO add(String driverId, String driverName, String driverDob, String driverIdNum,String driverCPN,String VehicleUnit,String driverSex,String driverDLP);
		
	/**
	 * 
	 * @param id
	 * @return
	 * ǰ��������Ҫɾ����˾����Ϣ��PO���м�¼
	 * ����������ɾ��һ��˾����Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String driverId);

	/**
	 * 
	 * @param id4Driver
	 * ǰ��������Ҫɾ����˾����Ϣ�ڳ־û��������м�¼
	 * ����������ɾ������˾����Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4Driver);
	
	/**
	 * 
	 * @param driverId
	 * @return
	 * ǰ��������Ҫ�޸ĵ�˾����Ϣ��PO���м�¼
	 * �����������޸�˾����Ϣ��������VO��PO
	 */
	public DriversVO modify(String driverId);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * ǰ��������Ҫ��ѯ��˾����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public DriverslineitemVO inquire(String keyword);
	
	/**
	 * ǰ��������˾����Ϣ�������
	 * �����������������˾����Ϣ�����������ݳ־û�����
	 */
	public void end();
}
