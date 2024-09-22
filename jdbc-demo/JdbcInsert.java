import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsert {
	
	public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/postgres";
	String uname="postgres";
	String pwd="root";
	
	String query1="insert into JD(id,name,pwd) values(?,?,?)";
				
		try{
			Connection conn1=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement prepare1=conn1.prepareStatement(query1);			
			prepare1.setInt(1,1);
			prepare1.setString(2,"david");
			prepare1.setString(3,"12345678");
			prepare1.executeUpdate();
		}
	catch(SQLException e) {
			e.printStackTrace();
		}
	}

}