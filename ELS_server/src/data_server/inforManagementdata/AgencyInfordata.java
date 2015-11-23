package data_server.inforManagementdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data_server.utility.Database;
import dataservice_server.inforManagementdataservice.AgencyInfordataservice;
import po_server.inforManagementPO.AgencyPO;
import state.ResultMessage;

public class AgencyInfordata implements AgencyInfordataservice{
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    AgencyPO po;
    
//�����»�����Ϣ
public ResultMessage add(AgencyPO po){
	try {
		stmt = con.prepareStatement("INSERT INTO agency(ID,city,agencyType) VALUES(?,?,?)");
		stmt.setString(1, po.getID());
	    stmt.setString(2, po.getCity());
	    stmt.setInt(3, po.getAgencyType());
	    stmt.executeUpdate();
	    return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.Fail;
	}
}

//���һ�����Ϣ
public AgencyPO find(String Id){
	po = new AgencyPO();
	try {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM agency WHERE ID='"+Id+"'");
		
		 //��Сд�����𣬴˴���дΪ���������֣�where��ʾ����
		ResultSet rs=ps.executeQuery(); 
		if(rs.next()){
		    po.setID(Id);
	        po.setCity(rs.getString("city"));
	        po.setAgencyType(rs.getInt("agencyType"));
	        
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return po;
}

//ɾ��������Ϣ
public ResultMessage deleteOne(String Id){
	try {
		stmt=con.prepareStatement("DELETE FROM agency WHERE ID=?");
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
		stmt=con.prepareStatement("DELETE FROM agency WHERE ID=?");
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

//�޸Ļ�����Ϣ
public ResultMessage update(AgencyPO po){
	try {
		String sql=("UPDATE agency SET city=?,agencyType=? WHERE ID=?");
		stmt=con.prepareStatement(sql);
		stmt.setString(1, po.getCity());
		stmt.setInt(2, po.getAgencyType());
		stmt.setString(3, po.getID());
		stmt.executeUpdate();
		return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.NotExist;
	}
}


}
