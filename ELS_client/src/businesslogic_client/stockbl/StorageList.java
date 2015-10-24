package businesslogic_client.stockbl;

import java.util.ArrayList;

import vo_client.OrderVO;
import vo_client.stockVO.OutBoundOrderVO;
import vo_client.stockVO.StorageListVO;
import businesslogicservice_client.stockblservice.StorageListblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class StorageList implements StorageListblservice {

	@Override
	public OrderVO addExpress(String id) {
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
	public OutBoundOrderVO add(String desti, String dis, String row,
			String she, String pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteone(String id4obo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMany(ArrayList<String> id4obo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OutBoundOrderVO modify(String id, String desti, String dis,
			String row, String she, String pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endOBO() {
		// TODO Auto-generated method stub
		
	}

}
