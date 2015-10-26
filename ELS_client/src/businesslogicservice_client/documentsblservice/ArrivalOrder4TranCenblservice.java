package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4TranCenVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4TranCenlineitemVO;

/**
 * 
 * @author �쿡��
 * ��������ת���ĵ��ﵥ��ص�ҵ���߼�
 *
 */
public interface ArrivalOrder4TranCenblservice {
	/**
	 * �Ѵ���ת���ĵ��ﵥ����ҳ��
	 * ͨ����ת��ID��ȡ������
	 * @param id
	 * @return ������
	 */
	public String getStartAddress(String toid);
	
	/**
	 * �Ѵ���ת���ĵ��ﵥ����ҳ��
	 * �ж���ת���Ƿ����
	 * @param id
	 * @return �Ƿ����
	 */
	public ResultMessage addTransferOrder(String id);
	
	/**
	 * �Ѵ���ת���ĵ��ﵥ����ҳ��
	 * ϵͳ�Զ���������
	 * @return ����
	 */
	public String getDate();
	
	/**
	 * �Ѵ���ת���ĵ��ﵥ����ҳ��
	 * ѡ�����״̬
	 * @return ���ﵽ��״̬
	 */
	public GoodState getGoodState();
	
	/**
	 * ѡ��������ת���ĵ��ﵥ
	 * ����һ����ת���ĵ��ﵥ������VO��PO������VO��Ϣ��չʾ��
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @param tcid
	 * @return һ����ת���ĵ��ﵥ
	 */
	public ArrivalOrder4TranCenVO addArrivalOrder4TranCen(String id,String toid,String sa,String d,String gs,String tcid);
	
	/**
	 * ǰ�ã���ѡ��������ת���ĵ��ﵥ�����������Ϣ
	 * �Զ�������ת���ĵ��ﵥ���
	 * @return ��ת���ĵ��ﵥ
	 */
	public String generateId();
	
	/**
	 * ǰ�ã���ѡ����ĵ���ת���ĵ��ﵥ
	 * ����һ����ת���ĵ��ﵥ������VO��PO������VO��Ϣ��չʾ��
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @param tcid
	 * @return ���ĺ����ת���ĵ��ﵥ
	 */
	public ArrivalOrder4TranCenVO modify(String id,String toid,String sa,String d,String gs,String tcid);
	
	/**
	 * ǰ�ã�����һ����ת���ջغ�
	 * ɾ��һ����ת���ĵ��ﵥ
	 * @param id
	 */
	public void deleteone(String id);
	
	/**
	 * ǰ�ã�����һ����ת���ջغ�
	 * ɾ�������ת���ĵ��ﵥ
	 * @param id
	 */
	public void deleteMany(ArrayList<String> id);
	
	/**
	 * ǰ�ã�����һ����ת���ջغ�
	 * ͨ��ID����ĳ����ת���ĵ��ﵥ
	 * @param id
	 * @return ��ת���ĵ��ﵥ��Ϣ
	 */
	public ArrivalOrder4TranCenVO inquireA(String id);
	
	/**
	 * ǰ�ã�����һ����ת���ջغ�
	 * ��ʱ�������ת���ĵ��ﵥ�б�
	 * @param time
	 * @return ��ת���ĵ��ﵥ�б�
	 */
	public ArrivalOrder4TranCenlineitemVO inquireB(String time);
	
	/**
	 * ǰ�ã���������ɾ�Ĳ����
	 * �����˴���ת���ջغϣ��־û�������Ƶ�������������
	 */
	public void end();
}
