package data.managerAndAccountantdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.JavaBean1;
import data.utility.Database;
import data.utility.TimeCompare;
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
    TimeCompare timeCompare;
    
	public StatisAnalydata() throws RemoteException {
		super();
	}

	@Override
	public JavaBean1 BusinessSituation(String StartDate, String EndDate) {
		return null;
	}

	@Override
	public JavaBean1 CostAndIncome(String date) {
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		timeCompare=new TimeCompare();
		costAndIncomePO=new CostAndIncomePO();
		String sql="select * from receivablesorde";
		double income=0;
		double cost=0;
		double profit;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(timeCompare.dateCompare(date, rs.getString("date"))==3){
					income=income+rs.getDouble("amount");
					jb1.setResultMessage(ResultMessage.Success);
				}
			}
			sql="select * from paymentorder";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				if(timeCompare.dateCompare(date, rs.getString("date"))==3){
					cost=cost+rs.getDouble("amount");
					jb1.setResultMessage(ResultMessage.Success);
				}
			}profit=income=cost;
			costAndIncomePO.setIncome(income);
			costAndIncomePO.setCost(cost);
			costAndIncomePO.setProfit(profit);
			jb1.setObject(costAndIncomePO);
			return jb1;
		} catch (SQLException e) {
			e.printStackTrace();
			return jb1;
		}
	}


}
