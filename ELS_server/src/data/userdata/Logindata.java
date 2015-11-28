package data.userdata;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.JavaBean2;
import data.utility.Database;
import dataservice.userdataservice.Logindataservice;
import state.ResultMessage;


public class Logindata extends UnicastRemoteObject implements Logindataservice{

	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    
	public Logindata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void logout() {
		
		
	}

	@Override
	public JavaBean2 login(String id, String passWord) {
		// TODO Auto-generated method stub
		JavaBean2 bean=new JavaBean2();
		try {
			stmt=con.prepareStatement("select * from user");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				
				if(rs.getString(1).equals(id)){
					
					if(rs.getString(2).equals(passWord)){
						bean.setName(rs.getString(3));
						bean.setResultMessage(ResultMessage.Success);
						bean.setAgencyID(rs.getString(11));
						return bean;
					}else{
						bean.setResultMessage(ResultMessage.wrongPassWord);
						return bean;
					}
				}
			}
			bean.setResultMessage(ResultMessage.NotExist);
			return bean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
