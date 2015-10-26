package businesslogic_client.informngmtbl;

import state.Gender;
import state.PayType;
import state.Position;
import vo_client.informngmtVO.StaffAndAgencyVO;
import vo_client.lineitemVO.informngmtlineitemVO.StaffAndAgencylineitemVO;
import businesslogicservice_client.informngmtblservice.StaffAndAgencyblservice;

public class StaffAndAgency implements StaffAndAgencyblservice {

	@Override
	public StaffAndAgencylineitemVO inquireList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffAndAgencyVO inquire(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffAndAgencyVO add(String id, String name, int age, Gender Gender,
			Position position, PayType paytype, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffAndAgencyVO modify(String id, String name, int age,
			Gender gender, Position position, PayType paytype, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void endSAA() {
		// TODO Auto-generated method stub

	}

}
