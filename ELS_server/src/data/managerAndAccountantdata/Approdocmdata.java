package data.managerAndAccountantdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.utility.Database;
import dataservice.managerAndAccountantdataservice.Approdocmdataservice;


public class Approdocmdata extends UnicastRemoteObject implements Approdocmdataservice{

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	
	public Approdocmdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object inquireB(String kind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object inquireC(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object modify() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateApproState(String ordername, String id) {
		// TODO Auto-generated method stub
		String sql="select * from ? where ID=?";
		int state = 0;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, ordername);
			stmt.setString(2, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				state=1-rs.getInt("approState");
			}
			sql="update ? set approState=? where ID=?";
			stmt.setString(1, ordername);
			stmt.setInt(2, state);
			stmt.setString(3, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
