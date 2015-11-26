package businesslogicservice_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo.documentsVO.BusinessHallLoadingListVO;
import vo.lineitemVO.documentslineitemVO.BusinessHallLoadingListlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import businesslogicservice.documentsblservice.BusinessHallLoadingListblservice;

/**
 * 
 * @author 朱俊�?
 *
 */
public class LoadingListblservice_Stub implements BusinessHallLoadingListblservice{

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
	BusinessHallLoadingListVO ll;
	@Override
	public ResultMessage addBusiHall(String bhid) {
		// TODO Auto-generated method stub
		if(bhid=="bh00000001")
			return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}

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
	public BusinessHallLoadingListVO addLoadingList(String id, String bhid, String tlid,
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
//		此处传入VO�?有参数，记录llVO（PO和VO的单号是�?样的）；
		ll=new BusinessHallLoadingListVO(this.id,this.busihallid,this.tranloadid,this.endaddress,this.orderidlist,this.date,this.vehicleid,this.fare,this.Jianzhuangyuan,this.Yayunyuan);
//		此处调用数据层的增加装运单方法，更新PO
		end();
		return ll;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessHallLoadingListVO modify(String id, String bhid, String tlid, String ea,
			ArrayList<String> orderidlist, String d, String vid, int f,
			String Jzy, String Yyy) {
		// TODO Auto-generated method stub
		//调用数据层的修改方法，修改PO
		
		end();
		System.out.println("Modify the LuadingList successfully!");
		return null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		//处理删除 调用数据层方�? 更新 PO
		
		//处理删除 更新VO
						
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
		//处理删除 调用数据层方�? 更新 PO
		
		//处理删除 更新VO
						
		end();
		if(idlist.contains("ll00000001")){
			System.out.println("Delete the LoadingLists successfully!");
			return ResultMessage.Exist;
		}
		else return ResultMessage.NotExist;
	}

	@Override
	public BusinessHallLoadingListVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessHallLoadingListlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		//此处调用数据层的Update方法
		
		System.out.println("End the LoadingList!");
	}

}
