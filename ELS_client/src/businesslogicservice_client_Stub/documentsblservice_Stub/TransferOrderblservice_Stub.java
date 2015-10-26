package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import state.TransportType;
import vo_client.documentsVO.TransferOrderVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import businesslogicservice_client.documentsblservice.TransferOrderblservice;

public class TransferOrderblservice_Stub implements TransferOrderblservice{

	String id;
	TransportType transporttype;
	String startaddress;
	String endaddress;
	ArrayList<String> orderidlist;
	String date;
	String hangbanid;
	String huoguiid;
	String Jianzhuangyyuan;
	TransferOrderVO transferorder;
	@Override
	public ResultMessage addTransferCenter(String tcid) {
		// TODO Auto-generated method stub
		if(tcid=="tc00000001")
			return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}

	@Override
	public ArrayList<String> addOrder(String orderid) {
		// TODO Auto-generated method stub
		System.out.println("Add Express successfully!");
		return null;
	}

	@Override
	public String generateDate() {
		// TODO Auto-generated method stub
		String date="2015/10/23";
		return date;
	}

	@Override
	public int generateFare(String sa, String ea) {
		// TODO Auto-generated method stub
		int fare=0;
		return fare;
	}

	@Override
	public TransferOrderVO addTransferOrder(String id, TransportType tst,
			String sa, String ea, ArrayList<String> oidl, String d,
			String hbid, String hgid, String Jzy) {
		// TODO Auto-generated method stub
		this.id=id;
		this.transporttype=tst;
		this.startaddress=sa;
		this.endaddress=ea;
		this.orderidlist=oidl;
		this.date=d;
		this.hangbanid=hbid;
		this.huoguiid=hgid;
		this.Jianzhuangyyuan=Jzy;
//		此处传入VO所有参数，记录aobhVO（PO和VO的单号是一样的）；
		transferorder=new TransferOrderVO(this.id,this.transporttype,this.startaddress,this.endaddress,this.orderidlist,this.date,this.hangbanid,this.huoguiid,this.Jianzhuangyyuan);
//		此处调用数据层的增加中转单方法，更新PO
		end();
		return transferorder;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderVO modify(String id, TransportType tst, String sa,
			String ea, ArrayList<String> orderidlist, String d, String hbid,
			String hgid, String Jzy) {
		// TODO Auto-generated method stub
		//调用数据层的修改方法，修改PO
		end();
		System.out.println("Modify the TransferOrder successfully!");
		return null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		//处理删除 调用数据层方法 更新 PO
		
		//处理删除 更新VO
						
		end();
		if(id=="to00000001"){
			System.out.println("Delete the TransferOrder successfully!");
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
		if(idlist.contains("to00000001")){
			System.out.println("Delete the TransferOrders successfully!");
			return ResultMessage.Exist;
		}
		else return ResultMessage.NotExist;
	}

	@Override
	public TransferOrderVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		//此处调用数据层的Update方法
		
		System.out.println("End the TransferOrder!");
	}

}
