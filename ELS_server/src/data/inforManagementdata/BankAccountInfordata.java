
package data.inforManagementdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.JavaBean1;
import po.inforManagementPO.BankAccountPO;
import data.utility.Database;
import dataservice.inforManagementdataservice.BankAccountInfordataservice;
import state.ResultMessage;

public class BankAccountInfordata extends UnicastRemoteObject implements BankAccountInfordataservice {
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    BankAccountPO po;
    JavaBean1 jb1;
    
    public BankAccountInfordata() throws RemoteException {
    	super();
    	// TODO Auto-generated constructor stub
    }
//�����������˻���Ϣ
public ResultMessage add(BankAccountPO po){
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
public JavaBean1 find(String name){
	po = new BankAccountPO();
	jb1=new JavaBean1();
	jb1.setResultMessage(ResultMessage.NotExist);
	try {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM bankAccount WHERE name='"+name+"'");
		
		 //��Сд�����𣬴˴���дΪ���������֣�where��ʾ����
		ResultSet rs=ps.executeQuery(); 
		if(rs.next()){
		    po.setName(name);
	        po.setAmount(rs.getDouble("amount"));
	        jb1.setResultMessage(ResultMessage.Success);
	        jb1.setObject(po);
		}
		return jb1;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return jb1;
	}
}

//ɾ��������Ϣ
public ResultMessage deleteOne(String name){
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
