package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;

import bean.JavaBean1;
/**
 * ���ദ��Ͳ鿴ͳ�Ʒ����йص����ݲ㷽��
 * @author zt
 *
 */
public interface StatisAnalydataservice extends Remote{
	/**
	 * ǰ��������
	 * �������������ɾ�Ӫ������ظ��߼���
	 * @param StartDate
	 * @param EndDate
	 * @return
	 */
	public JavaBean1 BusinessSituation(String StartDate,String EndDate);
	
	/**
	 * ǰ��������
	 * �������������ɽ�ֹ��ǰ���ڵĳɱ�����������롢��֧����������=������-��֧�������ظ��߼���
	 * @return
	 */
	public JavaBean1 CostAndIncome(String date);
	

}
