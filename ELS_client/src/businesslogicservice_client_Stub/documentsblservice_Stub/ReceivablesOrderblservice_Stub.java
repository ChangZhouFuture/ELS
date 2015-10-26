package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.OrderVO;
import vo_client.documentsVO.ReceivablesOrderVO;
import vo_client.lineitemVO.documentslineitemVO.ReceivablesOrderlineitemVO;
import businesslogicservice_client.documentsblservice.ReceivablesOrderblservice;

public class ReceivablesOrderblservice_Stub implements ReceivablesOrderblservice{
	ReceivablesOrderVO ReceivablesOrderVO;
	ReceivablesOrderlineitemVO ReceivablesOrderlineitemVO;
	OrderVO oVO;
	String date4RO;
	String amount4RO;
	String courier4RO;
	ArrayList<String> barCode;
	@Override
	public ReceivablesOrderVO add(String date4ro, String amount4ro,
			String courier4ro, ArrayList<String> barCode) {
		// TODO Auto-generated method stub
		end();
		return ReceivablesOrderVO;
	}

	@Override
	public ResultMessage deleteOne(String date, String courierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4courier,
			ArrayList<String> date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceivablesOrderVO modify(String id4courier, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceivablesOrderlineitemVO inquire(String keyword) {
		// TODO Auto-generated method stub
		System.out.println("找到相关记录x条");
		return null;
	}

	@Override
	public void countCarriage(String depature, String destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void countAmount(ArrayList<String> OrderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
