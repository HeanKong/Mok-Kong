package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getConnection {
	public getConnection() {
		
	}

	public static void connection(String url,String sql) {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String name ="root";
			String pass= "123456789";
			Class.forName(driver);
			Connection myCon = DriverManager.getConnection(url,name,pass);
			PreparedStatement prs = myCon.prepareStatement(sql);
			ResultSet rs = prs.executeQuery();
			return;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
