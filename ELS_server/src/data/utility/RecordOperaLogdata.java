package data.utility;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dataservice.utilitydataservice.RecordOperaLogdataservice;
import state.OperaType;
import state.ResultMessage;

public class RecordOperaLogdata extends UnicastRemoteObject implements RecordOperaLogdataservice{

	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
	public RecordOperaLogdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage recordOperaLog(OperaType type, String date, String objectType, String id, String operatorId) {
		// TODO Auto-generated method stub
		String sql="insert into operalog(operaType,date,objectType,ID,operatorID) values(?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, type.toString());
			stmt.setString(2, date);
			stmt.setString(3, objectType);
			stmt.setString(4, id);
			stmt.setString(5, operatorId);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}

	}

}
