package jdbcPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class InsertJDBC {
	public static void main(String[] args) {
		try {
			//load the driver:  (add jar file in build path (library) )
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// creating a connection
			String url = "jdbc:mysql://localhost:3306/practice";// here practice is a database we created before if i want and change and any update i'll do in this database;
			String username = "root";
			String password = "proot";
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";
			
			//create a Statement:
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate(q);
			System.out.println("table created in database..!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
