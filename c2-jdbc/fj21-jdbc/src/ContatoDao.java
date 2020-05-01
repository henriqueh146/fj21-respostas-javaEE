import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.ArrayList;

public class ContatoDao
{
	private Connection connection; 

	public ContatoDao()
	{
		connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Contato contato)
	{
		String sql = "INSERT INTO contatos (nome, email, endereco, datanascimento) VALUES (?, ?, ?, ?)";

		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
		}
		catch (SQLException e)
		{
			throw new DAOException(e);
		}	
	}

	public void altera(Contato contato)
	{
		try
		{
			String sql = "update contatos set nome = ?, email = ?, endereco = ?, datanascimento = ? where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();

			stmt.close();
		}
		catch (SQLException e)
		{
			throw new DAOException(e);
		}
	}

	public void remove(Contato contato)
	{
		try
		{
			String sql = "delete from contatos where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();

			stmt.close();
		}
		catch (SQLException e)
		{
			throw new DAOException(e);
		}

	}

	public ArrayList<Contato> getLista()
	{
		ArrayList<Contato> contatos = new ArrayList<>();
		try{

			PreparedStatement statement = connection.prepareStatement("select * from contatos");
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next())
			{
				Contato contato = new Contato();
				contato.setId(resultSet.getLong("id"));
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setEndereco(resultSet.getString("endereco"));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(resultSet.getDate("dataNascimento"));
				contato.setDataNascimento(calendar);
				
				contatos.add(contato);
			}
			resultSet.close();
			statement.close();
		}
		catch(SQLException e)
		{
			throw new DAOException(e);
		}

		return contatos;
	}

	public Contato getContatoById(long id)
	{

		Contato contato = new Contato();
		
		try
		{
			String sql = "select * from contatos where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			throw new DAOException(e);
		}

		return contato;
	}

	public ArrayList<Contato> getContatoByNome(String nome)
	{
		ArrayList<Contato> contatos = new ArrayList<>();

		try
		{
			String sql = "select * from contatos where nome like ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();

			while(rs.next())
			{
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}

		}
		catch(SQLException e)
		{
			throw new DAOException(e);
		}

		return contatos;
	}

	public ArrayList<Contato> getContatoByEmail(String email)
	{
		ArrayList<Contato> contatos = new ArrayList<>();

		try
		{
			String sql = "select * from contatos where email like ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%"+email+"%");
			ResultSet rs = stmt.executeQuery();

			while(rs.next())
			{
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("email"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}
			stmt.close();
			rs.close();
		}
		catch(SQLException e)
		{
			throw new DAOException(e);
		}

		return contatos;
	}

	public ArrayList<Contato> getContatoByEndereco(String endereco)
	{
		ArrayList<Contato> contatos = new ArrayList<>();

		try
		{
			String sql = "select * from contatos where endereco like ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%"+endereco+"endereco");
			ResultSet rs = stmt.executeQuery();

			while(rs.next())
			{
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			throw new DAOException(e);
		}

		return contatos;
	}


	public ArrayList<Contato> getContatoByTimeInterval(String data1, String data2)
	{
		ArrayList<Contato> contatos = new ArrayList<>();
		data1 = String.format("%s-%s-%s", data1.substring(6, 10), data1.substring(3, 5), data1.substring(0, 2));
		data2 = String.format("%s-%s-%s", data2.substring(6, 10), data2.substring(3, 5), data2.substring(0, 2));
		
		Date sData1 = Date.valueOf(data1);
		Date sData2 = Date.valueOf(data2);

		try
		{
			String sql = "select * from contatos where datanascimento between ? and ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, sData1);
			stmt.setDate(2, sData2);

			ResultSet rs = stmt.executeQuery();

			while(rs.next())
			{
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}

			rs.close();
			stmt.close();
		}
		catch (SQLException e)
		{
			throw new DAOException(e);
		}

		return contatos;

	}

}