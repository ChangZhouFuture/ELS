package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import data.utility.Database;
import po.documentsPO.ArrivalOrder4BusiHallPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
import dataservice.documentsdataservice.ArrivalOrder4BusiHalldataservice;

public class ArrivalOrder4BusiHalldata extends UnicastRemoteObject implements ArrivalOrder4BusiHalldataservice {

	public ArrivalOrder4BusiHalldata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    ArrivalOrder4BusiHallPO po;
    TransferOrderlineitemPO llpo;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date now=new Date();
	@Override
	public TransferOrderlineitemPO addTransferOrder(String id) {    //中转单ID
		// TODO Auto-generated method stub
		String sql="SELECT * FROM ";
		//完成数据库里的transferOrder后再写
		return null;
	}

	@Override
	public ResultMessage addArrivalOrder4BusiHall(ArrivalOrder4BusiHallPO po) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO arrivalorder4busihall(ID,ID4BusiHall,arrivalDate,ID4TransferOrder,startingAddress,status,generateTime)"+
		"values(?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getID4BusiHall());
			stmt.setString(3, po.getArrivalDate());
			stmt.setString(4, po.getID4TransferOrder());
			stmt.setString(5, po.getStartingAddress());
			stmt.setString(6, po.getStatus().toString());
			stmt.setString(7, sdf.format(now));
			stmt.executeUpdate();
            return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	public ResultMessage update(ArrivalOrder4BusiHallPO po) {
		// TODO Auto-generated method stub
		try {
			String sql=("UPDATE arrivalorder4busihall SET ID4BusiHall=?,arrivalDate=?,ID4TransferOrder=?,"
					+ "startingAddress=?,status=?,generateTime=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getID4BusiHall());
			stmt.setString(2, po.getArrivalDate());
			stmt.setString(3, po.getID4TransferOrder());
			stmt.setString(4, po.getStartingAddress());
			stmt.setString(5, po.getStatus().toString());
			stmt.setString(7, po.getId());
			stmt.setString(6, po.getGenerateTime());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage deleteOne(String id) {
		// TODO Auto-generated method stub
		try {
			stmt=con.prepareStatement("DELETE FROM arrivalorder4busihall WHERE ID=?");
			stmt.setString(1, id);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<idlist.size();i++){
			stmt=con.prepareStatement("DELETE FROM arrivalorder4busihall WHERE ID=?");
			stmt.setString(1, idlist.get(i));
			stmt.executeUpdate();
			}
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ArrivalOrder4BusiHallPO findA(String id) {
		// TODO Auto-generated method stub
		po=new ArrivalOrder4BusiHallPO();
		try {
			stmt = con.prepareStatement("SELECT * FROM arrivalorder4busihall WHERE ID='"+id+"'");
			ResultSet rs=stmt.executeQuery(); 
			if(rs.next()){
			    po.setId(id);
		        po.setID4BusiHall(rs.getString("ID4BusiHall"));
		        po.setArrivalDate(rs.getString("arrivalDate"));
		        po.setID4TransferOrder(rs.getString("ID4TransferOrder"));
		        po.setStartingAddress(rs.getString("startingAddress"));
		        po.setStatus(GoodState.valueOf(rs.getString("status")));
		       
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return po;
	}

	@Override
	public ArrayList<ArrivalOrder4BusiHallPO> findB(String date) {
		// TODO Auto-generated method stub
		po=new ArrivalOrder4BusiHallPO();
		ArrayList<ArrivalOrder4BusiHallPO> pos = new ArrayList<ArrivalOrder4BusiHallPO>();
		String sql="SELECT * FROM arrivalorder4busihall";
		String substr;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(); 

			while(rs.next()){
		    substr=rs.getString(7).substring(0, 10);
		    if(substr==date){
			   po.setId(rs.getString(1));
			   po.setID4BusiHall(rs.getString(2));
			   po.setArrivalDate(rs.getString(3));
			   po.setID4TransferOrder(rs.getString(4));
			   po.setStartingAddress(rs.getString(5));
			   po.setStatus(GoodState.valueOf(rs.getString(6)));
			   pos.add(po);
		   }	
		
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pos;
	}

	@Override
	public ArrayList<ArrivalOrder4BusiHallPO> findC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateStartAdd(String transferOrderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
