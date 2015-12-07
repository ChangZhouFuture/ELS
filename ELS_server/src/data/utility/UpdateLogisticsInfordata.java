package data.utility;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.JavaBean1;
import state.ResultMessage;
import dataservice.utilitydataservice.UpdateLogisticsInfordataservice;
import po.utilityPO.LogisticsInforPO;

public class UpdateLogisticsInfordata extends UnicastRemoteObject implements UpdateLogisticsInfordataservice{

	Database db=new Database();
    Connection con=db.getConnection();
    JavaBean1 jb1;
    PreparedStatement stmt;
	public UpdateLogisticsInfordata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage update(LogisticsInforPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="insert into logistics(ID,generateTime,description) values(?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getGenerateTime());
			stmt.setString(3, po.getDescripition());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

}
