package businesslogicservice_client_Stub.documentsblservice_Stub;

import businesslogicservice_client.documentsblservice.LoadingListblservice;
<<<<<<< HEAD
=======

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
//		´Ë´¦´«ÈëVOËùÓĞ²ÎÊı£¬¼ÇÂ¼llVO£¨POºÍVOµÄµ¥ºÅÊÇÒ»ÑùµÄ£©£»
		ll=new LoadingListVO(this.id,this.busihallid,this.tranloadid,this.endaddress,this.orderidlist,this.date,this.vehicleid,this.fare,this.Jianzhuangyuan,this.Yayunyuan);
//		´Ë´¦µ÷ÓÃÊı¾İ²ãµÄÔö¼Ó×°ÔËµ¥·½·¨£¬¸üĞÂPO
		end();
		return ll;
	}
>>>>>>> parent of a4837a0... dataæ¥å£åŠVOPOï¼ˆå·²å®Œæˆï¼‰

public class LoadingListblservice_Stub implements LoadingListblservice{

}
