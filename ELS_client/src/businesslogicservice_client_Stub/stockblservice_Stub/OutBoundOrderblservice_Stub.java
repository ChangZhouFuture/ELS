package businesslogicservice_client_Stub.stockblservice_Stub;

import java.util.ArrayList;

import businesslogicservice_client.stockblservice.OutBoundOrderblservice;
import state.ResultMessage;
import vo_client.lineitemVO.stocklineitemVO.OutBoundOrderlineitemVO;
import vo_client.orderVO.OrderVO;
import vo_client.stockVO.OutBoundOrderVO;

public class OutBoundOrderblservice_Stub implements OutBoundOrderblservice{
	OutBoundOrderVO oboVO;
	OutBoundOrderlineitemVO obolineitemVO;
	OrderVO oVO;
	String id4obo;
	String id4e;
	String id4to;
	String desti;
	String time;
	
	@Override
	public OutBoundOrderlineitemVO addExpress(String id) {
		// TODO Auto-generated method stub
		// 此处根据id把对应的OutBoundOrderlineitemVO赋值给obolineitemVO
		
		System.out.println("增加快件成功");
		return obolineitemVO;
	}

	@Override
	public void generateId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateTime() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public OutBoundOrderVO add(String id4e, String id4to, String desti) {
		// TODO Auto-generated method stub
		this.id4e = id4e;
		this.id4to = id4to;
		this.desti = desti;
	
//		此处传入VO所有参数，记录oboVO（PO和VO的单号是一样的）；
		oboVO = new OutBoundOrderVO(this.id4e, this.desti, this.id4to, this.id4obo, this.time);
		
		
//		此处调用数据层的增加出库单方法，更新PO
		
		endOBO();
		return oboVO;
	}

	@Override
	public ResultMessage deleteone(String id4bob) {
		// TODO Auto-generated method stub
		//处理删除 调用数据层方法 更新 PO
		
		//处理删除 更新VO
		
		endOBO();
		System.out.println("删除一个出库单成功");
		return null;
	}
	
	@Override
	public ResultMessage deleteMany(ArrayList<String> id4OBO) {
		// TODO Auto-generated method stub
		//处理删除 调用数据层方法 更新PO
		
		//处理删除 更新VO
		
		endOBO();
		System.out.println("删除多个出库单成功");
		return null;
	}

	@Override
	public OutBoundOrderVO modify(String id4obo, String id4e, String id4to,
			String desti) {
		// TODO Auto-generated method stub
		//调用数据层的修改方法，修改PO
		
		endOBO();
		return null;
	}
	
	@Override
	public OutBoundOrderVO inquireA(String id) {
		// TODO Auto-generated method stub
		
		return oboVO;
	}
	
	@Override
	public OutBoundOrderVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void endOBO() {
		// TODO Auto-generated method stub
		
		//此处调用数据层的Update方法
		
		System.out.println("结束对出库单处理");
	}


}
