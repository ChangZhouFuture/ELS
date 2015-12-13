package businesslogicservice.documentsblservice;

import java.util.ArrayList;

import bean.JavaBean1;
import state.ResultMessage;
import vo.documentsVO.TranCenLoadingListVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public interface TranCenLoadingListblservice {
	public OrderlineitemVO addOrder(String orderId);
	
	public JavaBean1 add(TranCenLoadingListVO tranCenLoadingListVO);
	
	public ResultMessage delete(ArrayList<String> idList);
	
	public ResultMessage modify(TranCenLoadingListVO tranCenLoadingListVO);
	
	public JavaBean1 inquireA(String id);
	
	public JavaBean1 inquireB(String date);
	
}
