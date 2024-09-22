import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class JdbcUpdate {
	//static String query="update JD set id=1 name=\"alex\" pwd=\"hsdsad\" where name=david";			
	public static void main(String[] args) {					
		try {
			String url="jdbc:postgresql://localhost:5432/postgres";
			String uname="postgres";
			String pwd="root";
			String query="update JD set id=?, name=?, pwd=? where name='alex'";		
			Scanner obj=new Scanner(System.in);
			Connection con=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement state=con.prepareStatement(query);
			state.setInt(1,1);
			state.setString(2,"Raj");
			state.setString(3,"isdjwjw");	
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}