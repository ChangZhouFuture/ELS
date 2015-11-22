package businesslogic_client.orderbl;

import state.ExpressType;
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
	public void add(OrderVO orderVO) {
		
		
	}

	@Override
	public void delete(String id) {
		
	}

	@Override
	public OrderVO inquireA(String id) {

		return null;
	}

	@Override
	public OrderVO inquireB(String date) {
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
	public void modify(OrderVO orderVO) {

	
	}

	@Override
	public double calculateTotalPrice(String startingPlace, String desti,
			ExpressType eType, int num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
