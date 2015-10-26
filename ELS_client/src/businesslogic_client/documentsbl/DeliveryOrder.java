package businesslogic_client.documentsbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;
import vo_client.userVO.CourierVO;
import businesslogicservice_client.documentsblservice.DeliveryOrderblservice;
/**
 * ÅÉ¼þµ¥
 * @author Öì¿¡ÎÄ
 *
 */
public class DeliveryOrder implements DeliveryOrderblservice{

	@Override
	public String generateDeliverier(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addDeliverier(String id) {
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
	public DeliveryOrderVO addDeliveryOrder(String id,
			ArrayList<String> orsderidlist, String dn, String did, String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrderVO modify(String id, ArrayList<String> orsderidlist,
			String dn, String did, String d) {
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
	public DeliveryOrderVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrderlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
}
