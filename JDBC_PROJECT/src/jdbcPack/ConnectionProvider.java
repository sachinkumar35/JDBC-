package jdbcPack;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	// creating private connection variable con;
		private static Connection con;
		
	// creating a Connection Method to write the code to make connection
		public static Connection getConnection() {
			
			try {
			if(con==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
	//	create connection		
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","proot");

			} 
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return con;
		}	
	}

