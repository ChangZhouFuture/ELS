package businesslogicservice_client_Stub.mngerandaccountantblservice_Stub;

import businesslogicservice_client.mngerandaccountantblservice.ApproDocmblservice;
import vo_client.ParentVO;
import vo_client.lineitemVO.ParentlineitemVO;

public class ApproDocmblservice_Stub implements ApproDocmblservice{

	@Override
	public ParentlineitemVO chooseKind(String kind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParentVO inquire(String id) {
		// TODO Auto-generated method stub
		System.out.println("单据信息：");
		return null;
	}

	@Override
	public ParentVO modify() {
		// TODO Auto-generated method stub
		System.out.println("修改成功");
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		System.out.println("删除成功");
	}

	@Override
	public void finishApprove(String id) {
		// TODO Auto-generated method stub
		System.out.println("完成审批");
	}

	@Override
	public void mark() {
		// TODO Auto-generated method stub
		System.out.println("已完成批量审批");
	}

	@Override
	public void endAD() {
		// TODO Auto-generated method stub
		System.out.println("审批单据结束");
	}
    
}
