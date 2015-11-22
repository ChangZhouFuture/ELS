package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;
 


 import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4BusiHallVO;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4BusiHalllineitemVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import businesslogicservice_client.documentsblservice.ArrivalOrder4BusiHallblservice;
 
 public class ArrivalOrder4BusiHallblservice_Stub implements ArrivalOrder4BusiHallblservice{

	String id;
	String tranorderoid;
	String startaddress;
	String date;
	GoodState goodstate;
	ArrivalOrder4BusiHallVO ao4bh;
 	@Override
 	public String generateStartAddress(String id) {
 		// TODO Auto-generated method stub
		//此处根据id返回出发地
 		return null;
 	}
 
 	@Override
 	public TransferOrderlineitemVO addTransferOrder(String id) {
		return null;
 		// TODO Auto-generated method stub
 		
 	}
 			 
 	@Override
 	public String generateDate() {
 		// TODO Auto-generated method stub
 		String date="2015/10/23";
 		return date;
 	}
 		 
 	@Override
 	public ResultMessage addArrivalOrder4BusiHall(ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO) {
		return null;

 		
 		//		此处传入VO所有参数，记录aobhVO（PO和VO的单号是一样的）；
// 		ao4bh=new ArrivalOrder4BusiHallVO(this.id,this.tranorderoid,this.startaddress,this.date,this.goodstate);
 		//		此处调用数据层的增加营业厅到达单方法，更新PO
 	}
 		 
 	@Override
 	public String generateId() {
 		 // TODO Auto-generated method stub
 		 return null;
 	}
 		 
 	@Override
 	public ResultMessage modify(ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO) {
 		// TODO Auto-generated method stub
 		//调用数据层的修改方法，修改PO
 				
 		end();
 		System.out.println("Modify the ArrivalOrder4BusiHall successfully!");
		return null;
 		 	}
 		 
 	@Override
 	public ResultMessage deleteone(String id) {
 		// TODO Auto-generated method stub
 		//处理删除 调用数据层方法 更新 PO
 		 		
 		//处理删除 更新VO
 						
 		end();
 		if(id=="aobh00000001"){
 			System.out.println("Delete the ArrivalOrder4BusiHall successfully!");
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
		if(idlist.contains("aobh00000001")){
			System.out.println("Delete the ArrivalOrder4BusiHalls successfully!");
			return ResultMessage.Exist;
		}
		else return ResultMessage.NotExist;
 	}
 
 	@Override
 	public ArrayList<ArrivalOrder4BusiHallVO> inquireA(String id) {
 		// TODO Auto-generated method stub
 		return null;
 	}
 
 	@Override
 	public void end() {
 		// TODO Auto-generated method stub
		//此处调用数据层的Update方法
 		
		System.out.println("End the ArrivalOrder4BusiHall!");
 	}

	@Override
	public void VOtoPO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ArrivalOrder4BusiHallVO> inquireB(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalOrder4BusiHallVO> inquireC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void POtoVO(int k) {
		// TODO Auto-generated method stub
		
	}

 }
 	