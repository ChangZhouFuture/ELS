package businesslogicservice_client_Stub.orderblservice_Stub;

import java.util.ArrayList;

import businesslogicservice_client.orderblservice.Orderblservice;
import state.ExpressType;
import state.ResultMessage;
import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo_client.orderVO.OrderVO;

public class Orderblservice_Stub implements Orderblservice{
    OrderVO oVO;
    String sender;
    String addressee;
    String desti;
    String startingPlace;
    ExpressType eType;
    String name;
    String id;
    int num;
	@Override
	public ResultMessage add(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage deleteOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage modify(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public OrderVO inquireA(String id) {
		// TODO Auto-generated method stub
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
	public void calculateTotalPrice() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void generateExpectedArrivalDate() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public OrderlineitemVO getOrderlineitemVO(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void endOrder() {
		// TODO Auto-generated method stub
		
	}
    
    

}
