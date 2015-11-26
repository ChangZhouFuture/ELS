package businesslogic.orderbl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import state.OperaType;
import state.ResultMessage;
import businesslogic.utilitybl.MockRecordOperaLog;

public class RecordOperaLogTester {
	@Test
	public void testRecordOperaLog(){
		MockRecordOperaLog mockObject = new MockRecordOperaLog();
		
		assertEquals(ResultMessage.Success, mockObject.recordOperaLog(OperaType.Add, "141250203", "zc"));
	}
}
