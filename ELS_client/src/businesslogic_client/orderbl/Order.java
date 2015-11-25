package businesslogic_client.orderbl;

import java.util.ArrayList;

import state.ExpressType;
import state.ResultMessage;
import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo_client.orderVO.OrderVO;
import businesslogicservice_client.orderblservice.Orderblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class Order implements Orderblservice {

	@Override
	public ResultMessage add(OrderVO orderVO) {
		return null;
		
		
	}

	@Override
	public ResultMessage deleteOne(String id) {
		return null;
		
	}

	@Override
	public OrderVO inquireA(String id) {

		return null;
	}

	@Override
	public ArrayList<OrderlineitemVO> inquireB(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderlineitemVO getOrderlineitemVO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(OrderVO orderVO) {
		return null;

	
	}
	
	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void calculateTotalPrice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateExpectedArrivalDate() {
		// TODO Auto-generated method stub
		
	}

}
