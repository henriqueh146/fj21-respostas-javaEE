import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class TestaInsere{

	public static void main(String [] args)
	{
		SimpleDateFormat dataf = new SimpleDateFormat("dd/MM/YYYY");

		Contato contato = new Contato();
		Scanner input = new Scanner(System.in);
		ContatoDao contatoDao = new ContatoDao();

		System.out.println("Digite o nome");
		contato.setNome(input.nextLine());
		System.out.println("Digite o e-mail");
		contato.setEmail(input.nextLine());
		System.out.println("Digite o endereço");
		contato.setEndereco(input.nextLine());
		System.out.println("Digite a data de nascimento no formato DD/MM/AAAA");
		try
		{
			dataf.parse(input.nextLine());
		}catch (ParseException e)
		{
			System.out.println("Erro!!! "+e.getMessage());
		}
		contato.setDataNascimento(dataf.getCalendar());

		contatoDao.adiciona(contato);
	}
}