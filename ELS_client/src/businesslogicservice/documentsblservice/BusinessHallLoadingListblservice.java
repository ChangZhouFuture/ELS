package businesslogicservice.documentsblservice;
import java.util.ArrayList;

import state.ResultMessage;
import vo.documentsVO.BusinessHallLoadingListVO;
import vo.lineitemVO.documentslineitemVO.BusinessHallLoadingListlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

/**
 * 
 * @author �쿡��
 * ������װ������ص�ҵ���߼�
 *
 */
public interface BusinessHallLoadingListblservice {
	/**
	 * ǰ�ã��Ѵ�װ��������ҳ��
	 * Ӫҵ���Ƿ����
	 * @param bhid
	 * @return �Ƿ����
	 */
	public ResultMessage addBusiHall(String bhid);
	
	/**
	 * ǰ�ã�����һ���½����޸�װ�����غ�
	 * ���ã���װ����������һ�������ţ�����չʾ�㱾�����п�����
	 * @param orderid
	 * @return 
	 */
	public OrderlineitemVO addOrder(String orderid);
	
	/**
	 * ǰ�ã��Ѵ�װ��������ҳ��
	 * ���ã��Զ�����װ��������
	 * @return ����
	 */
	public String generateDate();
	
	/**
	 * ǰ�ã�Ӫҵ��ҵ��Ա������Ӫҵ����ź�����
	 * ���ã��Զ��������˱��
	 * @param bhid
	 * @param d
	 * @return
	 */
	public String generateTranLoadId(String bhid,String d);
	
	/**
	 * ǰ�ã�Ӫҵ��ҵ��Ա�����������Ŀ�ĵ�
	 * ���ã��Զ������˷�
	 * @param sa
	 * @param ea
	 * @return �˷�
	 */
	public int generateFare(String sa,String ea);
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
public BusinessHallLoadingListVO addLoadingList(String id,String bhid,String tlid,String ea,ArrayList<String> oidl,String d,String vid,int f,String Jzy,String Yyy);
 	
 	/**
 	 * ǰ�ã�����������װ����Ϣ
 	 * ���ã��Զ�����װ�������
 	 * @return װ�������
 	 */
 	public String generateId();
 	
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
 	public BusinessHallLoadingListVO modify(String id,String bhid,String tlid,String ea,ArrayList<String> orderidlist,String d,String vid,int f,String Jzy,String Yyy);
 	
 	/**
 	 * ǰ�ã�Ҫɾ����װ�����ڳ־û��������м�¼
 	 * ���ã�ɾ��һ��װ����
 	 * @param id
 	 */
 	public ResultMessage deleteone(String id);
 	
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
 	public BusinessHallLoadingListVO inquireA(String id);
 	
 	/**
 	 * ǰ�ã�Ҫ��ѯ��װ�����ڳ־û��������м�¼
 	 * ���ã�����ʱ���ѯĳװ����,����װ����VO��Ϣ
 	 * @param time
 	 * @return װ�����б�
 	 */
 	public BusinessHallLoadingListlineitemVO inquireB(String time);
 	
 	/**
 	 * ǰ�ã�ҵ���Ѿ��������
 	 * ���ã������˴�װ���غϣ��־û�������Ƶ�������������
 	 */
 	public void end();
 }