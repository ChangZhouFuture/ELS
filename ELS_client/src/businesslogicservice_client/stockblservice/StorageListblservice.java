package businesslogicservice_client.stockblservice;

import vo_client.OrderVO;
import vo_client.stockVO.StorageListVO;

public interface StorageListblservice {
	public OrderVO addExpress(long id);
	
	public void deleteExpress(long id);
	
	public StorageListVO initialize(long id, String date, String desti, int distr, int r, int shelf, int pos);
	
	public void delete(long id);
	
	public StorageListVO modify(long id);
	
	public StorageListVO inquire(long id);
	
	public void endOBO();
}
