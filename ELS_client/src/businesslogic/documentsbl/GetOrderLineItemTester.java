package businesslogic.documentsbl;

import org.junit.Test;

import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import businesslogic.orderbl.MockOrder;

public class GetOrderLineItemTester {
	@Test
	public OrderlineitemVO testGetOrderlLineItemVO(){
		MockOrder mock1 = new MockOrder();
		OrderlineitemVO orderlineitemVO = mock1.getOrderlineitemVO("141250203");
		
		return orderlineitemVO;
	}
}
