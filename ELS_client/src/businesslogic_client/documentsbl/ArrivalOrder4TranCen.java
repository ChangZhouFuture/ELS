package businesslogic_client.documentsbl;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4TranCenVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4TranCenlineitemVO;
import businesslogicservice_client.documentsblservice.ArrivalOrder4TranCenblservice;

public class ArrivalOrder4TranCen implements ArrivalOrder4TranCenblservice {

	@Override
	public String getStartAddress(String toid) {
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
	public ArrivalOrder4TranCenVO addArrivalOrder4TranCen(String id,
			String toid, String sa, String d, String gs, String tcid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4TranCenVO modify(String id, String toid, String sa,
			String d, String gs, String tcid) {
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
	public ArrivalOrder4TranCenVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4TranCenlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
