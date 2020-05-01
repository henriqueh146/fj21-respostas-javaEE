public class Funcionario
{
	private long id;
	private String nome;
	private String usuario;
	private String senha;

	public void setId(long id)
	{
		this.id = id;
	}

	public long getId()
	{
		return id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getNome()
	{
		return nome;
	}

	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	public String getUsuario()
	{
		return usuario;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public String getSenha()
	{
		return senha;
	}

}