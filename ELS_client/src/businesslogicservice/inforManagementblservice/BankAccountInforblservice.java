package businesslogicservice.inforManagementblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo.inforManagementVO.BankAccountVO;

/**
 * 
 * @author �ܳ�
 * ������Ҫ�����������˻���Ϣ��ص�ҵ���߼�
 */
public interface BankAccountInforblservice {
	
	public ResultMessage add(BankAccountVO vo);
	
	public ResultMessage deleteOne(String Id);
	
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	public ResultMessage modify(BankAccountVO vo);
	
	public BankAccountVO find(String Id);
}
