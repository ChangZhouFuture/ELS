package businesslogic.documentsbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.lineitemVO.userlineitemVO.SenderlineitemVO;
import bean.JavaBean1;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
/**
 * ÅÉ¼þµ¥
 * @author Öì¿¡ÎÄ
 *×®
 */
public class DeliveryOrder implements DeliveryOrderblservice{

	@Override
	public SenderlineitemVO addDeliverier(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderlineitemVO addOrder(String orderid) {
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
	public void generateId() {
		
		
		return;
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
	public JavaBean1 inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	
}
