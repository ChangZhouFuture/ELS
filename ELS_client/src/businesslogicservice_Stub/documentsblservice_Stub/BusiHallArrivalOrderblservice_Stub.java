package businesslogicservice_Stub.documentsblservice_Stub;

import java.util.ArrayList;
 





 import state.GoodState;
import state.ResultMessage;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.documentslineitemVO.BusiHallArrivalOrderlineitemVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import businesslogic.utilitybl.JavaBean;
import businesslogicservice.documentsblservice.BusiHallArrivalOrderblservice;
 
 public class BusiHallArrivalOrderblservice_Stub implements BusiHallArrivalOrderblservice{

	String id;
	String tranorderoid;
	String startaddress;
	String date;
	GoodState goodstate;
	BusiHallArrivalOrderVO ao4bh;
 	@Override
 	public String generateStartAddress(String id) {
 		// TODO Auto-generated method stub
		//�˴�����id���س�����
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
 	public JavaBean addArrivalOrder4BusiHall(BusiHallArrivalOrderVO arrivalOrder4BusiHallVO) {
		return null;

 		
 		//		�˴�����VO���в�������¼aobhVO��PO��VO�ĵ�����һ���ģ���
// 		ao4bh=new ArrivalOrder4BusiHallVO(this.id,this.tranorderoid,this.startaddress,this.date,this.goodstate);
 		//		�˴��������ݲ������Ӫҵ�����ﵥ����������PO
 	}
 		 
 	@Override
 	public String generateId() {
 		 // TODO Auto-generated method stub
 		 return null;
 	}
 		 
 	@Override
 	public ResultMessage modify(BusiHallArrivalOrderVO arrivalOrder4BusiHallVO) {
 		// TODO Auto-generated method stub
 		//�������ݲ���޸ķ������޸�PO
 				
 		end();
 		System.out.println("Modify the ArrivalOrder4BusiHall successfully!");
		return null;
 		 	}
 		 
 	@Override
 	public ResultMessage deleteone(String id) {
 		// TODO Auto-generated method stub
 		//����ɾ�� �������ݲ㷽�� ���� PO
 		 		
 		//����ɾ�� ����VO
 						
 		end();
 		if(id=="aobh00000001"){
 			System.out.println("Delete the ArrivalOrder4BusiHall successfully!");
 			return ResultMessage.Success;
 		}
 		else return ResultMessage.NotExist;
 		 	}
 		 
 	@Override
 	public ResultMessage deleteMany(ArrayList<String> idlist) {
 		// TODO Auto-generated method stub
		//����ɾ�� �������ݲ㷽�� ���� PO
 		
		//����ɾ�� ����VO
								
		end();
		if(idlist.contains("aobh00000001")){
			System.out.println("Delete the ArrivalOrder4BusiHalls successfully!");
			return ResultMessage.Success;
		}
		else return ResultMessage.NotExist;
 	}
 
 	@Override
 	public ArrayList<BusiHallArrivalOrderVO> inquireA(String id) {
 		// TODO Auto-generated method stub
 		return null;
 	}
 
 	@Override
 	public void end() {
 		// TODO Auto-generated method stub
		//�˴��������ݲ��Update����
 		
		System.out.println("End the ArrivalOrder4BusiHall!");
 	}

	@Override
	public void VOtoPO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BusiHallArrivalOrderVO> inquireB(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BusiHallArrivalOrderVO> inquireC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void POtoVO(int k) {
		// TODO Auto-generated method stub
		
	}

 }
 	