package businesslogic_client.stockbl;

import vo_client.OrderVO;
import vo_client.stockVO.StorageListVO;
import businesslogicservice_client.stockblservice.StorageListblservice;
/**
 * 
 * @author �ܳ�
 *
 */
public class StorageList implements StorageListblservice {

	@Override
	public OrderVO addExpress(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteExpress(long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public StorageListVO initialize(long id, String date, String desti,
			int distr, int r, int shelf, int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StorageListVO modify(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageListVO inquire(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endOBO() {
		// TODO Auto-generated method stub
		
	}
	
}
