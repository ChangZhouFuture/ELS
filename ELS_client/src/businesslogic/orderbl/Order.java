package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.Orderdataservice;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.orderVO.OrderVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.orderblservice.Orderblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class Order implements Orderblservice {
	private Orderdataservice orderdataservice;
	
	public Order() {
		try {
			orderdataservice = RMIHelper.getOrderDataservice();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public  JavaBean1 add(OrderVO orderVO) {
		return null;
		
		
	}

	@Override
	public ResultMessage deleteOne(String id) {
		return null;
		
	}

	@Override
	public JavaBean1 inquireA(String id) {
		
		return null;
	}

	@Override
	public JavaBean1 inquireB(String date) {
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
