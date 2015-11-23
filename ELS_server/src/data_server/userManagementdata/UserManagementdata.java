package data_server.userManagementdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data_server.utility.Database;
import dataservice_server.userManagementdataservice.UserManagementdataservice;
import po_server.UserManagementPO;
import state.ResultMessage;

public class UserManagementdata implements UserManagementdataservice{

	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    UserManagementPO po;
	@Override
	public ResultMessage add(UserManagementPO po) {
		// TODO Auto-generated method stub
		
		try {
			stmt = con.prepareStatement("INSERT INTO user(ID,password) VALUES(?,?)");
			stmt.setString(1, po.getId());
		    stmt.setString(2, po.getPassword());
		    stmt.executeUpdate();
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		try {
			stmt=con.prepareStatement("DELETE FROM user WHERE ID=?");
			stmt.setString(1, Id);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<Ids.size();i++){
			stmt=con.prepareStatement("DELETE FROM user WHERE ID=?");
			stmt.setString(1, Ids.get(i));
			stmt.executeUpdate();
			}
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage update(UserManagementPO po) {
		// TODO Auto-generated method stub
		try {
			String sql=("UPDATE agency SET password=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getPassword());
			stmt.setString(2, po.getId());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public UserManagementPO find(String Id) {
		// TODO Auto-generated method stub
		po = new UserManagementPO();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM agency WHERE ID='"+Id+"'");
			
			 //大小写无区别，此处大写为区别表的名字，where表示条件
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setId(Id);
		        po.setPassword("password");
		        
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
