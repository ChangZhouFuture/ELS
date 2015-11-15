package businesslogic_client.orderbl;

import state.ExpressType;
import vo_client.orderVO.OrderVO;
import businesslogicservice_client.orderblservice.Orderblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class Order implements Orderblservice {

	@Override
	public OrderVO add(String sender, String addressee, String desti,
			String startingPlace, ExpressType eType, String name, String id,
			int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderVO modify(String sender, String addressee, String desti,
			String startingPlace, ExpressType eType, String name, String id,
			int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO inquireA(String id) {
		// TODO Auto-generated method stub
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
	public double getTotalPrice(String startingPlace, String desti,
			ExpressType eType, int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void endOrder() {
		// TODO Auto-generated method stub
		
	}

}
