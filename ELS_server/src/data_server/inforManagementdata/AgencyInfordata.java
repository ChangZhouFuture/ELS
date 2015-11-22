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
    
//�����»�����Ϣ
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

//���һ�����Ϣ
public AgencyPO find(String Id){
	po = new AgencyPO();
	con=db.getConnection();
	try {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM agency WHERE ID='"+Id+"'");
		
		 //��Сд�����𣬴˴���дΪ���������֣�where��ʾ����
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

//ɾ��������Ϣ
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

//�޸Ļ�����Ϣ
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
