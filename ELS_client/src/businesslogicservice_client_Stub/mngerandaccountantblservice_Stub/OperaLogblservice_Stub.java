package businesslogicservice_client_Stub.mngerandaccountantblservice_Stub;

import businesslogicservice_client.mngerandaccountantblservice.OperaLogblservice;
import vo_client.OperaLogVO;
import vo_client.lineitemVO.OperaLoglineitemVO;

public class OperaLogblservice_Stub implements OperaLogblservice{
	OperaLogVO olVO;
	OperaLoglineitemVO olliVO;
	String position;
	String name;
    String date;
	String action;

	@Override
	public OperaLogVO inquireA(String id, String date) {
		// TODO Auto-generated method stub
		this.date=date;
		
		//�˴�����VO���в�������¼olVO
		olVO=new OperaLogVO(position,name, date, action);
		System.out.println("��ʾ��־��");
        //�˴��������ݲ㷽��������PO
		return olVO;
	}

	@Override
	public OperaLoglineitemVO inquireB(String id) {
		// TODO Auto-generated method stub
		System.out.println("����Ա������־��");
		return null;
	}

	@Override
	public OperaLoglineitemVO inquireC(String date) {
		// TODO Auto-generated method stub
		System.out.println("�����ڵĲ�����־��");
		return null;
	}
}
