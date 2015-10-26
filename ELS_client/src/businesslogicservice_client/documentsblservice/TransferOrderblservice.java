package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.ResultMessage;
import state.TransportType;
import vo_client.documentsVO.TransferOrderVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;

/**
 * 
 * @author �쿡��
 * ��������ת����ص�ҵ���߼�
 *
 */
public interface TransferOrderblservice {
	
	/**
	 * �Ѵ���ת������ҳ��
	 * ��ת�����Ƿ����
	 * @param tcid
	 * @return �Ƿ����
	 */
	public ResultMessage addTransferCenter(String tcid);
	
	/**
	 * �Ѵ���ת������ҳ��
	 * ���Ӷ���
	 * @param orderid
	 * @return 
	 */
	public ArrayList<String> addOrder(String orderid);
	
	/**
	 * �Ѵ���ת������ҳ��
	 * ϵͳ�Զ���������
	 * @return ����
	 */
	public String getDate();
	
	/**
	 * �����������Ŀ�ĵ�
	 * ϵͳ�Զ������˷�
	 * @param sa
	 * @param ea
	 * @return �˷�
	 */
<<<<<<< HEAD
	public int getFare(String sa,String ea);
=======
	public int generateFare(String sa,String ea);
>>>>>>> parent of a4837a0... data接口及VOPO（已完成）
	/**
	 * ѡ��������ת��
	 * ����һ����ת��������VO��PO������VO��Ϣ��չʾ��
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
	public TransferOrderVO addTransferOrder(String id,TransportType tst,String sa,String ea,ArrayList<String> orderidlist,String d,String hbid,String hgid,String Jzy);
	
	/**
	 * ǰ�ã���ѡ��������ת�������������Ϣ
	 * �Զ�������ת�����
	 * @return ��ת�����
	 */
	public String generateId();
	
	/**
	 * ǰ�ã���ѡ����ĵ���ת��
	 * ����һ����ת��������VO��PO������VO��Ϣ��չʾ��
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
	public TransferOrderVO modify(String id,TransportType tst,String sa,String ea,ArrayList<String> orderidlist,String d,String hbid,String hgid,String Jzy);
	
	/**
	 * ǰ�ã�����һ����ת�غ�
	 * ɾ��һ����ת��
	 * @param id
	 */
	public void deleteone(String id);
	
	/**
	 * ǰ�ã�����һ����ת�غ�
	 * ɾ�������ת��
	 * @param id
	 */
	public void deleteMany(ArrayList<String> id);
	
	/**
	 * ǰ�ã�����һ����ת�غ�
	 * ͨ��ID����ĳ����ת��
	 * @param id
	 * @return ��ת����Ϣ
	 */
	public TransferOrderVO inquireA(String id);
	
	/**
	 * ǰ�ã�����һ����ת�غ�
	 * ��ʱ�������ת���б�
	 * @param time
	 * @return ��ת���б�
	 */
	public TransferOrderlineitemVO inquireB(String time);
	
	/**
	 * ǰ�ã���������ɾ�Ĳ����
	 * �����˴���ת�غϣ��־û�������Ƶ�������������
	 */
	public void end();
}
