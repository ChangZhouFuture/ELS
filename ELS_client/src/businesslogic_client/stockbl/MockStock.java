package businesslogic_client.stockbl;

import state.ResultMessage;

public class MockStock extends Stock{
	
	public ResultMessage outBound(String id) {
		//id是指出库的快递的订单的id
		//这里调用数据层方法把仓库存放该快递的位置设置为空，表示快递已经出库
		
		return ResultMessage.Success;
	}
}
