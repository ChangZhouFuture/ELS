package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.TransferOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

/**
 * 
 * @author �쿡��
 * ��������ת����ص�ҵ���߼�
 *
 */
public interface TransferOrderblservice {
	
	/**
	 * ǰ�ã�����һ���½����޸���ת���غ�
	 * ���ã�����ת��������һ�������ţ�����չʾ�㱾�����п�����
	 * @param orderid
	 * @return 
	 */
	public OrderlineitemVO addOrder(String orderId);
	
	/**
	 * ǰ�ã���ת����ҵ��Ա���������в���
	 * ���ã�����һ����ת��������VO��PO������VO��Ϣ��չʾ��
	 * @param id
	 * @param tst
	 * @param sa
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param hbid
	 * @param hgid
	 * @param Jzy
	 * @return һ����ת��
	 */
	public JavaBean1 addTransferOrder(TransferOrderVO transferOrderVO);
	
	/**
	 * ǰ�ã�Ҫ�޸ĵ���ת���ڳ־û��������м�¼
	 * ���ã�����һ����ת��������VO��PO������VO��Ϣ��չʾ��
	 * @param id
	 * @param tst
	 * @param sa
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param hbid
	 * @param hgid
	 * @param Jzy
	 * @return ���ĺ����ת��
	 */
	public JavaBean1 modify(TransferOrderVO transferOrderVO);
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ڳ־û��������м�¼
	 * ���ã�ɾ�������ת��
	 * @param id
	 */
	public ResultMessage delete(ArrayList<String> idList);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ڳ־û��������м�¼
	 * ���ã�����id��ѯĳ��ת��,������ת��VO��Ϣ
	 * @param id
	 * @return ��ת����Ϣ
	 */
	public JavaBean1 inquireA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ڳ־û��������м�¼
	 * ���ã�����ʱ���ѯĳ��ת��,������ת��VO��Ϣ
	 * @param time
	 * @return ��ת���б�
	 */
	public JavaBean1 inquireB(String time);
		
}
