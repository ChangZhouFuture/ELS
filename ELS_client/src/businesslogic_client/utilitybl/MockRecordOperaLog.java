package businesslogic_client.utilitybl;

import state.OperaType;
import state.ResultMessage;

public class MockRecordOperaLog extends RecordOperaLog{
	public ResultMessage recordOperaLog (OperaType type, String id, String operator) {
		//idΪ���ݵı��
		//�˴��������ݲ��recordOperaLog����
		return ResultMessage.Success;	
	}
}
