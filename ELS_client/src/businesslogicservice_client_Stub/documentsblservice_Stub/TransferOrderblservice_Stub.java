package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;
 


 import state.ResultMessage;
import state.TransportType;
import vo_client.documentsVO.TransferOrderVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;
import businesslogicservice_client.documentsblservice.TransferOrderblservice;

/**
 * 
 * @author 朱俊文
 *
 */
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
 	public OrderlineitemVO addOrder(String orderid) {
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
 	public String generateId() {
 		// TODO Auto-generated method stub
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

	@Override
	public TransferOrderlineitemVO getTransferOrderlineitemVO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addTransferOrder(TransferOrderVO transferOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(TransferOrderVO transferOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}
 
 }
