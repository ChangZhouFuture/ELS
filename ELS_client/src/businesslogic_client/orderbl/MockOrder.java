package businesslogic_client.orderbl;

import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;

public class MockOrder extends Order{
	@Override
	public OrderlineitemVO getOrderlineitemVO(String id) {
		//idָ���Ƕ�����id
		return new OrderlineitemVO();
	}
}
