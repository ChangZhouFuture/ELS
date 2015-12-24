package dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.JavaBean3;
import bean.JavaBean4;
import bean.JavaBean5;
import po.stockPO.StockPO;
import state.ResultMessage;


public interface Stockdataservice extends Remote{
	
	/**
	 * 
	 * ǰ�ã���������Ա�ѱ�ʶ�����Ȩ
	 * ���ã����ص���Ŀ����Ϣ
	 * @return
	 * @throws SQLException 
	 * 
	 */
	public JavaBean3 stockCount(String date) throws RemoteException;
	
	/**
	 * ǰ�ã���������Ա�ѱ�ʶ�����Ȩ
	 * ���ã��������������¿��
	 * 
	 * @return
	 */
	public ResultMessage adjustPartition(ArrayList<String> IDList,String area)
			throws RemoteException;
	
	/**
	 * ���ã���������
	 */
	public JavaBean4 stockAlarm() throws RemoteException;
	
	/**
	 * 
	 * ǰ�ã���������Ա�Ѿ��ѿ�ݷ��ڻ������
	 * ���ã���⣬��¼�µļ�λ״̬
	 * 
	 */
	public ResultMessage storage(StockPO po) throws RemoteException;
	
	/**
	 * 
	 * ǰ�ã���������Ա�Ѿ����ڻ�����ϵĿ��ȡ��
	 * ���ã����⣬��¼�µļ�λ״̬
	 * 
	 */
	public ResultMessage outBound(String id) throws RemoteException;
}
