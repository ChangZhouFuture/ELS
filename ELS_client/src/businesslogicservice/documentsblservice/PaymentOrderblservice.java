package businesslogicservice.documentsblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo.documentsVO.PaymentOrderVO;
import vo.lineitemVO.documentslineitemVO.PaymentOrderlineitemVO;


public interface PaymentOrderblservice {
	
	/**
	 * 
	 * @param accountName
	 * @return
	 * ǰ��������������Ա�Ѿ��������в���
	 * �����������ж��˻��Ƿ����
	 */
	public ResultMessage doesAccountExist(String accountName);
	
	/**
	 * 
	 * @param date4PaymentOrder
	 * @param amount4PaymentOrder
	 * @param remitter
	 * @param account4PaymentOrder
	 * @param item4Vehicles
	 * @param remark1
	 * @param remark2
	 * @return
	 * ǰ��������������Ա�Ѿ�����Ȩ�͵�¼
	 * ��������������µĸ����Ϣ
	 */
	public PaymentOrderVO add(String date4PaymentOrder, String amount4PaymentOrder, String remitter, String account4PaymentOrder,ArrayList<String>  item4Vehicles,ArrayList<String> remark1,ArrayList<String> remark2);
	/**
	 * 
	 * @param id
	 * @param bussinessHall
	 * @return
	 * ǰ��������Ҫɾ���ĸ����Ϣ��PO���м�¼
	 * ����������ɾ��һ�������Ϣ
	 * 
	 */
	public ResultMessage deleteOne(String date,String bussinessHall);

	/**
	 * 
	 * @param bussinessHall
	 * @param date
	 * ǰ��������Ҫɾ�����տ��Ϣ�ڳ־û��������м�¼
	 * ����������ɾ�������տ��Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> id4courier,ArrayList<String> date);
	
	/**
	 * 
	 * @param bussinessHall
	 * @param date
	 * @return
	 * ǰ��������Ҫ�޸ĵĸ����Ϣ��PO���м�¼
	 * �����������޸ĸ����Ϣ��������VO��PO
	 */
	public PaymentOrderVO modify(String bussinessHall,String date);
	
	/**
	 * 
	 * @param id
	 * @return
	 * ǰ��������Ҫ��ѯ�ĸ����Ϣ�����ݳ־û��������м�¼
	 * �������������ظ��VO����
	 */
	public PaymentOrderlineitemVO inquireA(String id);
	
	/**
	 * time
	 * @param 
	 * @return
	 * ǰ��������Ҫ��ѯ�ĸ����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public PaymentOrderlineitemVO inquireB(String time);
	
	/**
	 * ǰ�����������������
	 * ���������������ܸ������
	 */
	public void countAmount(ArrayList<String> OrderId);
	/**
	 * ǰ�������������Ϣ�������
	 * ����������������θ����Ϣ�����������ݳ־û�����
	 */
	public void end();
}
