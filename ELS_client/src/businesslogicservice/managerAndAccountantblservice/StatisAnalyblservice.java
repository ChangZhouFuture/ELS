package businesslogicservice.managerAndAccountantblservice;

import vo.StatisAnalyVO.BusinessSituationVO;
import vo.StatisAnalyVO.CostAndIncomeVO;

/**
 * 
 * @author zt
 * ���ദ���й�ͳ�Ʒ�����ҵ���߼�
 */

public interface StatisAnalyblservice {
	/**
	 * ǰ�������������鿴��Ӫ�����
	 * �������������ݿ�ʼ���ںͽ������ڣ���ʾ�ڼ������е������տ��Ϣ
	 * @param StartDate
	 * @param EndDate
	 * @return
	 */
	public BusinessSituationVO BS(String StartDate,String EndDate);
	
	/**
	 * ǰ�������������鿴�ɱ������
	 * �������������ɽ�ֹ��ǰ���ڵĳɱ�������������롢��֧����������=������-��֧����
	 * @return
	 */
	public CostAndIncomeVO CAI();
	
	/**
	 * ǰ����������֪���������֧��
	 * �����������������������֧������������
	 * @param income
	 * @param cost
	 * @return
	 */
	public double profit(double income,double cost);
}