package UIlayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class SqlConnection {
	
	 
	
	public static Connection DbConnector(){
		
		try{
			Connection conn=null;
		 
			Class.forName("org.sqlite.JDBC");
			
		try {
			conn=DriverManager.getConnection("jdbc:sqlite:Test.sqlite");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}catch (ClassNotFoundException  e){
	
		System.out.println(e);
	}
		
	
		return null;

	}
}
