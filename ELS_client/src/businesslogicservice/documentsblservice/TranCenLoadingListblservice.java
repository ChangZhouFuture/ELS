package businesslogicservice.documentsblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.TranCenLoadingListVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public interface TranCenLoadingListblservice {
	public OrderlineitemVO addOrder(String orderId);
	
	public String generateId();
	
	public String generateDate();
	
	public String generateVehieclesId();
	
	public double generateFeight();
	
	public JavaBean1 add(TranCenLoadingListVO tranCenLoadingListVO);
	
	public ResultMessage delete(String id);
	
	public ResultMessage modify(TranCenLoadingListVO tranCenLoadingListVO);
	
	public JavaBean1 inquireA(String id);
	
	public JavaBean1 inquireB(ArrayList<String> idList);
	
	
	public void VOtoPO();
}
