package data.utility;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dataservice.utilitydataservice.RecordOperaLogdataservice;
import state.OperaType;
import state.Position;
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
	public ResultMessage recordOperaLog(OperaType type, String date, String objectType, String id, Position position,
			String operatorId) throws RemoteException {
		String sql="insert into operalog(operaType,date,objectType,ID,position,operatorID) values(?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, type.toString());
			stmt.setString(2, date);
			stmt.setString(3, objectType);
			stmt.setString(4, id);
			stmt.setString(5, position.toString());
			stmt.setString(6, operatorId);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}

	}

}
