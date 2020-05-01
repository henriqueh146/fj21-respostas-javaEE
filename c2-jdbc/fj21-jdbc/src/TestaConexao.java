import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao
{
	public static void main(String [] args)
	{
		try
		{
			Connection conexao = ConnectionFactory.getConnection();
			System.out.println("Conectado!");
			conexao.close();
		}
		catch (SQLException e)
		{
			System.out.println("Não conectou");
		}
	}
}