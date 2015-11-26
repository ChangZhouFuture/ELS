package businesslogic.orderbl;

import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public class MockOrder extends Order{
	@Override
	public OrderlineitemVO getOrderlineitemVO(String id) {
		//id指的是订单的id
		return new OrderlineitemVO();
	}
}
