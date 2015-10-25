package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4BusiHallVO;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4BusiHalllineitemVO;
import businesslogicservice_client.documentsblservice.ArrivalOrder4BusiHallblservice;

public class ArrivalOrder4BusiHallblservice_Stub implements ArrivalOrder4BusiHallblservice{

	@Override
	public String getStartAddress(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addTransferOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodState getGoodState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4BusiHallVO addArrivalOrder4BusiHall(String id, String toid,
			String sa, String d, String gs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4BusiHallVO modify(String id, String toid, String sa,
			String d, String gs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteone(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMany(ArrayList<String> id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrivalOrder4BusiHallVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4BusiHalllineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
