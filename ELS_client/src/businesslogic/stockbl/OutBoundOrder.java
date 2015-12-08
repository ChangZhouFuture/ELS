package businesslogic.stockbl;

import java.util.ArrayList;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.stockVO.OutBoundOrderVO;
import bean.JavaBean1;
import businesslogicservice.stockblservice.OutBoundOrderblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class OutBoundOrder implements OutBoundOrderblservice {

	@Override
	public OrderlineitemVO addExpress(String expressID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 add(OutBoundOrderVO outBoundOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteone(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(OutBoundOrderVO outBoundOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireA(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endOBO() {
		// TODO Auto-generated method stub
		
	}
	
}
