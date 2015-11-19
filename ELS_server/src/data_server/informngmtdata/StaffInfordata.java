package data_server.informngmtdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data_server.utility.Database;
import dataservice_server.informngmtdataservice.StaffInfordataservice;
import po_server.informngmtPO.StaffPO;

public class StaffInfordata implements StaffInfordataservice{
	Database db=new Database();
    static Connection con;
    static String URL="jdbc:mysql://127.0.0.1:3306/information_store";
    Statement sm;
    PreparedStatement stmt;
    StaffPO po;
    
    public void add(StaffPO po){
    	con=db.getConnection();
		try {
			stmt = con.prepareStatement("INSERT INTO staff(ID,name,gender,birthDate,identyNum,phone,agency,position,payType,payAmount,percentage) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, po.getID());
		    stmt.setString(2, po.getName());
		    stmt.setInt(3, po.getGender());
		    stmt.setString(4, po.getBirthDate());
		    stmt.setString(5, po.getIdentyNum());
		    stmt.setString(6, po.getPhone());
		    stmt.setString(7, po.getAgency());
		    stmt.setInt(8, po.getPosition());
		    stmt.setInt(9, po.getPayType());
		    stmt.setDouble(10, po.getPayAmount());
		    stmt.setString(11, po.getPercentage());
		    stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public StaffPO find(String Id){
    	po = new StaffPO();
		con=db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM staff WHERE ID='"+Id+"'");
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setID(Id);
		        po.setName(rs.getString("name"));
		        po.setGender(rs.getInt("gender"));
		        po.setBirthDate(rs.getString("birthDate"));
		        po.setIdentyNum(rs.getString("identyNum"));
		        po.setPhone(rs.getString("phone"));
		        po.setAgency(rs.getString("agency"));
		        po.setPosition(rs.getInt("position"));
		        po.setPayType(rs.getInt("payType"));
		        po.setPayAmount(rs.getDouble("payAmount"));
		        po.setPercentage(rs.getString("percentage"));
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
			stmt=con.prepareStatement("DELETE FROM staff WHERE ID=?");
			stmt.setString(1, Id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void update(StaffPO po){
    	con=db.getConnection();
		try {
			String sql=("UPDATE drivers SET name=?,gender=?,birthDate=?,identyNum=?,phone=?,agency=?,position=?,payType=?,payAmount=?,percentage=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getName());
		    stmt.setInt(2, po.getGender());
		    stmt.setString(3, po.getBirthDate());
		    stmt.setString(4, po.getIdentyNum());
		    stmt.setString(5, po.getPhone());
		    stmt.setString(6, po.getAgency());
		    stmt.setInt(7, po.getPosition());
		    stmt.setInt(8, po.getPayType());
		    stmt.setDouble(9, po.getPayAmount());
		    stmt.setString(10, po.getPercentage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
