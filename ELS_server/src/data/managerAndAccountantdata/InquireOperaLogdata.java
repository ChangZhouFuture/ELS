package data.managerAndAccountantdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.JavaBean1;
import data.utility.Database;
import po.utilityPO.OperaLogPO;
import state.OperaType;
import state.ResultMessage;
import dataservice.managerAndAccountantdataservice.InquireOperaLogdataservice;

public class InquireOperaLogdata extends UnicastRemoteObject implements InquireOperaLogdataservice{

	Database db=new Database();
    Connection con=db.getConnection();
    JavaBean1 jb1;
    PreparedStatement stmt;
    OperaLogPO po;
    
	public InquireOperaLogdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public JavaBean1 inquire( String date) {
		// TODO Auto-generated method stub
		String sql="select * from operalog where date=?";
		po=new OperaLogPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		ArrayList<OperaLogPO> pos=new ArrayList<>();
		try {
			stmt=con.prepareStatement(sql);

			stmt.setString(1, date);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				po.setDate(date);
				po.setOperaType(OperaType.valueOf(rs.getString(2)));
				po.setObjectType(rs.getString(3));
				po.setId(rs.getString(4));
				po.setOperatorId(rs.getString(5));
				po.setGenerateTime(rs.getString(6));
				pos.add(po);
				jb1.setResultMessage(ResultMessage.Success);
			}
			jb1.setObject(pos);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
	}

}
