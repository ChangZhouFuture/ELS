package data_server.inforManagementdata;

import java.sql.*;
import po_server.inforManagementPO.DriversPO;
import data_server.utility.Database;
import dataservice_server.inforManagementdataservice.DriversInfordataservice;

public class DriversInfordata implements DriversInfordataservice {
	    Database db=new Database();
	    Connection con;
	    Statement sm;
	    PreparedStatement stmt;
	    DriversPO po;
	    
    //增加新司机信息
	public void add(DriversPO po){
		con=db.getConnection();
		try {
			// “?” 即占位符
			stmt = con.prepareStatement("INSERT INTO driver(ID,name,birthDate,identyNum,phone,gender,DriveLimitDate) VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1, po.getID());
		    stmt.setString(2, po.getName());
		    stmt.setString(3, po.getBirthDate());
		    stmt.setString(4, po.getIdentyNum());
		    stmt.setString(5, po.getPhone());
		    stmt.setInt(6, po.getGender());
		    stmt.setString(7, po.getDriveLimitDate());
		    stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//查找司机信息
	public DriversPO find(String Id){
		po = new DriversPO();
		con=db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM driver WHERE ID='"+Id+"'");
			
			 //大小写无区别，此处大写为区别表的名字，where表示条件
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setID(Id);
		        po.setName(rs.getString("name"));
		        po.setBirthDate(rs.getString("birthDate"));
		        po.setIdentyNum(rs.getString("identyNum"));
		        po.setPhone(rs.getString("phone"));
		        po.setGender(rs.getInt("gender"));
		        po.setDriveLimitDate(rs.getString("driveLimitDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}
	
	//删除司机信息
	public void delete(String Id){
		con=db.getConnection();
		try {
			stmt=con.prepareStatement("DELETE FROM driver WHERE ID=?");
			stmt.setString(1, Id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//修改司机信息
	public void update(DriversPO po){
		con=db.getConnection();
		try {
			String sql=("UPDATE drivers SET name=?,birthDate=?,identyNum=?,phone=?,gender=?,driveLimitDate=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getName());
			stmt.setString(2, po.getBirthDate());
			stmt.setString(3, po.getIdentyNum());
			stmt.setString(4, po.getPhone());
			stmt.setInt(5, po.getGender());
			stmt.setString(6, po.getDriveLimitDate());
			stmt.setString(7, po.getID());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
