package dataservice_client.mngerandaccountantdataservice;

import vo_client.StatisAnalyVO.BusinessSituationVO;
import vo_client.StatisAnalyVO.CostAndIncomeVO;
/**
 * ���ദ��Ͳ鿴ͳ�Ʒ����йص����ݲ㷽��
 * @author zt
 *
 */
public interface StatisAnalydataservice {
	/**
	 * ǰ��������
	 * �������������ɾ�Ӫ������ظ��߼���
	 * @param StartDate
	 * @param EndDate
	 * @return
	 */
	public BusinessSituationVO BS(String StartDate,String EndDate);
	
	/**
	 * ǰ��������
	 * �������������ɽ�ֹ��ǰ���ڵĳɱ�����������롢��֧����������=������-��֧�������ظ��߼���
	 * @return
	 */
	public CostAndIncomeVO CAI();
	
	/**
	 * ǰ����������֪���������֧��
	 * �����������������������֧�����������󷵻ظ��߼���
	 * @param income
	 * @param cost
	 * @return
	 */
	public double profit(double income,double cost);
}
