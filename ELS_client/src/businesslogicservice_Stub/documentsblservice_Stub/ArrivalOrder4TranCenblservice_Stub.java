package businesslogicservice_Stub.documentsblservice_Stub;

import java.util.ArrayList;
 







import po.documentsPO.ArrivalOrder4TranCenPO;
import state.GoodState;
import state.ResultMessage;
import vo.documentsVO.ArrivalOrder4TranCenVO;
import vo.lineitemVO.documentslineitemVO.ArrivalOrder4TranCenlineitemVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import businesslogicservice.documentsblservice.ArrivalOrder4TranCenblservice;

/**
 * 
 * @author 朱俊文
 *
 */
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
 	public TransferOrderlineitemVO addTransferOrder(String id) {
		return null;
 	
 	}
 	
 	@Override
 	public String generateDate() {
 		// TODO Auto-generated method stub
 		String date="2015/10/23";
 		return date;
 	}
 
 	@Override
 	public ResultMessage addArrivalOrder4TranCen(ArrivalOrder4TranCenVO arrivalOrder4TranCenVO) {
 //		此处传入VO所有参数，记录aotcVO（PO和VO的单号是一样的）；
 //		此处调用数据层的增加中转中心到达单方法，更新PO
 		end();
		return null;
 	}
 
 	@Override
 	public String generateId() {
 		// TODO Auto-generated method stub
 		return null;
 	}
 
 	@Override
 	public ResultMessage modify(ArrivalOrder4TranCenVO arrivalOrder4TranCenVO) {
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
 	public ArrayList<ArrivalOrder4TranCenVO> inquireA(String id) {
 		// TODO Auto-generated method stub
 		return null;
 	}
 
 	@Override
 	public void end() {
 		// TODO Auto-generated method stub
 		//此处调用数据层的Update方法
 		
 		System.out.println("End the ArrivalOrder4TranCen!");
 	}

	@Override
	public void VOtoPO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ArrivalOrder4TranCenVO> inquireC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void POtoVO(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ArrivalOrder4TranCenVO> inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}
 
 }
