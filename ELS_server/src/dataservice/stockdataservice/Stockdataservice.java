package dataservice.stockdataservice;

import java.rmi.Remote;

import bean.JavaBean3;
import bean.JavaBean4;
import po.stockPO.StockPO;
import po.stockPO.StorageListPO;
import state.ResultMessage;


public interface Stockdataservice extends Remote{
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * ǰ�ã���������Ա�Ѿ���ʶ�����Ȩ
	 * ���ã�������һʱ����ڵĿ��䶯��Ϣ
	 */
	public StockPO stockCheck(String startTime, String endTime);
	
	/**
	 * 
	 * ǰ�ã���������Ա�ѱ�ʶ�����Ȩ
	 * ���ã����ص���Ŀ����Ϣ
	 * @return
	 * 
	 */
	public JavaBean3 stockCount(String generateTime);
	
	/**
	 * ǰ�ã���������Ա�ѱ�ʶ�����Ȩ
	 * ���ã��������������¿��
	 * 
	 * @return
	 */
	public ResultMessage adjustPartition(String id,String area);
	
	/**
	 * ���ã���������
	 */
	public JavaBean4 stockAlarm();
	
	/**
	 * 
	 * ǰ�ã���������Ա�Ѿ��ѿ�ݷ��ڻ������
	 * ���ã���⣬��¼�µļ�λ״̬
	 * 
	 */
	public void storage(StorageListPO po);
	
	/**
	 * 
	 * ǰ�ã���������Ա�Ѿ����ڻ�����ϵĿ��ȡ��
	 * ���ã����⣬��¼�µļ�λ״̬
	 * 
	 */
	public void outBound(String id);
}
