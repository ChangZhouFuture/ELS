package businesslogicservice.documentsblservice;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo.documentsVO.ArrivalOrder4TranCenVO;
import vo.lineitemVO.documentslineitemVO.ArrivalOrder4TranCenlineitemVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;

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

	public String generateStartAddress(String transderOrderId);
	
	/**
	 * ǰ�ã��Ѵ���ת���ĵ��ﵥ����ҳ��
	 * �ж���ת���Ƿ����
	 * @param id
	 * @return �Ƿ����
	 */
	public TransferOrderlineitemVO addTransferOrder(String id);
	
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
	public ResultMessage addArrivalOrder4TranCen(ArrivalOrder4TranCenVO arrivalOrder4TranCenVO);
	
	/**
+	 * ǰ�ã������������ת���ĵ��ﵥ��Ϣ
+	 * ���ã��Զ�������ת���ĵ��ﵥ���
	 * @return ��ת���ĵ��ﵥ
	 */
	public String generateId();
	
	/**
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
	public ResultMessage modify(ArrivalOrder4TranCenVO arrivalOrder4TranCenVO);
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�ɾ��һ����ת���ĵ��ﵥ
	 * @param id
	 * @return 
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�ɾ�������ת���ĵ��ﵥ
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥVO��Ϣ
	 * @param id
	 * @return ��ת���ĵ��ﵥ��Ϣ
	 */
	public ArrayList<ArrivalOrder4TranCenVO> inquireA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥVO��Ϣ
	 * @param time
	 * @return ��ת���ĵ��ﵥ�б�
	 */
	public ArrayList<ArrivalOrder4TranCenVO> inquireB(String time);
	
	public ArrayList<ArrivalOrder4TranCenVO> inquireC();
	
	public void VOtoPO();
	
	public void POtoVO(int k);
	
	/**
	 * ǰ�ã�ҵ���Ѿ��������
	 * ���ã������˴���ת���ջغϣ��־û�������Ƶ�������������
	 */
	public void end();
}
