// Program for jdbc 1 program:
package jdbcPack;

import java.sql.Connection;
import java.sql.DriverManager;

public class FirstJDBC {
	public static void main(String[] args) {
		try
		{
			//load the driver:  (add jar file in build path (library) )
			Class.forName("com.mysql.jdbc.Driver");
			
			// creating a connection
			String url = "jdbc:mysql://localhost:3306/practice";// here practice is a database we created before if i want and change and any update i'll do in this database;
			String username = "root";
			String password = "proot";
			
			Connection con = DriverManager.getConnection(url,username,password);
			
	// to check database connected or not
			if(con.isClosed()) System.out.println("Connection is Closed");
			else System.out.println("Connection is Created......!");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
