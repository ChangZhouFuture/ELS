package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.ReceivablesOrderVO;
import vo_client.lineitemVO.documentslineitemVO.ReceivablesOrderlineitemVO;

public interface ReceivablesOrderblservice {
	/**
	 * 
	 * @param date4RO
	 * @param amount4RO
	 * @param courier4RO
	 * @param barCode
	 * @return
	 * ǰ��������Ӫҵ��ҵ��Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µ��տ��Ϣ
	 */
	public ReceivablesOrderVO add(String date4RO, String amount4RO, String courier4RO, ArrayList<String> barCode);
		
	/**
	 * 
	 * @param id
	 * @return
	 * ǰ��������Ҫɾ�����տ��Ϣ��PO���м�¼
	 * ����������ɾ��һ���տ��Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String date,String courierId);

	/**
	 * 
	 * @param id4courier
	 * @param date
	 * ǰ��������Ҫɾ�����տ��Ϣ�ڳ־û��������м�¼
	 * ����������ɾ�������տ��Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4courier,ArrayList<String> date);
	
	/**
	 * 
	 * @param id4courier
	 * @param date
	 * @return
	 * ǰ��������Ҫ�޸ĵ��տ��Ϣ��PO���м�¼
	 * �����������޸��տ��Ϣ��������VO��PO
	 */
	public ReceivablesOrderVO modify(String id4courier,String date);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * ǰ��������Ҫ��ѯ���տ��Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public ReceivablesOrderlineitemVO inquire(String keyword);
	
	/**
	 * ǰ���������տ��Ϣ�������
	 * ������������������տ��Ϣ�����������ݳ־û�����
	 */
	public void countCarriage(String depature,String destination);
	/**
	 * ǰ������������������
	 * ���������������������տ����
	 */
	public void countAmount(ArrayList<String> OrderId);
	/**
	 * ǰ���������տ��Ϣ�������
	 * ������������������տ��Ϣ�����������ݳ־û�����
	 */
	public void end();

}
