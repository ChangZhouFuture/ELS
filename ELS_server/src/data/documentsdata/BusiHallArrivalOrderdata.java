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
import po.documentsPO.BusiHallArrivalOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
import dataservice.documentsdataservice.BusiHallArrivalOrderdataservice;

public class BusiHallArrivalOrderdata extends UnicastRemoteObject implements BusiHallArrivalOrderdataservice {
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    BusiHallArrivalOrderPO po;
    TransferOrderlineitemPO llpo;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date now=new Date();
    
    public BusiHallArrivalOrderdata() throws RemoteException {
    	super();
    	// TODO Auto-generated constructor stub
    }
	@Override
	public TransferOrderlineitemPO addTransferOrder(String id) {    //中转单ID
		// TODO Auto-generated method stub
		String sql="SELECT * FROM ";
		//完成数据库里的transferOrder后再写
		return null;
	}

	@Override
	public ResultMessage addArrivalOrder4BusiHall(BusiHallArrivalOrderPO po) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO arrivalorder4busihall(ID,ID4BusiHall,arrivalDate,ID4TransferOrder,startingAddress,status,generateTime)"+
		"values(?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
//			stmt.setString(2, po.getID4BusiHall());
			stmt.setString(3, po.getDate());
			stmt.setString(4, po.getTransferOrderId());
			stmt.setString(5, po.getStartingAdd());
			stmt.setString(6, po.getGoodState().toString());
			stmt.setString(7, sdf.format(now));
			stmt.executeUpdate();
            return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	public ResultMessage update(BusiHallArrivalOrderPO po) {
		// TODO Auto-generated method stub
		try {
			String sql=("UPDATE arrivalorder4busihall SET ID4BusiHall=?,arrivalDate=?,ID4TransferOrder=?,"
					+ "startingAddress=?,status=?,generateTime=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
//			stmt.setString(1, po.getID4BusiHall());
			stmt.setString(2, po.getDate());
			stmt.setString(3, po.getTransferOrderId());
			stmt.setString(4, po.getStartingAdd());
			stmt.setString(5, po.getGoodState().toString());
			stmt.setString(7, po.getId());
//			stmt.setString(6, po.getGenerateTime());
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
	public BusiHallArrivalOrderPO findA(String id) {
		// TODO Auto-generated method stub
		po=new BusiHallArrivalOrderPO();
		try {
			stmt = con.prepareStatement("SELECT * FROM arrivalorder4busihall WHERE ID='"+id+"'");
			ResultSet rs=stmt.executeQuery(); 
			if(rs.next()){
			    po.setId(id);
//		        po.setID4BusiHall(rs.getString("ID4BusiHall"));
		        po.setDate(rs.getString("arrivalDate"));
		        po.setTransferOrderId(rs.getString("ID4TransferOrder"));
		        po.setStartingAdd(rs.getString("startingAddress"));
		        po.setGoodState(GoodState.valueOf(rs.getString("status")));
		       
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return po;
	}

	@Override
	public ArrayList<BusiHallArrivalOrderPO> findB(String date) {
		// TODO Auto-generated method stub
		po=new BusiHallArrivalOrderPO();
		ArrayList<BusiHallArrivalOrderPO> pos = new ArrayList<BusiHallArrivalOrderPO>();
		String sql="SELECT * FROM arrivalorder4busihall";
		String substr;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(); 

			while(rs.next()){
		    substr=rs.getString(7).substring(0, 10);
		    if(substr==date){
			   po.setId(rs.getString(1));
//			   po.setID4BusiHall(rs.getString(2));
			   po.setDate(rs.getString(3));
			   po.setTransferOrderId(rs.getString(4));
			   po.setStartingAdd(rs.getString(5));
			   po.setGoodState(GoodState.valueOf(rs.getString(6)));
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
	public ArrayList<BusiHallArrivalOrderPO> findC() {
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
