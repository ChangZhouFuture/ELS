package dataservice_client.informngmtdataservice;

import java.util.ArrayList;

import po_client.informngmtPO.DriversPO;
import po_client.lineitemPO.informngmtlineitemPO.DriverslineitemPO;
import state.ResultMessage;

public interface DriversInfordataservice {
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
	public DriversPO add(String id, String driverName, String driverDob, String driverIdNum,String driverCPN,String VehicleUnit,String driverSex,String driverDLP);
	/**
	 * 
	 * @param id
	 * @return
	 * ǰ��������Ҫɾ����˾����Ϣ��PO���м�¼
	 * ����������ɾ��һ����Ϣ��Ϣ
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
	 * @param accountName
	 * @return
	 * ǰ��������Ҫ�޸ĵ�˾����Ϣ��PO���м�¼
	 * �����������޸�˾����Ϣ��������VO��PO
	 */
	public DriversPO modify(String driverId);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * ǰ��������Ҫ��ѯ��˾����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public DriverslineitemPO inquire(String keyword);
	
	/**
	 * ǰ��������˾����Ϣ�������
	 * �����������������˾����Ϣ�����������ݳ־û�����
	 */
	public void update();
}
