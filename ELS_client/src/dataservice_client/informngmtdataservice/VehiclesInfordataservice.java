package dataservice_client.informngmtdataservice;

import java.util.ArrayList;

import po_client.informngmtPO.VehiclesPO;
import po_client.lineitemPO.informngmtlineitemPO.VehicleslineitemPO;
import state.ResultMessage;

public interface VehiclesInfordataservice {
	/**
	 * 
	 * @param vehiclesId
	 * @param engineNum
	 * @param vehiclesNum
	 * @param chassisNum
	 * @param dateOfBuy
	 * @param activeTime
	 * @param vehiclesImage
	 * @return
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µĳ�����Ϣ
	 */
	public VehiclesPO add(String vehiclesId, String engineNum, String vehiclesNum, String chassisNum,String dateOfBuy,String activeTime,String vehiclesImage);
		
	/**
	 * 
	 * @param id
	 * @return
	 * ǰ��������Ҫɾ���ĳ�����Ϣ��PO���м�¼
	 * ����������ɾ��һ��������Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String vehiclesId);
	/**
	 * 
	 * @param id4Vehicles
	 * ǰ��������Ҫɾ���ĳ�����Ϣ�ڳ־û��������м�¼
	 * ����������ɾ������������Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4Vehicles);
	
	/**
	 * 
	 * @param vehiclesId
	 * @return
	 * ǰ��������Ҫ�޸ĵĳ�����Ϣ��PO���м�¼
	 * �����������޸ĳ�����Ϣ��������VO��PO
	 */
	public VehiclesPO modify(String vehiclesId);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * ǰ��������Ҫ��ѯ�ĳ�����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public VehicleslineitemPO inquire(String keyword);
	
	/**
	 * ǰ��������������Ϣ�������
	 * �����������������γ�����Ϣ�����������ݳ־û�����
	 */
	public void update();
}
