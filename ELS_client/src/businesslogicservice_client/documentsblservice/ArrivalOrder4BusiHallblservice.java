package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4BusiHallVO;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4BusiHalllineitemVO;
import vo_client.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;

/**
 * 
 * @author �쿡��
 * ������Ӫҵ�����ﵥ��ص�ҵ���߼�
 *
 */
public interface ArrivalOrder4BusiHallblservice {
	/**
	 * �Ѵ�Ӫҵ�����ﵥ����ҳ��
	 * ͨ����ת��ID��ȡ������
	 * @param id
	 * @return ������
	 */
	public String getStartAddress(String id);
	
	/**
	 * �Ѵ�Ӫҵ�����ﵥ����ҳ��
	 * �ж���ת���Ƿ����
	 * @param id
	 * @return �Ƿ����
	 */
	public ResultMessage addTransferOrder(String id);
	
	/**
	 * �Ѵ�Ӫҵ�����ﵥ����ҳ��
	 * ϵͳ�Զ���������
	 * @return ����
	 */
	public String getDate();
	
	/**
	 * �Ѵ�Ӫҵ�����ﵥ����ҳ��
	 * ѡ�����״̬
	 * @return ���ﵽ��״̬
	 */
	public GoodState getGoodState();
	
	/**
	 * ѡ������Ӫҵ�����ﵥ
	 * ����һ��Ӫҵ�����ﵥ������VO��PO������VO��Ϣ��չʾ��
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @return һ��Ӫҵ�����ﵥ
	 */
	public ArrivalOrder4BusiHallVO addArrivalOrder4BusiHall(String id,String toid,String sa,String d,String gs);
	
	/**
	 * ǰ�ã���ѡ������Ӫҵ�����ﵥ�����������Ϣ
	 * �Զ�����Ӫҵ�����ﵥ���
	 * @return Ӫҵ�����ﵥ���
	 */
	public String generateId();
	
	/**
	 * ǰ�ã���ѡ����ĵ�Ӫҵ�����ﵥ
	 * ����һ��Ӫҵ�����ﵥ������VO��PO������VO��Ϣ��չʾ��
	  * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @return ���ĺ��Ӫҵ�����ﵥ
	 */
	public ArrivalOrder4BusiHallVO modify(String id,String toid,String sa,String d,String gs);
	
	/**
<<<<<<< HEAD
	 * ǰ�ã�����һ��Ӫҵ�����ջغ�
	 * ɾ��һ��Ӫҵ�����ﵥ
=======
	 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ�ڳ־û��������м�¼
	 * ���ã�ɾ��һ��Ӫҵ�����ﵥ
<<<<<<< HEAD
>>>>>>> parent of a4837a0... data接口及VOPO（已完成）
=======
>>>>>>> parent of a4837a0... data接口及VOPO（已完成）
	 * @param id
	 */
	public void deleteone(String id);
	
	/**
<<<<<<< HEAD
	 * ǰ�ã�����һ��Ӫҵ�����ջغ�
	 * ɾ�����Ӫҵ�����ﵥ
=======
	 * ǰ�ã�Ҫɾ����Ӫҵ�����ﵥ�ڳ־û��������м�¼
	 * ���ã�ɾ�����Ӫҵ�����ﵥ
<<<<<<< HEAD
>>>>>>> parent of a4837a0... data接口及VOPO（已完成）
=======
>>>>>>> parent of a4837a0... data接口及VOPO（已完成）
	 * @param id
	 */
	public void deleteMany(ArrayList<String> id);
	
	/**
	 * ǰ�ã�����һ��Ӫҵ�����ջغ�
	 * ͨ��ID����ĳ��Ӫҵ�����ﵥ
	 * @param id
	 * @return Ӫҵ�����ﵥ��Ϣ
	 */
	public ArrivalOrder4BusiHallVO inquireA(String id);
	
	/**
	 * ǰ�ã�����һ��Ӫҵ�����ջغ�
	 * ��ʱ�����Ӫҵ�����ﵥ�б�
	 * @param time
	 * @return Ӫҵ�����ﵥ�б�
	 */
	public ArrivalOrder4BusiHalllineitemVO inquireB(String time);
	
	/**
	 * ǰ�ã���������ɾ�Ĳ����
	 * �����˴�Ӫҵ�����ջغϣ��־û�������Ƶ�������������
	 */
	public void end();
}
