package dataservice_client_Stub.mngerandaccountantdataservice_Stub;

import dataservice_client.mngerandaccountantdataservice.Approdocmdataservice;
import vo_client.ParentVO;

public class Approdocmdataservice_Stub implements Approdocmdataservice{

	@Override
	public ParentVO inquireA(String id) {
		// TODO Auto-generated method stub
		System.out.println("该单据信息：");
		return null;
	}

	@Override
	public ParentVO inquireB(String kind) {
		// TODO Auto-generated method stub
		System.out.println("该种单据列表：");
		return null;
	}

	@Override
	public ParentVO inquireC(String date) {
		// TODO Auto-generated method stub
		System.out.println("该日期单据列表：");
		return null;
	}

	@Override
	public ParentVO modify() {
		// TODO Auto-generated method stub
		System.out.println("修改成功");
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("更新成功");
	}

}
