package businesslogic_client.stockbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo_client.stockVO.StorageListVO;
import businesslogicservice_client.stockblservice.StorageListblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class StorageList implements StorageListblservice {

	@Override
	public OrderlineitemVO addExpress(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StorageListVO add(String desti, String dis, String row,
			String she, String pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteone(String id4obo) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4obo) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public StorageListVO modify(String id, String desti, String dis,
			String row, String she, String pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageListVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageListVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endSL() {
		// TODO Auto-generated method stub
		
	}

}
