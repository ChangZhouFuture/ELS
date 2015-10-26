package businesslogicservice_client_Stub.informngmtblservice_Stub;

import businesslogicservice_client.informngmtblservice.StaffAndAgencyblservice;
import state.Gender;
import state.PayType;
import state.Position;
import vo_client.informngmtVO.StaffAndAgencyVO;
import vo_client.lineitemVO.informngmtlineitemVO.StaffAndAgencylineitemVO;

public class StaffAndAgencyblservice_Stub implements StaffAndAgencyblservice {
    
	StaffAndAgencyVO saaVO;
	String id;
	String name;
	int age;
	Gender gender;
	Position position;
	PayType paytype;
	double amount;
	
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
	public StaffAndAgencyVO add(String id, String name, int age, Gender gender, Position position, PayType paytype,
			double amount) {
		// TODO Auto-generated method stub
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.position=position;
		this.paytype=paytype;
		this.amount=amount;
		
//		此处传入VO所有参数，记录saaVO
		saaVO=new StaffAndAgencyVO(this.id, this.name, this.age, this.gender, this.position, this.paytype,
				this.amount);
		
//      此处调用数据库方法，更新PO
		return saaVO;
	}

	@Override
	public StaffAndAgencyVO modify(String id, String name, int age, Gender gender, Position position, PayType paytype,
			double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		System.out.println("删除成功");
	}

	@Override
	public void endSAA() {
		// TODO Auto-generated method stub
		System.out.println("结束人员机构管理");
	}
    
}
