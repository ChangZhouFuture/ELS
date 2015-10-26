package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4BusiHallVO;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4BusiHalllineitemVO;
import businesslogicservice_client.documentsblservice.ArrivalOrder4BusiHallblservice;
/**
 * 
 * @author �쿡��
 *
 */
public class ArrivalOrder4BusiHallblservice_Stub implements ArrivalOrder4BusiHallblservice{
	String id;
	String tranorderoid;
	String startaddress;
	String date;
	GoodState goodstate;
	ArrivalOrder4BusiHallVO aobh;
	@Override
	public String generateStartAddress(String id) {
		// TODO Auto-generated method stub
		//�˴�����id���س�����
		return null;
	}

	@Override
	public ResultMessage addTransferOrder(String id) {
		// TODO Auto-generated method stub
		if(id=="tfo00000002")
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
	public ArrivalOrder4BusiHallVO addArrivalOrder4BusiHall(String id, String toid,
			String sa, String d, GoodState gs) {
		// TODO Auto-generated method stub
		this.id=id;
		this.tranorderoid=toid;
		this.startaddress=sa;
		this.date=d;
		this.goodstate=gs;
//		�˴�����VO���в�������¼aobhVO��PO��VO�ĵ�����һ���ģ���
		aobh=new ArrivalOrder4BusiHallVO(this.id,this.tranorderoid,this.startaddress,this.date,this.goodstate);
//		�˴��������ݲ������Ӫҵ�����ﵥ����������PO
		end();
		return aobh;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4BusiHallVO modify(String id, String toid, String sa,
			String d, GoodState gs) {
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
			return ResultMessage.Exist;
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
			return ResultMessage.Exist;
		}
		else return ResultMessage.NotExist;
	}

	@Override
	public ArrivalOrder4BusiHallVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4BusiHalllineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		//�˴��������ݲ��Update����
		
		System.out.println("End the ArrivalOrder4BusiHall!");
	}

}
