package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.JavaBean1;
import data.utility.Database;
import po.documentsPO.BusiHallArrivalOrderPO;
import po.documentsPO.TranCenArrivalOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
import dataservice.documentsdataservice.TranCenArrivalOrderdataservice;


public class TranCenArrivalOrderdata extends UnicastRemoteObject  implements TranCenArrivalOrderdataservice{
	

	public TranCenArrivalOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	JavaBean1 jb1;
	TranCenArrivalOrderPO po;
	TransferOrderlineitemPO llpo;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date now=new Date();
	@Override
	public TransferOrderlineitemPO addTransferOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addTranCenArrivalOrder(TranCenArrivalOrderPO tranCenArrivalOrderPO) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO trancenarrivalorder(ID,tranCenID,arrivalDate,transferOrderID,origin,goodState,generateTime)"+
				"values(?,?,?,?,?,?,?)";
				try {
					stmt=con.prepareStatement(sql);
					stmt.setString(1, po.getID());
					stmt.setString(2, po.getTranCenID());
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

	@Override
	public ResultMessage deleteOne(String id) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM trancenarrivalorder WHERE ID='"+id+"'";
		try {
			stmt=con.prepareStatement(sql);
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
			String sql="DELETE FROM trancenarrivalorder WHERE ID=?";
			stmt=con.prepareStatement(sql);
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
	public JavaBean1 findA(String id) {
		// TODO Auto-generated method stub
		ArrayList<TranCenArrivalOrderPO> pos = new ArrayList<>();
		po=new TranCenArrivalOrderPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			stmt = con.prepareStatement("SELECT * FROM trancenarrivalorder WHERE ID='"+id+"'");
			ResultSet rs=stmt.executeQuery(); 
			if(rs.next()){
				jb1.setResultMessage(ResultMessage.Success);
			    po.setID(id);
		        po.setTranCenID(rs.getString(2));
		        po.setArrivalDate(rs.getString(3));
		        po.setTransferOrderID(rs.getString(4));
		        po.setOrigin(rs.getString(5));
		        po.setGoodState(GoodState.valueOf(rs.getString(6)));
		        po.setGenerateTime(rs.getString(7));
		        pos.add(po);
			}
			jb1.setPOObject(pos);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		} 
		
	}

	@Override
	public JavaBean1 findB(String date) {
		// TODO Auto-generated method stub
		ArrayList<TranCenArrivalOrderPO> pos=new ArrayList<TranCenArrivalOrderPO>();
		po=new TranCenArrivalOrderPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String substr;
		try {
			stmt=con.prepareStatement("SELECT * FROM trancenarrivalorder");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
			    jb1.setResultMessage(ResultMessage.Success);
				substr=rs.getString(7).substring(0, 10);
				if(substr.equals(date)){
					po.setID(rs.getString(1));
			        po.setTranCenID(rs.getString(2));
			        po.setArrivalDate(rs.getString(3));
			        po.setTransferOrderID(rs.getString(4));
			        po.setOrigin(rs.getString(5));
			        po.setGoodState(GoodState.valueOf(rs.getString(6)));
			        po.setGenerateTime(rs.getString(7));
					pos.add(po);
				}
			}
			jb1.setPOObject(pos);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
		
	}

	@Override
	public ArrayList<TranCenArrivalOrderPO> findC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(TranCenArrivalOrderPO po) {
		// TODO Auto-generated method stub
		try {
			String sql=("UPDATE trancenarrivalorder SET tranCenID=?,arrivalDate=?,transferOrderID=?,"
					+ "origin=?,goodState=?,generateTime=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getTranCenID());
			stmt.setString(2, po.getArrivalDate());
			stmt.setString(3, po.getTransferOrderID());
			stmt.setString(4, po.getOrigin());
			stmt.setString(5, po.getGoodState().toString());
			stmt.setString(6, po.getGenerateTime());
			stmt.setString(7, po.getID());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}


	@Override
	public String generateStartAdd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId(String date) {
		// TODO Auto-generated method stub
		String sql="select * from trancenarrivalorder where date='"+date+"'";
		String sub,subId;
		int x;
		int last=0;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			if(!rs.next()){
				return date+"0001";
			}
			while(rs.next()){
				sub=rs.getString(1).substring(8);
				x=Integer.parseInt(sub);
				if(x>last){
					last=x;
				}
			}
			subId=Integer.toString(last);
			for(int i=0;i<4-subId.length();i++){
				subId="0"+subId;
			}
			return date+subId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
