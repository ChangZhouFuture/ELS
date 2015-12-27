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
import po.documentsPO.PaymentOrderPO;
import po.inforManagementPO.BankAccountPO;
import state.ApproState;
import state.ResultMessage;
import dataservice.documentsdataservice.PaymentOrderdataservice;


public class PaymentOrderdata extends UnicastRemoteObject implements PaymentOrderdataservice {

	public PaymentOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    JavaBean1 jb1;
    PaymentOrderPO po;
    GenerateId g;


	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		String sql="delete from paymentorder where ID=?";
		try {
			for(int i=0;i<idList.size();i++){
			stmt=con.prepareStatement(sql);
			stmt.setString(1, idList.get(i));
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
	public ResultMessage update(PaymentOrderPO po) {
		// TODO Auto-generated method stub
		String sql="update paymentorder set date=?,amount=?,payer=?,bankaccount=?,entry=?,note=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getDate());
			stmt.setDouble(2, po.getAmount());
			stmt.setString(3, po.getPayer());
			stmt.setString(4, po.getBankAccount());
			stmt.setString(5, po.getEntry());
			stmt.setString(6, po.getNote());
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
	public String generaId(String date) {
		// TODO Auto-generated method stub
		g=new GenerateId();
		return g.generateDocumentId(date, "paymentorder");
	}

	@Override
	public ResultMessage add(PaymentOrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into paymentorder(ID,date,amount,payer,bankaccount,entry,note)values(?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getID());
			stmt.setString(2, po.getDate());
			stmt.setDouble(3, po.getAmount());
			stmt.setString(4, po.getPayer());
			stmt.setString(5, po.getBankAccount());
			stmt.setString(6, po.getEntry());
			stmt.setString(7, po.getNote());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	@Override
	public JavaBean1 findA(String id) {
		// TODO Auto-generated method stub
		po=new PaymentOrderPO();
		ArrayList<PaymentOrderPO> pos=new ArrayList<>();
		jb1=new JavaBean1();
		String sql="select * from paymentorder where ID='"+id+"'";
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				po.setID(id);
				po.setDate(rs.getString(2));
				po.setAmount(rs.getDouble(3));
				po.setPayer(rs.getString(4));
				po.setBankAccount(rs.getString(5));
				po.setEntry(rs.getString(6));
				po.setNote(rs.getString(7));
				po.setApproState(ApproState.valueOf(rs.getString("approState")));
				pos.add(po);
				
				jb1.setResultMessage(ResultMessage.Success);
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
	public JavaBean1 findB(String date) {
		// TODO Auto-generated method stub
		
		ArrayList<PaymentOrderPO> pos=new ArrayList<>();
		jb1=new JavaBean1();
		String sql="select * from paymentorder";
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				po=new PaymentOrderPO();
				if(rs.getString("date").equals(date)&&
						rs.getString("approState").equals("NotApprove")){
					po.setID(rs.getString(1));
					po.setDate(rs.getString(2));
					po.setAmount(rs.getDouble(3));
					po.setPayer(rs.getString(4));
					po.setBankAccount(rs.getString(5));
					po.setEntry(rs.getString(6));
					po.setNote(rs.getString(7));
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
				if(rs.getString("date").equals(date)&&
						rs.getString("approState").equals("Approve")){
					po.setID(rs.getString(1));
					po.setDate(rs.getString(2));
					po.setAmount(rs.getDouble(3));
					po.setPayer(rs.getString(4));
					po.setBankAccount(rs.getString(5));
					po.setEntry(rs.getString(6));
					po.setNote(rs.getString(7));
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
			}
			jb1.setResultMessage(ResultMessage.Success);
			 return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
	}

}
