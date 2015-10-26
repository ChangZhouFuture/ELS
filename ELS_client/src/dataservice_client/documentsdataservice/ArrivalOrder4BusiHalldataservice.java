package dataservice_client.documentsdataservice;

import java.util.ArrayList;

import po_client.documentsPO.ArrivalOrder4BusiHallPO;
import po_client.lineitemPO.documentslineitemPO.ArrivalOrder4BusiHalllineitemPO;
import state.GoodState;
import state.ResultMessage;

/**
 * 
 * @author �쿡��
 * �ýӿ��ṩ��Ӫҵ�����ﵥ����ص����ݲ㷽��
 *
 */
public interface ArrivalOrder4BusiHalldataservice {

	/**
	 * ǰ�ã�Ӫҵ��ҵ��Ա���������в���
	 * ���ã�����һ��Ӫҵ�����ﵥ������PO
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @return һ��Ӫҵ�����ﵥ
	 */
	public ArrivalOrder4BusiHallPO addArrivalOrder4BusiHall(String id,String toid,String sa,String d,GoodState gs);
	
	/**
	 * ǰ�ã�Ҫ�޸ĵ�Ӫҵ�����ﵥ��PO���м�¼
	 * ���ã�����һ��Ӫҵ�����ﵥ������PO�����Ϣ
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @return ���ĺ��Ӫҵ�����ﵥ
	 */
	public ArrivalOrder4BusiHallPO modify(String id,String toid,String sa,String d,GoodState gs);
	
	/**
	 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ��PO���м�¼
	 * ���ã�ɾ��һ��Ӫҵ�����ﵥ������PO����
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ�ڳ־û��������м�¼
	 * ���ã�ɾ�����Ӫҵ�����ﵥ������PO����
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ��PO���м�¼
	 * ���ã�����ʱ���ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥPO��Ϣ��ҵ���߼���
	 * @param id
	 * @return Ӫҵ�����ﵥ��Ϣ
	 */
	public ArrivalOrder4BusiHallPO inquireA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ��PO���м�¼
	 * ���ã�����ʱ���ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥPO��Ϣ
	 * @param time
	 * @return Ӫҵ�����ﵥ�б�
	 */
	public ArrivalOrder4BusiHalllineitemPO inquireB(String time);
	
	/**
	 * ǰ�ã���Ϊ������Ѿ����
	 * ���ã��־û�������Ƶ�������������
	 */
	public void update();
}
