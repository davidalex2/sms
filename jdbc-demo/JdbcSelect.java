import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class JdbcSelect {
	public static void main(String[] args) {		
		String url="jdbc:postgresql://localhost:5432/postgres";
		String uname="postgres";
		String pwd="root";	
		try {
			Connection con=DriverManager.getConnection(url,uname,pwd);
			String query="SELECT * FROM student";		
			PreparedStatement ps=con.prepareStatement(query);
			ps.executeQuery();
			ResultSet rst=ps.executeQuery();
			while (rst.next()) {
				System.out.println("ID is::"+rst.getInt(1));
				System.out.println("Name is::"+rst.getString(2));
				System.out.println("Password is::"+rst.getString(3));
				System.out.println("Date of birth::"+rst.getDate(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}