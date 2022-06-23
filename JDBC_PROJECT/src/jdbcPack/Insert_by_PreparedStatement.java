package jdbcPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert_by_PreparedStatement {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// creating a connection
			String url = "jdbc:mysql://localhost:3306/practice";// here practice is a database we created before if i want and change and any update i'll do in this database;
			String username = "root";
			String password = "proot";
			
			Connection con = DriverManager.getConnection(url,username,password);
			
//	CREATE A QUERY
			String q="insert into table1(tName,tCity) values (?,?)";
//	get the PreparedStatement object
			PreparedStatement pstmt = con.prepareStatement(q);
//	Set the values to query
			pstmt.setString(1, "sachin bhardwaj");
			pstmt.setString(2, "Mathura");
			
			pstmt.executeUpdate();
			
//		message
			System.out.println("Inserted...");
			
			con.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
