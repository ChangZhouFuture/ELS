package data_server.inforManagementdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import po_server.inforManagementPO.VehiclesPO;
import state.ResultMessage;
import data_server.utility.Database;
import dataservice_server.inforManagementdataservice.VehiclesInfordataservice;

public class VehiclesInfordata implements VehiclesInfordataservice {
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    VehiclesPO po;
    
    public ResultMessage add(VehiclesPO po){
		try {
			stmt = con.prepareStatement("INSERT INTO vehicles(ID,plateNum,serviceTime) VALUES(?,?,?)");
			stmt.setString(1, po.getID());
		    stmt.setString(2, po.getPlateNum());
		    stmt.setInt(3, po.getServiceTime());
		    stmt.executeUpdate();
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
    }
    
    public VehiclesPO find(String Id){
    	po = new VehiclesPO();
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
    
    public ResultMessage deleteOne(String Id){

		try {
			stmt=con.prepareStatement("DELETE FROM vehicles WHERE ID=?");
			stmt.setString(1, Id);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
    }
    
    public ResultMessage update(VehiclesPO po){

		try {
			String sql=("UPDATE drivers SET plateNum=?,serviceTime=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getPlateNum());
			stmt.setInt(2, po.getServiceTime());
			stmt.setString(3, po.getID());
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
			stmt=con.prepareStatement("DELETE FROM vehicles WHERE ID=?");
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
    
}
