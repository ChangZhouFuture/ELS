package data_server.utility;

import  java.sql.*;

public class Database {
		Connection con;
        
        final String URL="jdbc:mysql://127.0.0.1:3306/information_store";
	
	public Database(){	
        try {
		    Class.forName("com.mysql.jdbc.Driver");        //º”‘ÿjdbc«˝∂Ø≥Ã–Ú
		    con=DriverManager.getConnection(URL,"root","root");
	    } catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
	    }
	}
	public Connection getConnection(){
		return con;
	}
}
 