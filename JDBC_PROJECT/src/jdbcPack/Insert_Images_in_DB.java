package jdbcPack;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert_Images_in_DB {
	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//	create connection		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","proot");

//	Query for insert		
			String q = "insert into images(pic) values(?)";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
//	to read file we made file object of fileInputStream ( it will fatch the file from machine )		
			FileInputStream file = new FileInputStream("J:\\JDBC\\pict.jpg");
//	here we set the file in database so 1 is first '?' and file and file.available will return how many bites are available  		
			pstmt.setBinaryStream(1, file, file.available());
			
			pstmt.executeUpdate();
			
			System.out.println("Done....");
			
		} catch (Exception e) {
			System.out.println("Error !!");
			e.printStackTrace();
		}
	}
}
