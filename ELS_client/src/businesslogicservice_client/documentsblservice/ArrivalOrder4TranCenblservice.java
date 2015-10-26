package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4TranCenVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4TranCenlineitemVO;

/**
 * 
 * @author �쿡��
 * ��������ת���ĵ��ﵥ��ص�ҵ���߼�
 *
 */
public interface ArrivalOrder4TranCenblservice {
	/**
	 * ǰ�ã���ת��ID�ڳ־û��������м�¼
	 * ���ã��Զ��ó�������
	 * @param id
	 * @return ������
	 */

	public String generateStartAddress(String toid);
	
	/**
	 * ǰ�ã��Ѵ���ת���ĵ��ﵥ����ҳ��
	 * �ж���ת���Ƿ����
	 * @param id
	 * @return �Ƿ����
	 */
	public ResultMessage addTransferOrder(String id);
	
	/**
	 * ǰ�ã��Ѵ���ת���ĵ��ﵥ����ҳ��
	 * ���ã��Զ�������ת���ĵ��ﵥ����
	 * @return ����
	 */
	public String generateDate();
	
	/**
	 * ǰ�ã���ת����ҵ��Ա���������в���
	 * ���ã�����һ����ת���ĵ��ﵥ������VO��PO������VO��Ϣ��չʾ��
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
 	 * @param gs
	 * @param tcid
	 * @return һ����ת���ĵ��ﵥ
	 */
	public ArrivalOrder4TranCenVO addArrivalOrder4TranCen(String id,String toid,String sa,String d,GoodState gs,String tcid);
	
	/**
-	 * ǰ�ã���ѡ��������ת���ĵ��ﵥ�����������Ϣ
-	 * �Զ�������ת���ĵ��ﵥ���
+	 * ǰ�ã������������ת���ĵ��ﵥ��Ϣ
+	 * ���ã��Զ�������ת���ĵ��ﵥ���
	 * @return ��ת���ĵ��ﵥ
	 */
	public String generateId();
	
	/**
-	 * ǰ�ã���ѡ����ĵ���ת���ĵ��ﵥ
-	 * ����һ����ת���ĵ��ﵥ������VO��PO������VO��Ϣ��չʾ��
+	 * ǰ�ã�Ҫ�޸ĵ���ת���ĵ��ﵥ�ڳ־û��������м�¼
+	 * ���ã�����һ����ת���ĵ��ﵥ������VO��PO������VO��Ϣ��չʾ��
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
 	 * @param gs
	 * @param tcid
	 * @return ���ĺ����ת���ĵ��ﵥ
	 */
	public ArrivalOrder4TranCenVO modify(String id,String toid,String sa,String d,GoodState gs,String tcid);
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�ɾ��һ����ת���ĵ��ﵥ
	 * @param id
	 * @return 
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * ǰ�ã�����һ����ת���ջغ�
	 * ɾ�������ת���ĵ��ﵥ
	 * ǰ�ã�Ҫɾ������ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�ɾ��һ����ת���ĵ��ﵥ
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥVO��Ϣ
	 * @param id
	 * @return ��ת���ĵ��ﵥ��Ϣ
	 */
	public ArrivalOrder4TranCenVO inquireA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥVO��Ϣ
	 * @param time
	 * @return ��ת���ĵ��ﵥ�б�
	 */
	public ArrivalOrder4TranCenlineitemVO inquireB(String time);
	
	/**
	 * ǰ�ã�ҵ���Ѿ��������
	 * ���ã������˴���ת���ջغϣ��־û�������Ƶ�������������
	 */
	public void end();
}
