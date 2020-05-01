import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionFactory
{
	public static void main (String [] args) throws SQLException
	{
		Connection con = ConnectionFactory.getConnection();
		System.out.println("Conectado!");
		con.close();
	}
}