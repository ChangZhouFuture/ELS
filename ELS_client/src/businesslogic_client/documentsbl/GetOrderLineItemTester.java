package businesslogic_client.documentsbl;

import org.junit.Test;

import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;
import businesslogic_client.orderbl.MockOrder;

public class GetOrderLineItemTester {
	@Test
	public OrderlineitemVO testGetOrderlLineItemVO(){
		MockOrder mock1 = new MockOrder();
		OrderlineitemVO orderlineitemVO = mock1.getOrderlineitemVO("141250203");
		
		return orderlineitemVO;
	}
}
