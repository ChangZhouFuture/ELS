package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.LoadingListVO;
import vo_client.lineitemVO.documentslineitemVO.LoadingListlineitemVO;
import businesslogicservice_client.documentsblservice.LoadingListblservice;
/**
 * 
 * @author �쿡��
 *
 */
public class LoadingListblservice_Stub implements LoadingListblservice{

	String id;
	String busihallid;
	String tranloadid;
	String endaddress;
	ArrayList<String> orderidlist;
	String date;
	String vehicleid;
	int fare;
	String Jianzhuangyuan;
	String Yayunyuan;
	LoadingListVO ll;
	@Override
	public ResultMessage addBusiHall(String bhid) {
		// TODO Auto-generated method stub
		if(bhid=="bh00000001")
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
	public String generateTranLoadId(String bhid, String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int generateFare(String sa, String ea) {
		// TODO Auto-generated method stub
		int fare=0;
		return fare;
	}

	@Override
	public LoadingListVO addLoadingList(String id, String bhid, String tlid,
			String ea, ArrayList<String> oidl, String d, String vid,
			int f, String Jzy, String Yyy) {
		// TODO Auto-generated method stub
		this.id=id;
		this.busihallid=bhid;
		this.tranloadid=tlid;
		this.endaddress=ea;
		this.orderidlist=oidl;
		this.date=d;
		this.vehicleid=vid;
		this.fare=f;
		this.Jianzhuangyuan=Jzy;
		this.Yayunyuan=Yyy;
//		�˴�����VO���в�������¼llVO��PO��VO�ĵ�����һ���ģ���
		ll=new LoadingListVO(this.id,this.busihallid,this.tranloadid,this.endaddress,this.orderidlist,this.date,this.vehicleid,this.fare,this.Jianzhuangyuan,this.Yayunyuan);
//		�˴��������ݲ������װ�˵�����������PO
		end();
		return ll;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoadingListVO modify(String id, String bhid, String tlid, String ea,
			ArrayList<String> orderidlist, String d, String vid, int f,
			String Jzy, String Yyy) {
		// TODO Auto-generated method stub
		//�������ݲ���޸ķ������޸�PO
		
		end();
		System.out.println("Modify the LuadingList successfully!");
		return null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		//����ɾ�� �������ݲ㷽�� ���� PO
		
		//����ɾ�� ����VO
						
		end();
		if(id=="ll00000001"){
			System.out.println("Delete the LoadingList successfully!");
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
		if(idlist.contains("ll00000001")){
			System.out.println("Delete the LoadingLists successfully!");
			return ResultMessage.Exist;
		}
		else return ResultMessage.NotExist;
	}

	@Override
	public LoadingListVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoadingListlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		//�˴��������ݲ��Update����
		
		System.out.println("End the LoadingList!");
	}

}
