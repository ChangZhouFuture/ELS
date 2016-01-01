package data.documentsdata;

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
import data.utility.GenerateId;
import po.documentsPO.ReceivablesOrderPO;
import state.ApproState;
import state.ResultMessage;
import dataservice.documentsdataservice.ReceivablesOrderdataservice;

public class ReceivablesOrderdata extends UnicastRemoteObject implements ReceivablesOrderdataservice{

	public ReceivablesOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    JavaBean1 jb1;
    ReceivablesOrderPO po;
    GenerateId g;
	@Override
	public ResultMessage add(ReceivablesOrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into receivablesorder(ID,amount,courier,orderIDs,date,busiHallID)values(?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getID());
			stmt.setDouble(2, po.getAmount());
			stmt.setString(3, po.getCourier());
			stmt.setString(5, po.getDate());
			stmt.setString(6, po.getAgencyID());
			ArrayList<String> arr=po.getOrderIDs();
			String str="";
			for(int i=0;i<arr.size();i++){
				str=str+arr.get(i)+";";
			}
			str=str.substring(0, str.length()-1);
			stmt.setString(4, str);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
		
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		String sql="delete from receivablesorder where ID=?";
		try {
			for(int i=0;i<idList.size();i++){
				stmt=con.prepareStatement(sql);
				stmt.setString(1, idList.get(i));
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
		po=new ReceivablesOrderPO();
		ArrayList<ReceivablesOrderPO> pos=new ArrayList<>();
		String sql="select * from receivablesorder where ID=?";
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
		    ResultSet rs=stmt.executeQuery();
		    if(rs.next()){ 
		    	jb1.setResultMessage(ResultMessage.Success);
		    	po.setID(id);
			    po.setAmount(rs.getDouble(2));
			    po.setCourier(rs.getString(3));
			    po.setDate(rs.getString(5));
			    po.setApproState(ApproState.valueOf(rs.getString("approState")));
			    po.setAgencyID(rs.getString("busiHallID"));
			    String str=rs.getString(4);
			    String[] s=str.split(";");
			    ArrayList<String> arr=new ArrayList<>();
			    for(int i=0;i<s.length;i++){
			    	arr.add(i, s[i]);
			    }
			    po.setOrderIDs(arr);
			    pos.add(po);
			    
		    }jb1.setObject(pos);
		    
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
		
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		ArrayList<ReceivablesOrderPO> pos=new ArrayList<>();
		
		String[] s;
		String sql="select * from receivablesorder ";
		
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				po=new ReceivablesOrderPO();
				if(rs.getString("date").equals(date)
						&&rs.getString("approState").equals("NotApprove")){
					jb1.setResultMessage(ResultMessage.Success);
					po.setID(rs.getString(1));
					po.setAmount(rs.getDouble(2));
					po.setCourier(rs.getString(3));
					String str=rs.getString(4);
					s=str.split(";");
					ArrayList<String> arr=new ArrayList<>();
					for(int i=0;i<s.length;i++){
						arr.add(i, s[i]);
					}
					po.setOrderIDs(arr);
					po.setDate(date);
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					po.setAgencyID(rs.getString("busiHallID"));
					pos.add(po);
				}
				if(rs.getString("date").equals(date)
						&&rs.getString("approState").equals("Approve")){
					jb1.setResultMessage(ResultMessage.Success);
					po.setID(rs.getString(1));
					po.setAmount(rs.getDouble(2));
					po.setCourier(rs.getString(3));
					String str=rs.getString(4);
					s=str.split(";");
					ArrayList<String> arr1=new ArrayList<>();
					for(int i=0;i<s.length;i++){
						arr1.add(i, s[i]);
					}
					po.setOrderIDs(arr1);
					po.setDate(date);
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					po.setAgencyID(rs.getString("busiHallID"));
					pos.add(po);
				}
				
			}
			jb1.setObject(pos);
			
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
	}

	@Override
	public double generateAmount(ArrayList<String> ordersId) {
		// TODO Auto-generated method stub
		String sql="select * from dingdanorder";
		double total=0;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				for(int i=0;i<ordersId.size();i++){
					if(rs.getString("ID").equals(ordersId.get(i))){
						total+=rs.getDouble("totalCost");
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	@Override
	public ResultMessage update(ReceivablesOrderPO po) {
		// TODO Auto-generated method stub
		String sql="update receivablesorder set amount=?,courier=?,orderIDs=?,date=?,busiHallID=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setDouble(1, po.getAmount());
			stmt.setString(2, po.getCourier());
			stmt.setString(4, po.getDate());
			stmt.setString(5, po.getAgencyID());
			stmt.setString(6, po.getID());
			ArrayList<String> arr=po.getOrderIDs();
			String str="";
			for(int i=0;i<arr.size();i++){
				str=str+arr.get(i)+";";
			}
			str=str.substring(0, str.length()-1);
			stmt.setString(3, str);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public String generateId(String date) {
		// TODO Auto-generated method stub
		g=new GenerateId();
		return g.generateDocumentId(date, "receivablesorder");
	}

	@Override
	public JavaBean1 findC(String busiHallID) throws RemoteException {
		// TODO Auto-generated method stub
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		ArrayList<ReceivablesOrderPO> pos=new ArrayList<>();
		ArrayList<String> arr;
		String[] s;
		String sql="select * from receivablesorder ";
		
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				po=new ReceivablesOrderPO();
				if(rs.getString("busiHallID").equals(busiHallID)
						&&rs.getString("approState").equals("NotApprove")){
					jb1.setResultMessage(ResultMessage.Success);
					po.setID(rs.getString(1));
					po.setAmount(rs.getDouble(2));
					po.setCourier(rs.getString(3));
					String str=rs.getString(4);
					s=str.split(";");
					arr=new ArrayList<>();
					for(int i=0;i<s.length;i++){
						arr.add(i, s[i]);
					}
					po.setOrderIDs(arr);
					po.setDate(rs.getString("date"));
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					po.setAgencyID(rs.getString("busiHallID"));
					pos.add(po);
				}
				if(rs.getString("busiHallID").equals(busiHallID)
						&&rs.getString("approState").equals("Approve")){
					jb1.setResultMessage(ResultMessage.Success);
					po.setID(rs.getString(1));
					po.setAmount(rs.getDouble(2));
					po.setCourier(rs.getString(3));
					String str=rs.getString(4);
					s=str.split(";");
					arr=new ArrayList<>();
					for(int i=0;i<s.length;i++){
						arr.add(i, s[i]);
					}
					po.setOrderIDs(arr);
					po.setDate(rs.getString("date"));
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					po.setAgencyID(rs.getString("busiHallID"));
					pos.add(po);
				}
				
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
