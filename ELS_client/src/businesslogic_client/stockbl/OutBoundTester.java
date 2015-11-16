package businesslogic_client.stockbl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import state.ResultMessage;


public class OutBoundTester {
	@Test
	public void test() {
		MockStock mock1 = new MockStock();
		
		assertEquals(ResultMessage.Success, mock1.outBound("141250203"));
	}
}
