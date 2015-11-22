package dataservice_client.inforManagementdataservice;

import java.util.ArrayList;

import po_client.inforManagementPO.DriversPO;
import state.ResultMessage;

public interface DriversInfordataservice {
	/**
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µ�˾����Ϣ
	 * @param po
	 * @return
	 */
	public ResultMessage add(DriversPO po);
	
	/**
	 * 
	 * @param Id
	 * @return
	 */
	public DriversPO find(String Id);
	
	/**
	 * 
	 * @param ID
	 * @return
	 * ǰ��������Ҫɾ����˾����Ϣ��PO���м�¼
	 * ����������ɾ��һ����Ϣ��Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String Id);
	
	/**
	 * 
	 * @param IDs
	 * ǰ��������Ҫɾ����˾����Ϣ�ڳ־û��������м�¼
	 * ����������ɾ������˾����Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	/**
	 * 
	 * @param po
	 * @return
	 * ǰ��������Ҫ�޸ĵ�˾����Ϣ��PO���м�¼
	 * �����������޸�˾����Ϣ��������VO��PO
	 */
	public ResultMessage update(DriversPO po);
	
}
