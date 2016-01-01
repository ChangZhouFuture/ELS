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
	public ResultMessage recordOperaLog(OperaType type, String date, String objectType, String id, String operatorId) {
		// TODO Auto-generated method stub
		String sql="insert into operalog(operaType,date,objectType,ID,position,operatorID) values(?,?,?,?,?,?)";
		String position=null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, type.toString());
			stmt.setString(2, date);
			stmt.setString(3, objectType);
			stmt.setString(4, id);
			stmt.setString(6, operatorId);
			String sub=operatorId.substring(0,2);
			switch(sub){
			case "00":position="Accountant1";break;
			case "01":position="Accountant2";break;
			case "02":position="Administrator";break;
			case "03":position="BusiHallClerk";break;
			case "04":position="Courier";break;
			case "05":position="GeneralManager";break;
			case "06":position="StockManager";break;
			case "07":position="TranCenClerk";break;
			}
			stmt.setString(5, position);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}

	}

}
