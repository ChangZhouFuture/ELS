package businesslogicservice_Stub.documentsblservice_Stub;

import java.util.ArrayList;
 







import po.documentsPO.TranCenArrivalOrderPO;
import state.GoodState;
import state.ResultMessage;
import vo.documentsVO.TranCenArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TranCenArrivalOrderlineitemVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import businesslogicservice.documentsblservice.TranCenArrivalOrderblservice;

/**
 * 
 * @author �쿡��
 *
 */
 public class TranCenArrivalOrderblservice_Stub implements TranCenArrivalOrderblservice{
 	String id;
 	String tranorderoid;
 	String startaddress;
 	String date;
 	GoodState goodstate;
 	String trancenterid;
 	TranCenArrivalOrderVO aotc;
 	@Override
 	public String generateStartAddress(String toid) {
 		// TODO Auto-generated method stub
 		//�˴�����id���س�����
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
 	public ResultMessage addArrivalOrder4TranCen(TranCenArrivalOrderVO arrivalOrder4TranCenVO) {
 //		�˴�����VO���в�������¼aotcVO��PO��VO�ĵ�����һ���ģ���
 //		�˴��������ݲ��������ת���ĵ��ﵥ����������PO
 		end();
		return null;
 	}
 
 	@Override
 	public String generateId() {
 		// TODO Auto-generated method stub
 		return null;
 	}
 
 	@Override
 	public ResultMessage modify(TranCenArrivalOrderVO arrivalOrder4TranCenVO) {
 		// TODO Auto-generated method stub
 		//�������ݲ���޸ķ������޸�PO
 		
 		end();
 		System.out.println("Modify the ArrivalOrder4TranCen successfully!");
		return null;
 	}
 
 	@Override
 	public ResultMessage deleteone(String id) {
 		// TODO Auto-generated method stub
 		//����ɾ�� �������ݲ㷽�� ���� PO
 		
 		//����ɾ�� ����VO
 				
 		end();
 		if(id=="aotc00000001"){
 			System.out.println("Delete the ArrivalOrder4TranCen successfully!");
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
 		if(idlist.contains("aotc00000001")){
 			System.out.println("Delete the ArrivalOrder4TranCen successfully!");
 			return ResultMessage.Success;
 		}
 		else return ResultMessage.NotExist;
 	}
 
 	@Override
 	public ArrayList<TranCenArrivalOrderVO> inquireA(String id) {
 		// TODO Auto-generated method stub
 		return null;
 	}
 
 	@Override
 	public void end() {
 		// TODO Auto-generated method stub
 		//�˴��������ݲ��Update����
 		
 		System.out.println("End the ArrivalOrder4TranCen!");
 	}

	@Override
	public void VOtoPO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TranCenArrivalOrderVO> inquireC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void POtoVO(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TranCenArrivalOrderVO> inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}
 
 }
