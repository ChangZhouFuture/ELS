package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;

import po.StatisAnalyPO.BusinessSituationPO;
import po.StatisAnalyPO.CostAndIncomePO;

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
	public BusinessSituationPO BS(String StartDate,String EndDate);
	
	/**
	 * ǰ��������
	 * �������������ɽ�ֹ��ǰ���ڵĳɱ�����������롢��֧����������=������-��֧�������ظ��߼���
	 * @return
	 */
	public CostAndIncomePO CAI();
	
	/**
	 * ǰ����������֪���������֧��
	 * �����������������������֧�����������󷵻ظ��߼���
	 * @param income
	 * @param cost
	 * @return
	 */
	public double profit(double income,double cost);
}
