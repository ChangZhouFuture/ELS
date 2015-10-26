package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.LoadingListVO;

/**
 * 
 * @author �쿡��
 * ������װ������ص�ҵ���߼�
 *
 */
public interface LoadingListblservice {

	ResultMessage addBusiHall(String bhid);

	ArrayList<String> addOrder(String orderid);

	String generateDate();

	String generateTranLoadId(String bhid, String d);

	int generateFare(String sa, String ea);

	LoadingListVO addLoadingList(String id, String bhid, String tlid,
			String ea, ArrayList<String> oidl, String d, String vid, int f,
			String Jzy, String Yyy);

}
