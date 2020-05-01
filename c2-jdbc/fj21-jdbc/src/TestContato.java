public class TestContato
{
	public static void main(String [] args)
	{
		Contato contato = new Contato();
		contato.setNome("Henrique");
		contato.setId(1);
		contato.setEndereco("Avenida Vereador Francisco das Chagas Farias, 913, Centro, Ipu-CE.");
		contato.setEmail("henriquecon1@gmail.com");

		System.out.println(contato);
	}
}