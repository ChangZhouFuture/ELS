package businesslogic_client.documentsbl;

import java.util.ArrayList;

import state.ResultMessage;
import state.TransportType;
import vo_client.documentsVO.TransferOrderVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;
import businesslogicservice_client.documentsblservice.TransferOrderblservice;
/**
 * 
 * @author Öì¿¡ÎÄ
 * 
 */
public class TransferOrder implements TransferOrderblservice {

	@Override
	public void addTransferCenter(String tcid) {
		// TODO Auto-generated method stub
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
	public int generateFare(String sa, String ea) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TransferOrderVO addTransferOrder(String id, TransportType tst,
			String sa, String ea, ArrayList<String> oidl, String d,
			String hbid, String hgid, String Jzy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderVO modify(String id, TransportType tst, String sa,
			String ea, ArrayList<String> oidl, String d, String hbid,
			String hgid, String Jzy) {
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
	public TransferOrderVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransferOrderlineitemVO getTransferOrderlineitemVO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
