import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DateParseTest
{
	public static void main (String [] args)
	{
		String data1 = "21/03/1990";
		String data2 = "20/05/2009";
		ContatoDAO cdao = new ContatoDAO();
		ArrayList<Contato> contatos = cdao.getContatoByTimeInterval(data1, data2);

		for(Contato contato : contatos)
		{
			System.out.println(contato);
		}
	}
}