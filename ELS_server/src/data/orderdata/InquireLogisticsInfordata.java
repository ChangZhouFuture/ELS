package data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.JavaBean1;
import data.utility.Database;
import dataservice.orderdataservice.InquireLogisticsInfordataservice;
import po.utilityPO.LogisticsInforPO;
import state.ResultMessage;

public class InquireLogisticsInfordata extends UnicastRemoteObject
implements InquireLogisticsInfordataservice{

	Database db=new Database();
    Connection con=db.getConnection();
    JavaBean1 jb1;
    PreparedStatement stmt;
    LogisticsInforPO po;
    
	public InquireLogisticsInfordata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public JavaBean1 inquireLogisticsInfor(String orderID) {
		// TODO Auto-generated method stub
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		po=new LogisticsInforPO();
		ArrayList<LogisticsInforPO> pos=new ArrayList<>();
		String sql="select * from logistics where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, orderID);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				po.setId(orderID);
				po.setGenerateTime(rs.getString("generateTime"));
				po.setDescripition(rs.getString("descripition"));
				pos.add(po);
				jb1.setResultMessage(ResultMessage.Success);
			}
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
	}

}
