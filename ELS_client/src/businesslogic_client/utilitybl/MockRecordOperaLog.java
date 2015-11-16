package businesslogic_client.utilitybl;

import state.OperaType;
import state.ResultMessage;

public class MockRecordOperaLog extends RecordOperaLog{
	public ResultMessage recordOperaLog (OperaType type, String id, String operator) {
		//id为单据的编号
		//此处调用数据层的recordOperaLog方法
		return ResultMessage.Success;	
	}
}
