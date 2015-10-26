package businesslogic_client.documentsbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.LoadingListVO;
import vo_client.lineitemVO.documentslineitemVO.LoadingListlineitemVO;
import businesslogicservice_client.documentsblservice.LoadingListblservice;
/**
 * 
 * @author Öì¿¡ÎÄ
 *
 */
public class LoadingList implements LoadingListblservice{

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
			String ea, ArrayList<String> oidl, String d, String vid,
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
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		// TODO Auto-generated method stub
		return null;
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
