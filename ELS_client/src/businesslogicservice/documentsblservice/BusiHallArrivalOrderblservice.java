package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
 
 /**
  * 
  * @author �쿡��
  * ������Ӫҵ�����ﵥ��ص�ҵ���߼�
  *
  */
 public interface BusiHallArrivalOrderblservice {
 	/**
 	 * ǰ�ã�Ҫ��ӵ���ת�������ݳ־û��������м�¼
 	 * ���ã������ת��lineitem��¼,����չʾ�㷵��VO
 	 * @param id
 	 * @return 
 	 */
 	public TransferOrderlineitemVO addTransferOrder(String id);
 	
 	/**
 	 * ǰ�ã�Ӫҵ��ҵ��Ա���������в���
 	 * ���ã�����һ��Ӫҵ�����ﵥ������VO��PO������VO��Ϣ��չʾ��
 	 * @param id
 	 * @param toid
 	 * @param sa
 	 * @param d
 	 * @param gs
 	 * @return һ��Ӫҵ�����ﵥ
 	 */
 	public JavaBean1 addBusiHallArrivalOrder(BusiHallArrivalOrderVO arrivalOrder4BusiHallVO);
 	
 	/**
 	 * ǰ�ã�Ҫ�޸ĵ�Ӫҵ�����ﵥ�ڳ־û��������м�¼
 	 * ���ã�����һ��Ӫҵ�����ﵥ������VO��PO������VO��Ϣ��չʾ��
 	 * @param id
 	 * @param toid
 	 * @param sa
 	 * @param d
 	 * @param gs
 	 * @return ���ĺ��Ӫҵ�����ﵥ
 	 */
 	public JavaBean1 modify(BusiHallArrivalOrderVO arrivalOrder4BusiHallVO);
 	
 	/**
 	 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ�ڳ־û��������м�¼
-	 * ���ã�ɾ�����Ӫҵ�����ﵥ
 	 * @param id
 	 */
 	public ResultMessage deleteMany(ArrayList<String> idlist);
 	
 	/**
 	 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ�ڳ־û��������м�¼
 	 * ���ã�����ʱ���ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥVO��Ϣ
 	 * @param id
 	 * @return Ӫҵ�����ﵥ��Ϣ
 	 */
 	public JavaBean1 inquireA(String id);
 	
 	/**
 	 * ǰ�ã�Ҫ��ѯ��Ӫҵ�����ﵥ�ڳ־û��������м�¼
 	 * ���ã�����ʱ���ѯĳӪҵ�����ﵥ,����Ӫҵ�����ﵥVO��Ϣ
 	 * @param time
 	 * @return Ӫҵ�����ﵥ�б�
 	 */
 	public JavaBean1 inquireB(String time);
 	
}
