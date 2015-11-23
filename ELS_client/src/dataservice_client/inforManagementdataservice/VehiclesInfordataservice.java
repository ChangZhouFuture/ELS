package dataservice_client.inforManagementdataservice;

import java.util.ArrayList;

import po_client.inforManagementPO.VehiclesPO;
import po_client.lineitemPO.inforManagementlineitemPO.VehicleslineitemPO;
import state.ResultMessage;

public interface VehiclesInfordataservice {
	/**
	 * 
	 * @param po
	 * @return
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µĳ�����Ϣ
	 */
	public ResultMessage add(VehiclesPO po);
		
	/**
	 * 
	 * @param Id
	 * @return
	 * ǰ��������Ҫɾ���ĳ�����Ϣ��PO���м�¼
	 * ����������ɾ��һ��������Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String Id);
	/**
	 * 
	 * @param Ids
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
	public ResultMessage update(VehiclesPO po);
	
	/**
	 * 
	 * @param Id
	 * @return
	 * ǰ��������Ҫ��ѯ�ĳ�����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public VehiclesPO find(String Id);
	
}
