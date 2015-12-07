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
	public void updateApproState(String ordername, String id) {
		// TODO Auto-generated method stub
		String sql="select * from ? where ID=?";
		String state="NotApprove";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, ordername);
			stmt.setString(2, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				if(rs.getString("approState").equals("NotApprove")){
					state="Approve";
				}else{
					state="NotApprove";
				}
			}
			sql="update ? set approState=? where ID=?";
			stmt.setString(1, ordername);
			stmt.setString(2, state);
			stmt.setString(3, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
