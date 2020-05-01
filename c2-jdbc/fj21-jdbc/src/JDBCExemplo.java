import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class JDBCExemplo{

	public static void main(String [] args) throws SQLException
	{
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/fj21", "postgres", "12345678");
		System.out.println("Conectado!");
	}
}

