package businesslogic_client.documentsbl;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4BusiHallVO;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4BusiHalllineitemVO;
import businesslogicservice_client.documentsblservice.ArrivalOrder4BusiHallblservice;
/**
 * 
 * @author Öì¿¡ÎÄ
 *
 */
public class ArrivalOrder4BusiHall implements ArrivalOrder4BusiHallblservice{

	@Override
	public String generateStartAddress(String id) {
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
	public ArrivalOrder4BusiHallVO addArrivalOrder4BusiHall(String id, String toid,
			String sa, String d, GoodState gs) {
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
			String d,GoodState gs) {
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
