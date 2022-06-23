package jdbcPack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Selecting_Data_Using_JavaApp {

	public static void main(String[] args) {
		
		try {
			
			Connection con = ConnectionProvider.getConnection();
			
//		Query for Selecting data	
			String q = "select * from table1";
			
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) // this while loop return true or false -> if there is next row then it will return true else false
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String city = set.getString(3);
				
				System.out.println(name+ " : " + city + " : "+ id);
			}
			
			con.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
