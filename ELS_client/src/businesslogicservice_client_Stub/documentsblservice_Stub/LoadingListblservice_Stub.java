package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.LoadingListVO;
import businesslogicservice_client.documentsblservice.LoadingListblservice;


//public class LoadingListblservice_Stub implements LoadingListblservice{
//
//	String id;
//	String busihallid;
//	String tranloadid;
//	String endaddress;
//	ArrayList<String> orderidlist;
//	String date;
//	String vehicleid;
//	int fare;
//	String Jianzhuangyuan;
//	String Yayunyuan;
//	LoadingListVO ll;
//	@Override
//	public ResultMessage addBusiHall(String bhid) {
//		// TODO Auto-generated method stub
//		if(bhid=="bh00000001")
//			return ResultMessage.Exist;
//		else return ResultMessage.NotExist;
//	}
//
//	@Override
//	public ArrayList<String> addOrder(String orderid) {
//		// TODO Auto-generated method stub
//		System.out.println("Add Express successfully!");
//		return null;
//	}
//
//	@Override
//	public String generateDate() {
//		// TODO Auto-generated method stub
//		String date="2015/10/23";
//		return date;
//	}
//
//	@Override
//	public String generateTranLoadId(String bhid, String d) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int generateFare(String sa, String ea) {
//		// TODO Auto-generated method stub
//		int fare=0;
//		return fare;
//	}
//
//	@Override
//	public LoadingListVO addLoadingList(String id, String bhid, String tlid,
//			String ea, ArrayList<String> oidl, String d, String vid,
//			int f, String Jzy, String Yyy) {
//		// TODO Auto-generated method stub
//		this.id=id;
//		this.busihallid=bhid;
//		this.tranloadid=tlid;
//		this.endaddress=ea;
//		this.orderidlist=oidl;
//		this.date=d;
//		this.vehicleid=vid;
//		this.fare=f;
//		this.Jianzhuangyuan=Jzy;
//		this.Yayunyuan=Yyy;
////		此处传入VO所有参数，记录llVO（PO和VO的单号是一样的）；
//		ll=new LoadingListVO(this.id,this.busihallid,this.tranloadid,this.endaddress,this.orderidlist,this.date,this.vehicleid,this.fare,this.Jianzhuangyuan,this.Yayunyuan);
////		此处调用数据层的增加装运单方法，更新PO
//		end();
//		return ll;
//	}
