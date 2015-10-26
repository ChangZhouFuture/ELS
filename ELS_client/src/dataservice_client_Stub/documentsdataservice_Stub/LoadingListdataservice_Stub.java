package dataservice_client_Stub.documentsdataservice_Stub;

import java.util.ArrayList;

import po_client.documentsPO.LoadingListPO;
import po_client.lineitemPO.documentslineitemPO.LoadingListlineitemPO;
import state.ResultMessage;
import dataservice_client.documentsdataservice.LoadingListdataservice;

public class LoadingListdataservice_Stub implements LoadingListdataservice{

	@Override
	public LoadingListPO addLoadingList(String id, String bhid, String tlid,
			String ea, ArrayList<String> oidl, String d, String vid, int f,
			String Jzy, String Yyy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoadingListPO modify(String id, String bhid, String tlid, String ea,
			ArrayList<String> orderidlist, String d, String vid, int f,
			String Jzy, String Yyy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoadingListPO inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoadingListlineitemPO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
