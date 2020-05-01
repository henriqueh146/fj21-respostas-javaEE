import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory
{
	public static Connection getConnection() 
	{
		try
		{
			return DriverManager.getConnection("jdbc:postgresql://localhost/fj21", "postgres", "12345678");
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
}