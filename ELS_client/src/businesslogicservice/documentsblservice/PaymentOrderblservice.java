package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.PaymentOrderVO;


public interface PaymentOrderblservice {
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
	public JavaBean1 add(PaymentOrderVO paymentOrderVO);

	/**
	 * 
	 * @param bussinessHall
	 * @param date
	 * ǰ��������Ҫɾ�����տ��Ϣ�ڳ־û��������м�¼
	 * ����������ɾ�������տ��Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList);
	
	/**
	 * 
	 * @param bussinessHall
	 * @param date
	 * @return
	 * ǰ��������Ҫ�޸ĵĸ����Ϣ��PO���м�¼
	 * �����������޸ĸ����Ϣ��������VO��PO
	 */
	public JavaBean1 modify(PaymentOrderVO paymentOrderVO);
	
	/**
	 * 
	 * @param id
	 * @return
	 * ǰ��������Ҫ��ѯ�ĸ����Ϣ�����ݳ־û��������м�¼
	 * �������������ظ��VO����
	 */
	public JavaBean1 inquireA(String id);
	
	/**
	 * time
	 * @param 
	 * @return
	 * ǰ��������Ҫ��ѯ�ĸ����Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public JavaBean1 inquireB(String date);
	
}
