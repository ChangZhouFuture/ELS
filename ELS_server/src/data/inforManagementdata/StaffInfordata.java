package data.inforManagementdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.JavaBean1;
import po.inforManagementPO.SalaryStrategyPO;
import po.userPO.UserPO;
import state.Gender;
import state.PayType;
import state.Position;
import state.ResultMessage;
import data.utility.Database;
import dataservice.inforManagementdataservice.StaffInfordataservice;


public class StaffInfordata extends UnicastRemoteObject implements StaffInfordataservice{
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    UserPO po;
    JavaBean1 jb1;
    
    public StaffInfordata() throws RemoteException {
    	super();
    	// TODO Auto-generated constructor stub
    }
    
    
    public JavaBean1 findA(String Id){
    	po = new UserPO();
    	jb1=new JavaBean1();
    	jb1.setResultMessage(ResultMessage.NotExist);
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE ID='"+Id+"'");
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setId(Id);
		        po.setName(rs.getString("name"));
		        po.setPassword(rs.getString("password"));
		        po.setGender(Gender.valueOf(rs.getString("gender")));
		        po.setBirthDate(rs.getString("birthDate"));
		        po.setIdentyNum(rs.getString("identyNum"));
		        po.setPhone(rs.getString("phone"));
		        po.setCity(rs.getString("city"));
		        po.setRegion(rs.getString("region"));
		        po.setAgencyID(rs.getString("agencyID"));
		        po.setPosition(Position.valueOf(rs.getString("position")));
		        jb1.setObject(po);
		        jb1.setResultMessage(ResultMessage.Success);
			}return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
    }

	@Override
	public JavaBean1 findB(String position) throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<UserPO> pos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from user where position=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, position.toString());
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				po=new UserPO();
				po.setId(rs.getString(1));
		        po.setPassword(rs.getString(2));
		        po.setName(rs.getString(3));
		        po.setGender(Gender.valueOf(rs.getString(4)));
		        po.setBirthDate(rs.getString(5));
		        po.setIdentyNum(rs.getString(6));
		        po.setPhone(rs.getString(7));
		        po.setCity(rs.getString(8));
		        po.setRegion(rs.getString(9));
		        po.setAgencyID(rs.getString(10));
		        po.setPosition(Position.valueOf(rs.getString(11)));
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


	public ResultMessage SingleUpdateSalaryStrategy(SalaryStrategyPO po){
		// TODO Auto-generated method stub
		String sql="update salarystrategy set payType=?,payAmount=?,percentage=? where position=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(4, po.getPosition().toString());
			stmt.setString(1, po.getPayType().toString());
			stmt.setDouble(2, po.getPayAmount());
			stmt.setString(3, po.getPercentage());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}


	@Override
	public JavaBean1 getSalaryStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.Success);
		ArrayList<SalaryStrategyPO> pos=new ArrayList<>();
        pos.add(getSingleSalaryStrategy("Courier"));
        pos.add(getSingleSalaryStrategy("BusiHallClerk"));
        pos.add(getSingleSalaryStrategy("TranCenClerk"));
        pos.add(getSingleSalaryStrategy("StockManager"));
        pos.add(getSingleSalaryStrategy("Accountant2"));
        pos.add(getSingleSalaryStrategy("Accountant1"));
        pos.add(getSingleSalaryStrategy("Administrator"));
        pos.add(getSingleSalaryStrategy("Driver"));
        jb1.setObject(pos);
		return jb1;
	}
	
	public SalaryStrategyPO getSingleSalaryStrategy(String position){
		String sql="select * from salarystrategy where position=?";
		SalaryStrategyPO salaryStrategyPO=new SalaryStrategyPO();
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				salaryStrategyPO.setPosition(Position.valueOf(rs.getString(1)));
				salaryStrategyPO.setPayType(PayType.valueOf(rs.getString(2)));
				salaryStrategyPO.setPayAmount(rs.getDouble(3));
				salaryStrategyPO.setPercentage(rs.getString(4));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salaryStrategyPO;
	}


	@Override
	public ResultMessage updateSalaryStrategy(ArrayList<SalaryStrategyPO> salaryStrategyPOs) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage r=ResultMessage.Success;
		for(int i=0;i<salaryStrategyPOs.size();i++){
			r=SingleUpdateSalaryStrategy(salaryStrategyPOs.get(i));
		}
		return r;
	}
}

