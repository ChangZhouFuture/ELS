package data_server.informngmtdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data_server.utility.Database;
import dataservice_server.informngmtdataservice.VehiclesInfordataservice;
import po_server.informngmtPO.VehiclesPO;

public class VehiclesInfordata implements VehiclesInfordataservice {
	Database db=new Database();
    Connection con;
    Statement sm;
    PreparedStatement stmt;
    VehiclesPO po;
    
    public void add(VehiclesPO po){
    	con=db.getConnection();
		try {
			stmt = con.prepareStatement("INSERT INTO vehicles(ID,plateNum,serviceTime) VALUES(?,?,?)");
			stmt.setString(1, po.getID());
		    stmt.setString(2, po.getPlateNum());
		    stmt.setInt(3, po.getServiceTime());
		    stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public VehiclesPO find(String Id){
    	po = new VehiclesPO();
		con=db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM vehicles WHERE ID='"+Id+"'");
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setID(Id);
		        po.setPlateNum(rs.getString("plateNum"));
		        po.setServiceTime(rs.getInt("serviceTime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
    }
    
    public void delete(String Id){
    	con=db.getConnection();
		try {
			stmt=con.prepareStatement("DELETE FROM vehicles WHERE ID=?");
			stmt.setString(1, Id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void update(VehiclesPO po){
    	con=db.getConnection();
		try {
			String sql=("UPDATE drivers SET plateNum=?,serviceTime=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getPlateNum());
			stmt.setInt(2, po.getServiceTime());
			stmt.setString(3, po.getID());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
