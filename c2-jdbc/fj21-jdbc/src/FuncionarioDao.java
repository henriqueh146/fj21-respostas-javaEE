import java.sql.Connection;
/*
conexao; construtor
create
read
update
delete
gets
*/
public class FuncionarioDao
{
	private Connection connection;

	public FuncionarioDao()
	{
		connection = ConnectionFactory.getConnection();
	}

	//CREATE
	public void adiciona(Funcionario funcionario)
	{

	}
}