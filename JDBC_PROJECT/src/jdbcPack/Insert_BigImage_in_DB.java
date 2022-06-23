package jdbcPack;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Insert_BigImage_in_DB {

	public static void main(String[] args) {
		try {
			
//	Here we are calling the "Connection Provider of method 'getConnection' " which we have created to make Connection		
			Connection c = ConnectionProvider.getConnection();
			
//  query for insert big image as we know we have created the variable and all in database here we have to give the value only 
//	  >> here we are inserting into image pic = value(?) this ? will take a value 	
			String q = "insert into images(pic) value(?)";
		
//	creating preparedStatement 
			PreparedStatement pstmt = c.prepareStatement(q);
			
//	Here we have to set the value of '?' like earlier we done  >>> but now we want to choose the image at a run time by dialog Box 
			JFileChooser jfc = new JFileChooser();
			
			jfc.showOpenDialog(null);
			
			File file = jfc.getSelectedFile();
			
			FileInputStream fis = new FileInputStream(file);
			
			pstmt.setBinaryStream(1, fis, fis.available());
			
			pstmt.executeUpdate();
			
//			System.out.println("Done ....!!");
			
//	if we want to show message in GUI form
			JOptionPane.showMessageDialog(null, "success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
