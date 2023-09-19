package library.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/lib";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    Connection con;
	Statement stmt;
	
	public Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			stmt = con.createStatement();
			
			
		}catch(Exception e) {
			
		}
	}

}

