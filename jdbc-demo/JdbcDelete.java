import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDelete {
	public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/postgres";
	String uname="postgres";
	String pwd="root";
	String query="delete from JD where name=?";	
	try {
		Connection con=DriverManager.getConnection(url,uname,pwd);
		PreparedStatement state=con.prepareStatement(query);	
		state.setString(2,"alex");
		state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}