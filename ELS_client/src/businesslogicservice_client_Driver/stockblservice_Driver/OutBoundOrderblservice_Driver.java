package businesslogicservice_client_Driver.stockblservice_Driver;

import vo_client.OrderVO;
import vo_client.stockVO.OutBoundOrderVO;

public interface OutBoundOrderblservice_Driver {
	public OrderVO addExpress(long id);
	
	public OutBoundOrderVO add(long id4E, String date, String desti, long id4TO);
	
	public void delete(long id);
	
	public OutBoundOrderVO modify(long id);
	
	public OutBoundOrderVO inquire(long id);
	
	public void endOBO();
}
