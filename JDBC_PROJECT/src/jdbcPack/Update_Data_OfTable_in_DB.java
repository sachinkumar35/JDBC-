package jdbcPack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update_Data_OfTable_in_DB {

	public static void main(String[] args) {
		
		try {
			
			Connection con = ConnectionProvider.getConnection();
			
//	Query to Update data of table in database
			String q = "update table1 set tName=?, tCity=? where tId=?";
			
//			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
//			
//			System.out.println("Enter new Name : ");
//			String name = br.readLine();
//			
//			System.out.println("Enter new City : ");
//			String city = br.readLine();
//			
//			System.out.println("Enter Student ID : ");
//			int id = Integer.parseInt(br.readLine());
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter new Name : ");
			String name = sc.nextLine();
			
			System.out.println("Enter new City : ");
			String city = sc.nextLine();
			
			System.out.println("Enter Student ID : ");
			int id = sc.nextInt();
			
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			
			pstmt.setInt(3, id);
			
			pstmt.executeUpdate();
			
			System.out.println("Done.......!!");
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
