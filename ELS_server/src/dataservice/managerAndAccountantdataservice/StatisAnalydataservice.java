package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import bean.JavaBean1;
/**
 * ���ദ��Ͳ鿴ͳ�Ʒ����йص����ݲ㷽��
 * @author zt
 *
 */
public interface StatisAnalydataservice extends Remote{

	/**
	 * ǰ��������
	 * �������������ɽ�ֹ��ǰ���ڵĳɱ�����������롢��֧����������=������-��֧�������ظ��߼���
	 * @return
	 */
	public JavaBean1 CostAndIncome() throws RemoteException;
	

}
