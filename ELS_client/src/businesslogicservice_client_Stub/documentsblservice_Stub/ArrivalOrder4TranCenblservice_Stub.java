package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4TranCenVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4TranCenlineitemVO;
import businesslogicservice_client.documentsblservice.ArrivalOrder4TranCenblservice;

public class ArrivalOrder4TranCenblservice_Stub implements ArrivalOrder4TranCenblservice{
	String id;
	String tranorderoid;
	String startaddress;
	String date;
	GoodState goodstate;
	String trancenterid;
	ArrivalOrder4TranCenVO aotc;
	@Override
	public String generateStartAddress(String toid) {
		// TODO Auto-generated method stub
		//此处根据id返回出发地
		return null;
	}

	@Override
	public ResultMessage addTransferOrder(String id) {
		// TODO Auto-generated method stub
		if(id=="tfo00000001")
			return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}

	@Override
	public String generateDate() {
		// TODO Auto-generated method stub
		String date="2015/10/23";
		return date;
	}

	@Override
	public ArrivalOrder4TranCenVO addArrivalOrder4TranCen(String id,
			String toid, String sa, String d, GoodState gs, String tcid) {
		this.id=id;
		this.tranorderoid=toid;
		this.startaddress=sa;
		this.date=d;
		this.goodstate=gs;
		this.trancenterid=tcid;
		// TODO Auto-generated method stub
//		此处传入VO所有参数，记录aotcVO（PO和VO的单号是一样的）；
		aotc=new ArrivalOrder4TranCenVO(this.id,this.tranorderoid,this.startaddress,this.date,this.goodstate,this.trancenterid);
//		此处调用数据层的增加中转中心到达单方法，更新PO
		end();
		return aotc;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4TranCenVO modify(String id, String toid, String sa,
			String d, GoodState gs, String tcid) {
		// TODO Auto-generated method stub
		//调用数据层的修改方法，修改PO
		
		end();
		System.out.println("Modify the ArrivalOrder4TranCen successfully!");
		return null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		//处理删除 调用数据层方法 更新 PO
		
		//处理删除 更新VO
				
		end();
		if(id=="aotc00000001"){
			System.out.println("Delete the ArrivalOrder4TranCen successfully!");
			return ResultMessage.Exist;
		}
		else return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		// TODO Auto-generated method stub
		//处理删除 调用数据层方法 更新 PO
		
		//处理删除 更新VO
						
		end();
		if(idlist.contains("aotc00000001")){
			System.out.println("Delete the ArrivalOrder4TranCen successfully!");
			return ResultMessage.Exist;
		}
		else return ResultMessage.NotExist;
	}

	@Override
	public ArrivalOrder4TranCenVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4TranCenlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		//此处调用数据层的Update方法
		
		System.out.println("End the ArrivalOrder4TranCen!");
	}

}
