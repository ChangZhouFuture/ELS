package dataservice_client.documentsdataservice;

import java.util.ArrayList;

import po_client.documentsPO.ArrivalOrder4TranCenPO;
import po_client.lineitemPO.documentslineitemPO.ArrivalOrder4TranCenlineitemPO;
import po_client.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
 
/**
 * @author �쿡��
 * �ýӿ��ṩ����ת���ĵ��ﵥ��ص����ݲ㷽��
 */
public interface ArrivalOrder4TranCendataservice {
	
	public TransferOrderlineitemPO addTransferOrder(String id);
	
	/**
	 * ǰ�ã���ת����ҵ��Ա���������в���
	 * ���ã�����һ����ת���ĵ��ﵥ�����±䶯��PO
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @param tcid
	 * @return һ����ת���ĵ��ﵥ
	 */
	public ResultMessage addArrivalOrder4TranCen(ArrivalOrder4TranCenPO arrivalOrder4TranCenPO);
	
	/**
	 * ǰ�ã�Ҫ�޸ĵ���ת���ĵ��ﵥ��PO���м�¼
	 * ���ã�����һ����ת���ĵ��ﵥ������PO�����Ϣ
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @param tcid
	 * @return ���ĺ����ת���ĵ��ﵥ
	 */
	public ResultMessage modify(ArrivalOrder4TranCenPO arrivalOrder4TranCenPO);
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ĵ��ﵥ��PO���м�¼
	 * ���ã�ɾ��һ����ת���ĵ��ﵥ������PO����
	 * @param id
	 * @return 
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�ɾ��һ����ת���ĵ��ﵥ������PO����
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ��PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥPO��Ϣ��ҵ���߼���
	 * @param id
	 * @return ��ת���ĵ��ﵥ��Ϣ
	 */
	public ArrivalOrder4TranCenPO inquireA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ��PO���м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥPO��Ϣ
	 * @param time
	 * @return ��ת���ĵ��ﵥ�б�
	 */
	public ArrivalOrder4TranCenlineitemPO inquireB(String time);
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û�������Ƶ�������������
	 */
	public void update();
 }
