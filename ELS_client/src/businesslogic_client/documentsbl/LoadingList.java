package businesslogic_client.documentsbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.LoadingListVO;
import businesslogicservice_client.documentsblservice.LoadingListblservice;
/**
 * 
 * @author ÷‹≥©
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
			String ea, ArrayList<String> oidl, String d, String vid, int f,
			String Jzy, String Yyy) {
		// TODO Auto-generated method stub
		return null;
	}

}
