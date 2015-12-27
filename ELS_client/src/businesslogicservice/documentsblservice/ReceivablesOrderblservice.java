package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.ReceivablesOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

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
	public JavaBean1 add(ReceivablesOrderVO receivablesOrderVO);

	/**
	 * 
	 * @param id4courier
	 * @param date
	 * ǰ��������Ҫɾ�����տ��Ϣ�ڳ־û��������м�¼
	 * ����������ɾ�������տ��Ϣ
	 * 
	 */ 
	public ResultMessage deleteMany(ArrayList<String> idList);
	
	/**
	 * 
	 * @param id4courier
	 * @param date
	 * @return
	 * ǰ��������Ҫ�޸ĵ��տ��Ϣ��PO���м�¼
	 * �����������޸��տ��Ϣ��������VO��PO
	 */
	public JavaBean1 modify(ReceivablesOrderVO receivablesOrderVO);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 * ǰ��������Ҫ��ѯ���տ��Ϣ�����ݳ־û��������м�¼
	 * ����������������ؼ�¼���б�
	 */
	public JavaBean1 inquireA(String id);
	
	public JavaBean1 inqurieB(String date);

	public OrderlineitemVO addOrder(String orderId);

}
