package businesslogicservice.documentsblservice;
import java.util.ArrayList;

import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.BusiHallLoadingListVO;
import vo.lineitemVO.documentslineitemVO.BusiHallLoadingListlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

/**
 * 
 * @author �쿡��
 * ������װ������ص�ҵ���߼�
 *
 */
public interface BusiHallLoadingListblservice {
	
	/**
	 * ǰ�ã�����һ���½����޸�װ�����غ�
	 * ���ã���װ����������һ�������ţ�����չʾ�㱾�����п�����
	 * @param orderid
	 * @return 
	 */
	public OrderlineitemVO addOrder(String orderid);
	
	/**
	 * ǰ�ã�Ӫҵ��ҵ��Ա���������в���
	 * ���ã�����һ��װ����������VO��PO������VO��Ϣ��չʾ��
	 * @param id
	 * @param bhid
	 * @param tlid
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param vid
	 * @param f
	 * @param Jzy
	 * @param Yyy
	 * @return һ��װ����
	 */
	public JavaBean1 addBusinessHallLoadingList(BusiHallLoadingListVO businessHallLoadingListVO);
 	
 	/**
 	 * ǰ�ã�Ҫ�޸ĵ�װ�����ڳ־û��������м�¼
 	 * ���ã�����һ��װ����������VO��PO������VO��Ϣ��չʾ��
 	 * @param id
 	 * @param bhid
 	 * @param tlid
 	 * @param ea
 	 * @param orderidlist
 	 * @param d
 	 * @param vid
 	 * @param f
 	 * @param Jzy
 	 * @param Yyy
 	 * @return ���ĺ��װ����
 	 */
 	public JavaBean1 modify(BusiHallLoadingListVO businessHallLoadingListVO);
 	
 	/**
 	 * ǰ�ã�Ҫɾ����װ�����ڳ־û��������м�¼
 	 * ���ã�ɾ�����װ����
 	 * @param id
 	 */
public ResultMessage deleteMany(ArrayList<String> idlist);
 	
 	/**
 	 * ǰ�ã�Ҫ��ѯ��װ�����ڳ־û��������м�¼
 	 * ���ã�����ʱ���ѯĳװ����,����װ����VO��Ϣ
 	 * @param id
 	 * @return װ������Ϣ
 	 */
 	public JavaBean1 inquireA(String id);
 	
 	/**
 	 * ǰ�ã�Ҫ��ѯ��װ�����ڳ־û��������м�¼
 	 * ���ã�����ʱ���ѯĳװ����,����װ����VO��Ϣ
 	 * @param time
 	 * @return װ�����б�
 	 */
 	public JavaBean1 inquireB(String time);
 	
 }
