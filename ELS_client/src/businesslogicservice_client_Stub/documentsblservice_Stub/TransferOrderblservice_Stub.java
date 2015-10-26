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
//		�˴�����VO���в�������¼aobhVO��PO��VO�ĵ�����һ���ģ���
		transferorder=new TransferOrderVO(this.id,this.transporttype,this.startaddress,this.endaddress,this.orderidlist,this.date,this.hangbanid,this.huoguiid,this.Jianzhuangyyuan);
//		�˴��������ݲ��������ת������������PO
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
		//�������ݲ���޸ķ������޸�PO
		end();
		System.out.println("Modify the TransferOrder successfully!");
		return null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		//����ɾ�� �������ݲ㷽�� ���� PO
		
		//����ɾ�� ����VO
						
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
		//����ɾ�� �������ݲ㷽�� ���� PO
		
		//����ɾ�� ����VO
								
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
		//�˴��������ݲ��Update����
		
		System.out.println("End the TransferOrder!");
	}

}
