package data_server.inforManagementdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data_server.utility.Database;
import dataservice_server.inforManagementdataservice.AgencyInfordataservice;
import po_server.inforManagementPO.AgencyPO;

public class AgencyInfordata implements AgencyInfordataservice{
	Database db=new Database();
    Connection con;
    Statement sm;
    PreparedStatement stmt;
    AgencyPO po;
    
//增加新机构信息
public void add(AgencyPO po){
	con=db.getConnection();
	try {
		stmt = con.prepareStatement("INSERT INTO agency(ID,city,agencyType) VALUES(?,?,?)");
		stmt.setString(1, po.getID());
	    stmt.setString(2, po.getCity());
	    stmt.setInt(3, po.getAgencyType());
	    stmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//查找机构信息
public AgencyPO find(String Id){
	po = new AgencyPO();
	con=db.getConnection();
	try {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM agency WHERE ID='"+Id+"'");
		
		 //大小写无区别，此处大写为区别表的名字，where表示条件
		ResultSet rs=ps.executeQuery(); 
		if(rs.next()){
		    po.setID(Id);
	        po.setCity(rs.getString("city"));
	        po.setAgencyType(rs.getInt("agencyType"));;
	        
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return po;
}

//删除机构信息
public void delete(String Id){
	con=db.getConnection();
	try {
		stmt=con.prepareStatement("DELETE FROM agency WHERE ID=?");
		stmt.setString(1, Id);
		stmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//修改机构信息
public void update(AgencyPO po){
	con=db.getConnection();
	try {
		String sql=("UPDATE agency SET city=?,agencyType=? WHERE ID=?");
		stmt=con.prepareStatement(sql);
		stmt.setString(1, po.getCity());
		stmt.setInt(2, po.getAgencyType());
		stmt.setString(3, po.getID());
		stmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
