package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.LoadingListVO;
import vo_client.lineitemVO.documentslineitemVO.LoadingListlineitemVO;
import businesslogicservice_client.documentsblservice.LoadingListblservice;

public class LoadingListblservice_Stub implements LoadingListblservice{

	@Override
	public ResultMessage addBusiHall(String bhid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> addOrder(String orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateTranLoadId(String bhid, String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int generateFare(String sa, String ea) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LoadingListVO addLoadingList(String id, String bhid, String tlid,
			String ea, ArrayList<String> orderidlist, String d, String vid,
			int f, String Jzy, String Yyy) {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

	@Override
	public void deleteone(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMany(ArrayList<String> id) {
		// TODO Auto-generated method stub
		
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
		
	}

}
