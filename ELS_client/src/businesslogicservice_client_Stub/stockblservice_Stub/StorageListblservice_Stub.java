package businesslogicservice_client_Stub.stockblservice_Stub;

import java.util.ArrayList;
import businesslogicservice_client.stockblservice.StorageListblservice;
import state.ResultMessage;
import vo_client.lineitemVO.OrderlineitemVO;
import vo_client.stockVO.StorageListVO;

public class StorageListblservice_Stub implements StorageListblservice{
	String desti;
	String dis;
	String row;
	String she;
	String pos;
	String id4sl;
	String time;
	
	@Override
	public OrderlineitemVO addExpress(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StorageListVO add(String desti, String dis, String row,
			String she, String pos) {
		// TODO Auto-generated method stub
		
		//此处调用数据层的A的方法
		
		endSL();
		return null;
	}

	@Override
	public ResultMessage deleteone(String id4obo) {
		// TODO Auto-generated method stub
		
		endSL();
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> id4obo) {
		// TODO Auto-generated method stub
		
		endSL();
		return null;
	}

	@Override
	public StorageListVO modify(String id, String desti, String dis,
			String row, String she, String pos) {
		// TODO Auto-generated method stub
		
		endSL();
		return null;
	}

	@Override
	public StorageListVO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageListVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endSL() {
		// TODO Auto-generated method stub
		
		//此处调用数据层的Update方法
	}
	
}
