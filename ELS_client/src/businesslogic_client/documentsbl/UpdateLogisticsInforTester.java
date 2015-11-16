package businesslogic_client.documentsbl;


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import state.ResultMessage;
import businesslogic_client.utilitybl.MockUpdateLogisticsInfor;

public class UpdateLogisticsInforTester {
	
	@Test
	public void testUpdateLogisticsInfor() {
		MockUpdateLogisticsInfor mock1 = new MockUpdateLogisticsInfor();
		
		assertEquals(ResultMessage.Success, mock1.update("sss"));
	}
}
