import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class JdbcSelectW {
	//static String query="update JD set id=1 name=\"alex\" pwd=\"hsdsad\" where name=david";			
	public static void main(String[] args) {					
		try {
			String url="jdbc:postgresql://localhost:5432/postgres";
			String uname="postgres";
			String pwd="root";	
			String query="SELECT * FROM JD WHERE name=?";
			Connection con=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement state=con.prepareStatement(query);
			state.setString(2,"alex");
			ResultSet rst=state.executeQuery();
				while (rst.next()) {
				System.out.println("ID is::"+rst.getInt(1));
				System.out.println("Name is::"+rst.getString(2));
				System.out.println("Password is::"+rst.getString(3)+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}