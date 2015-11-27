package data.documentsdata;

import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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

public class BusiHallArrivalOrderdata extends UnicastRemoteObject  implements BusiHallArrivalOrderdataservice {
	protected BusiHallArrivalOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    BusiHallArrivalOrderPO po;
    TransferOrderlineitemPO llpo;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date now=new Date();
    
	public TransferOrderlineitemPO addTransferOrder(String id) {    //中转单ID
		// TODO Auto-generated method stub
		String sql="SELECT * FROM ";
		//完成数据库里的transferOrder后再写
		return null;
	}

	@Override
	public ResultMessage addBusiHallArrivalOrder(BusiHallArrivalOrderPO po) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO busihallarrivalorder(ID,busiHallID,arrivalDate,transferOrderID,origin,goodState,generateTime)"+
		"values(?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getBusiHallID());
			stmt.setString(3, po.getArrivalDate());
			stmt.setString(4, po.getTransferOrderID());
			stmt.setString(5, po.getOrigin());
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
			String sql=("UPDATE busihallarrivalorder SET busiHallID=?,arrivalDate=?,transferOrderID=?,"
					+ "origin=?,goodState=?,generateTime=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getBusiHallID());
			stmt.setString(2, po.getArrivalDate());
			stmt.setString(3, po.getTransferOrderID());
			stmt.setString(4, po.getOrigin());
			stmt.setString(5, po.getGoodState().toString());
			stmt.setString(6, po.getGenerateTime());
			stmt.setString(7, po.getId());
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
			stmt=con.prepareStatement("DELETE FROM busihallarrivalorder WHERE ID=?");
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
			stmt=con.prepareStatement("DELETE FROM busihallarrivalorder WHERE ID=?");
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
	public ArrayList<BusiHallArrivalOrderPO> findA(String id) {
		// TODO Auto-generated method stub
		po=new BusiHallArrivalOrderPO();
		ArrayList<BusiHallArrivalOrderPO> pos=new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM busihallarrivalorder WHERE ID='"+id+"'");
			ResultSet rs=stmt.executeQuery(); 
			if(rs.next()){
			    po.setId(id);
		        po.setBusiHallID(rs.getString(2));
		        po.setArrivalDate(rs.getString(3));
		        po.setTransferOrderID(rs.getString(4));
		        po.setOrigin(rs.getString(5));
		        po.setGoodState(GoodState.valueOf(rs.getString(6)));
		        po.setGenerateTime(rs.getString(7));
		        pos.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return pos;
	}

	@Override
	public ArrayList<BusiHallArrivalOrderPO> findB(String date) {
		// TODO Auto-generated method stub
		po=new BusiHallArrivalOrderPO();
		ArrayList<BusiHallArrivalOrderPO> pos = new ArrayList<BusiHallArrivalOrderPO>();
		String sql="SELECT * FROM busihallarrivalorder";
		String substr;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(); 

			while(rs.next()){
		    substr=rs.getString(7).substring(0, 10);
		    if(substr==date){
			   po.setId(rs.getString(1));
			   po.setBusiHallID(rs.getString(2));
			   po.setArrivalDate(rs.getString(3));
			   po.setTransferOrderID(rs.getString(4));
			   po.setOrigin(rs.getString(5));
			   po.setGoodState(GoodState.valueOf(rs.getString(6)));
			   po.setGenerateTime(rs.getString(7));
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
