
package data_server.inforManagementdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data_server.utility.Database;
import dataservice_server.inforManagementdataservice.BankAccountInfordataservice;
import po_server.inforManagementPO.BankAccountPO;
import state.ResultMessage;

public class BankAccountInfordata implements BankAccountInfordataservice {
	Database db=new Database();
    Connection con;
    Statement sm;
    PreparedStatement stmt;
    BankAccountPO po;
    
//�����������˻���Ϣ
public ResultMessage add(BankAccountPO po){
	con=db.getConnection();
	try {
		stmt = con.prepareStatement("INSERT INTO bankAccount(name,amount) VALUES(?,?)");
		stmt.setString(1, po.getName());
	    stmt.setDouble(2, po.getAmount());
	    stmt.executeUpdate();
	    return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.Fail;
	}
}

//���������˻���Ϣ
public BankAccountPO find(String name){
	po = new BankAccountPO();
	con=db.getConnection();
	try {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM bankAccount WHERE name='"+name+"'");
		
		 //��Сд�����𣬴˴���дΪ���������֣�where��ʾ����
		ResultSet rs=ps.executeQuery(); 
		if(rs.next()){
		    po.setName(name);
	        po.setAmount(rs.getDouble("amount"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return po;
}

//ɾ��������Ϣ
public ResultMessage deleteOne(String name){
	con=db.getConnection();
	try {
		stmt=con.prepareStatement("DELETE FROM bankAccount WHERE name=?");
		stmt.setString(1, name);
		stmt.executeUpdate();
		return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.NotExist;
	}
}

@Override
public ResultMessage deleteMany(ArrayList<String> names) {
	// TODO Auto-generated method stub
	con=db.getConnection();
	try {
		for(int i=0;i<names.size();i++){
		stmt=con.prepareStatement("DELETE FROM bankAccount WHERE name=?");
		stmt.setString(1, names.get(i));
		stmt.executeUpdate();
		}
		return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.NotExist;
	}
}

//�޸������˻���Ϣ
public ResultMessage update(BankAccountPO po){
	con=db.getConnection();
	try {
		String sql=("UPDATE bankAccount SET amount=? WHERE name=?");
		stmt=con.prepareStatement(sql);
		stmt.setDouble(1, po.getAmount());
		stmt.setString(2, po.getName());
		stmt.executeUpdate();
		return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.NotExist;
	}
}


}
