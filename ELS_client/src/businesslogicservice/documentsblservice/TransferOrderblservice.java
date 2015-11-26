package businesslogicservice.documentsblservice;

import java.util.ArrayList;

import state.ResultMessage;
import state.TransportType;
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
	 * ǰ�ã��Ѵ���ת������ҳ��
	 * ���ã��Զ�������ת������
	 * @return ����
	 */
	public String generateDate();
	
	/**
	 * ǰ�ã���ת����ҵ��Ա�����������Ŀ�ĵ�
	 * ���ã��Զ������˷�
	 * @param sa
	 * @param ea
	 * @return �˷�
	 */
	public int generateFare(String sa,String ea);
	
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
	public ResultMessage addTransferOrder(TransferOrderVO transferOrderVO);
	
	/**
	 * ǰ�ã������������ת��Ϣ
	 * ���ã��Զ�������ת�����
	 * @return ��ת�����
	 */
	public String generateId();
	
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
	public ResultMessage modify(TransferOrderVO transferOrderVO);
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ڳ־û��������м�¼
	 * ���ã�ɾ��һ����ת��
	 * @param id
	 */
	public ResultMessage deleteone(String id);
	
	/**
	 * ǰ�ã�Ҫɾ������ת���ڳ־û��������м�¼
	 * ���ã�ɾ�������ת��
	 * @param id
	 */
	public ResultMessage deleteMany(ArrayList<String> idlist);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ڳ־û��������м�¼
	 * ���ã�����id��ѯĳ��ת��,������ת��VO��Ϣ
	 * @param id
	 * @return ��ת����Ϣ
	 */
	public TransferOrderVO inquireA(String id);
	
	/**
	 * ǰ�ã�Ҫ��ѯ����ת���ڳ־û��������м�¼
	 * ���ã�����ʱ���ѯĳ��ת��,������ת��VO��Ϣ
	 * @param time
	 * @return ��ת���б�
	 */
	public TransferOrderlineitemVO inquireB(String time);
	
	public TransferOrderlineitemVO getTransferOrderlineitemVO(String id);
	
	/**
	 * ǰ�ã�ҵ���Ѿ��������
	 * ���ã������˴���ת�غϣ��־û�������Ƶ�������������
	 */
	public void end();
}
