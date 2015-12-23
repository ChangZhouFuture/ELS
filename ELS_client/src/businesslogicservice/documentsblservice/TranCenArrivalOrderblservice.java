package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.TranCenArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;

/**
 * 
 * @author �쿡��
 * ��������ת���ĵ��ﵥ��ص�ҵ���߼�
 *
 */
public interface TranCenArrivalOrderblservice {
	/**
	 * ǰ�ã��Ѵ���ת���ĵ��ﵥ����ҳ��
	 * �ж���ת���Ƿ����
	 * @param id
	 * @return �Ƿ����
	 */
	public TransferOrderlineitemVO addTransferOrder(String id);
	
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
	public JavaBean1 addTranCenArivalOrder(TranCenArrivalOrderVO tranCenArrivalOrderVO);
	
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
	public ResultMessage modify(TranCenArrivalOrderVO arrivalOrder4TranCenVO);
	
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
	public JavaBean1 inquireA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ĵ��ﵥ�ڳ־û��������м�¼
	 * ���ã�����ʱ���ѯĳ��ת���ĵ��ﵥ,������ת���ĵ��ﵥVO��Ϣ
	 * @param time
	 * @return ��ת���ĵ��ﵥ�б�
	 */
	public JavaBean1 inquireB(String time);
	
}
