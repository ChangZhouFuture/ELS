package businesslogicservice_client.informngmtblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.informngmtVO.VehiclesVO;
import vo_client.lineitemVO.informngmtlineitemVO.VehicleslineitemVO;

public interface VehiclesInforblservice {
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
	public VehiclesVO add(String vehiclesId, String engineNum, String vehiclesNum, String chassisNum,String dateOfBuy,String activeTime,String vehiclesImage);
		
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
	public VehiclesVO modify(String vehiclesId);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * ǰ��������Ҫ��ѯ�ĳ�����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public VehicleslineitemVO inquire(String keyword);
	
	/**
	 * ǰ��������������Ϣ�������
	 * �����������������γ�����Ϣ�����������ݳ־û�����
	 */
	public void end();
}
