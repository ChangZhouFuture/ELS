package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.JavaBean1;
import data.utility.Database;
import po.documentsPO.BusiHallLoadingListPO;
import po.lineitemPO.documentslineitemPO.BusiHallLoadingListlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.BusiHallLoadingListdataservice;

public class BusiHallLoadingListdata extends UnicastRemoteObject  implements BusiHallLoadingListdataservice {

	

	public BusiHallLoadingListdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	JavaBean1 jb1;
	@Override
	public OrderlineitemPO addOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addLoadingList(BusiHallLoadingListPO loadingListPO) {
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
	public JavaBean1 findA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 findB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(BusiHallLoadingListPO loadingListPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId(String date) {
		// TODO Auto-generated method stub
		String sql="select * from trancenarrivalorder where date='"+date+"'";
		String sub,subId;
		int x;
		int last=0;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			if(!rs.next()){
				return date+"0001";
			}
			while(rs.next()){
				sub=rs.getString(1).substring(8);
				x=Integer.parseInt(sub);
				if(x>last){
					last=x;
				}
			}
			subId=Integer.toString(last);
			for(int i=0;i<4-subId.length();i++){
				subId="0"+subId;
			}
			return date+subId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
}
