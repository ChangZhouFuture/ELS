package businesslogic.stockbl;

import java.util.ArrayList;

import state.ResultMessage;
import vo.lineitemVO.stocklineitemVO.OutBoundOrderlineitemVO;
import vo.stockVO.OutBoundOrderVO;
import businesslogicservice.stockblservice.OutBoundOrderblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class OutBoundOrder implements OutBoundOrderblservice {

	@Override
	public OutBoundOrderlineitemVO addExpress(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderVO add(String id4e, String id4to, String desti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteone(String id4obo) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4obo) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public OutBoundOrderVO modify(String id, String id4e, String id4to,
			String desti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutBoundOrderVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void endOBO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateTime() {
		// TODO Auto-generated method stub
		
	}
	
}
