package dataservice_client_Stub.mngerandaccountantdataservice_Stub;

import dataservice_client.mngerandaccountantdataservice.OperaLogdataservice;
import vo_client.OperaLogVO;
import vo_client.lineitemVO.OperaLoglineitemVO;

public class OperaLogdataservice_Stub implements OperaLogdataservice{

	@Override
	public OperaLogVO inquireA(String id, String date) {
		// TODO Auto-generated method stub
		System.out.println("该日志信息：");
		return null;
	}

	@Override
	public OperaLoglineitemVO inquireB(String id) {
		// TODO Auto-generated method stub
		System.out.println("该人员所有日志：");
		return null;
	}

	@Override
	public OperaLoglineitemVO inquireC(String date) {
		// TODO Auto-generated method stub
		System.out.println("该日期所有日志：");
		return null;
	}

}
