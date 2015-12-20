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
	public JavaBean1 CostAndIncome() {
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


}
