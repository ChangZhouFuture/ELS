package dataservice_client_Stub.informngmtdataservice_Stub;

import dataservice_client.informngmtdataservice.StaffAndAgencydataservice;
import po_client.informngmtPO.StaffAndAgencyPO;
import state.Gender;
import state.PayType;
import state.Position;
import vo_client.lineitemVO.informngmtlineitemVO.StaffAndAgencylineitemVO;

public class StaffAndAgencydataservice_Stub implements StaffAndAgencydataservice{

	@Override
	public StaffAndAgencylineitemVO inquireList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffAndAgencyPO inquire(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffAndAgencyPO add(String id, String name, int age, Gender Gender, Position position, PayType paytype,
			double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffAndAgencyPO modify(String id, String name, int age, Gender gender, Position position, PayType paytype,
			double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
