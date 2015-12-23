package data.managerAndAccountantdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.JavaBean1;
import data.utility.Database;
import po.StatisAnalyPO.CostAndIncomePO;
import state.ResultMessage;
import dataservice.managerAndAccountantdataservice.StatisAnalydataservice;


public class StatisAnalydata extends UnicastRemoteObject implements
StatisAnalydataservice{
	Database db=new Database();
    Connection con=db.getConnection();
    JavaBean1 jb1;
    PreparedStatement stmt;
    CostAndIncomePO costAndIncomePO;
    
	public StatisAnalydata() throws RemoteException {
		super();
	}

	@Override
	public JavaBean1 findCostAndIncomeTable() {
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		costAndIncomePO=new CostAndIncomePO();
		String sql="select * from costandincome";
        try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				costAndIncomePO.setCost(rs.getDouble("cost"));
				costAndIncomePO.setIncome(rs.getDouble("income"));
				costAndIncomePO.setProfit(rs.getDouble("profit"));
				jb1.setResultMessage(ResultMessage.Success);
				jb1.setObject(costAndIncomePO);
			}
		    return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}	
	}

	@Override
	public void updateCostAndIncomeTable(double amount, String costOrIncome) throws RemoteException {
		// TODO Auto-generated method stub
		if(costOrIncome=="cost"){
			String sql="select * from costandincome";
			try {
				stmt=con.prepareStatement(sql);
				ResultSet rs=stmt.executeQuery();
				double cost=rs.getDouble("cost");
				double profit=rs.getDouble("profit");
				sql="update costandincome set cost=?,profit=?";
				stmt=con.prepareStatement(sql);
				stmt.setDouble(1, cost+amount);
				stmt.setDouble(2, profit-amount);
				stmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(costOrIncome=="income"){
			String sql="select * from costandincome";
			try {
				stmt=con.prepareStatement(sql);
				ResultSet rs=stmt.executeQuery();
				double income=rs.getDouble("income");
				double profit=rs.getDouble("profit");
				sql="update costandincome set income=?,profit=?";
				stmt=con.prepareStatement(sql);
				stmt.setDouble(1, income+amount);
				stmt.setDouble(2, profit+amount);
				stmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


}
