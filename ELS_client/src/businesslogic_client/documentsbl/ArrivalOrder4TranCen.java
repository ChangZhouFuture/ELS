package businesslogic_client.documentsbl;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4TranCenVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4TranCenlineitemVO;
import businesslogicservice_client.documentsblservice.ArrivalOrder4TranCenblservice;
/**
 * 
 * @author Öì¿¡ÎÄ
 *
 */
public class ArrivalOrder4TranCen implements ArrivalOrder4TranCenblservice {

	@Override
	public String generateStartAddress(String toid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addTransferOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalOrder4TranCenVO addArrivalOrder4TranCen(String id,
			String toid, String sa, String d, GoodState gs, String tcid) {
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
			String d, GoodState gs, String tcid) {
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
