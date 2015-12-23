package data.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import state.Position;

public class GenerateId {

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	
	public String generateDocumentId(String date,String documentName){
		String sql="select * from ?";
		String subId;
		int temp;
		int last=0;
		String formatDate=date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, documentName);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString(1).substring(0, 8).equals(formatDate)){
					subId=rs.getString(1).substring(8);
					temp=Integer.parseInt(subId);
					if(temp>last){
						last=temp;
					}
				}
			}last=last+1;
			subId=Integer.toString(last);
			for(int i=0;i<4-subId.length();i++){
				subId="0"+subId;
			}
			return formatDate+subId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String generateTransferOrderId(String date,String trancenId){
		String sql="select * from transferorder";
		String subId;
		int temp;
		int last=0;
		String formatDate=date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString(1).substring(0, 15).equals(trancenId+formatDate)){
					subId=rs.getString(1).substring(15);
					temp=Integer.parseInt(subId);
					if(temp>last){
						last=temp;
					}
				}
			}last=last+1;
			subId=Integer.toString(last);
			for(int i=0;i<7-subId.length();i++){
				subId="0"+subId;
			}
			return trancenId+formatDate+subId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String generateIdOfOrder(String date){
		String sql="select * from dingdanorder";
		String subId="";
		int temp;
		int last=0;
		String formatDate=date.substring(2, 4)+date.substring(5, 7)+date.substring(8, 10);
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("ID").substring(0, 6).equals(formatDate)){
					subId=rs.getString("ID").substring(6);
					temp=Integer.parseInt(subId);
					if(temp>last){
						last=temp;
					}
				}
			}last=last+1;
			subId=String.valueOf(last);
			for(int i=0;i<4-subId.length();i++){
				subId="0"+subId;
			}
			return formatDate+subId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String generateUserId(Position position1){
		String sql="select * from user";
		int temp=0;
		String firstPart=null;
		String SecondPart=null;
		String position=position1.toString();
		switch(position){
		case "Accountant1":firstPart="00";break;
		case "Accountant2":firstPart="01";break;
		case "Administrator":firstPart="02";break;
		case "BusiHallClerk":firstPart="03";break;
		case "Courier":firstPart="04";break;
		case "GeneralManager":firstPart="05";break;
		case "StockManager":firstPart="06";break;
		case "TranCenClerk":firstPart="07";break;
		}
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("position").equals(position)){
					int subId=Integer.parseInt(rs.getString("ID").substring(2));
					if(temp<subId){
						temp=subId;
					}
				}
			}temp++;
			SecondPart=String.valueOf(temp);
			for(int i=0;i<6-SecondPart.length();i++){
				SecondPart="0"+SecondPart;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return firstPart+SecondPart;
	}
	
	public String generateTrucksNum(String firstPart,String loadingListType){ //ÆûÔË±àºÅ
		String sql="select * from ?";
		int temp=0;
		int sub=0;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, loadingListType);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("trucksNum").substring(0, 15).equals(firstPart)){
					sub=Integer.parseInt(rs.getString("trucksNum").substring(15));
					if(sub>temp){
						temp=sub;
					}
				}
			}temp++;
			String last=String.valueOf(temp);
			if(loadingListType=="busihallloadinglist"){
				for(int i=0;i<5-last.length();i++){
					last="0"+last;
				}
			}else{
				for(int i=0;i<7-last.length();i++){
					last="0"+last;
				}
			}
			return firstPart+last;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
