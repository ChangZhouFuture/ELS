package businesslogicservice.stockblservice;

import po.stockPO.StorageListPO;
import bean.JavaBean3;
import bean.JavaBean5;
import state.ResultMessage;

public interface Stockblservice {
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * ǰ�ã���������Ա�Ѿ���ʶ�����Ȩ
	 * ���ã�������һʱ����ڵĿ��䶯��Ϣ
	 */
	public JavaBean5 stockCheck(String startDate, String endDate);
	
	/**
	 * 
	 * ǰ�ã���������Ա�ѱ�ʶ�����Ȩ
	 * ���ã����ص���Ŀ����Ϣ
	 * @return
	 * 
	 */
	public JavaBean3 stockCount();
	
	/**
	 * ǰ�ã���������Ա�ѱ�ʶ�����Ȩ
	 * ���ã��������������¿��
	 * 
	 * @return
	 */
	public ResultMessage adjustPartition();
	
	/**
	 * ���ã���������
	 */
	public void stockAlarm();
	
	/**
	 * 
	 * ǰ�ã���������Ա�Ѿ��ѿ�ݷ��ڻ������
	 * ���ã���⣬��¼�µļ�λ״̬
	 * 
	 */
	public ResultMessage storage(StorageListPO po);
	
	/**
	 * 
	 * ǰ�ã���������Ա�Ѿ����ڻ�����ϵĿ��ȡ��
	 * ���ã����⣬��¼�µļ�λ״̬
	 * 
	 */
	public ResultMessage outBound(String id);
}
