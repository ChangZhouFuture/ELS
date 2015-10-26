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
		
		//此处传入VO所有参数，记录olVO
		olVO=new OperaLogVO(position,name, date, action);
		System.out.println("显示日志：");
        //此处调用数据层方法，更新PO
		return olVO;
	}

	@Override
	public OperaLoglineitemVO inquireB(String id) {
		// TODO Auto-generated method stub
		System.out.println("该人员操作日志：");
		return null;
	}

	@Override
	public OperaLoglineitemVO inquireC(String date) {
		// TODO Auto-generated method stub
		System.out.println("该日期的操作日志：");
		return null;
	}
}
