package businesslogicservice_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo.documentsVO.BusiHallLoadingListVO;
import vo.lineitemVO.documentslineitemVO.BusiHallLoadingListlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import businesslogic.utilitybl.JavaBean;
import businesslogicservice.documentsblservice.BusiHallLoadingListblservice;

/**
 * 
 * @author 朱俊�?
 *
 */
public class LoadingListblservice_Stub implements BusiHallLoadingListblservice{

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
	BusiHallLoadingListVO ll;
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
	public BusiHallLoadingListVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusiHallLoadingListlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		//此处调用数据层的Update方法
		
		System.out.println("End the LoadingList!");
	}

	@Override
	public String generateTruckId(String bhid, String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double generateFreight(String sa, String ea) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JavaBean addBusinessHallLoadingList(
			BusiHallLoadingListVO businessHallLoadingListVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(
			BusiHallLoadingListVO businessHallLoadingListVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void VOtoPO() {
		// TODO Auto-generated method stub
		
	}

}
