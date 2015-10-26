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
		//�˴�����id���س�����
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
//		�˴�����VO���в�������¼aotcVO��PO��VO�ĵ�����һ���ģ���
		aotc=new ArrivalOrder4TranCenVO(this.id,this.tranorderoid,this.startaddress,this.date,this.goodstate,this.trancenterid);
//		�˴��������ݲ��������ת���ĵ��ﵥ����������PO
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
		//�˴��������ݲ��Update����
		
		System.out.println("End the ArrivalOrder4TranCen!");
	}

}
