import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

public class TestaDaoRev
{
	public static final String DATA_1 = "21/03/1990";
	public static final String DATA_2 = "01/01/2020";

	public static void main(String [] args)
	{
		ContatoDao contatodao = new ContatoDao();
		ArrayList<Contato> contatos = contatodao.getLista();
		System.out.println("Lista de contatos antes de alterar:");
		imprimeListaDeContatos(contatos);

		Scanner input = new Scanner(System.in);
		System.out.println("Digite o Id do contato a ser alterado");
		long idAlvo = input.nextLong();
		input.nextLine();
		int indice;
		for(indice = 0; indice < contatos.size(); indice++)
		{
			if(idAlvo == contatos.get(indice).getId())
				break;

			if(indice == contatos.size() - 1)
				System.out.printf("Id %d não encontrado na lista de contatos. %n", idAlvo);
		}

		if(indice != contatos.size())
		{
			Contato alteracao = contatos.get(indice);

			System.out.println("Digite o novo nome:");
			alteracao.setNome(input.nextLine());
			System.out.println("Digite o novo email:");
			alteracao.setEmail(input.nextLine());
			System.out.println("Digite o novo endereço:");
			alteracao.setEndereco(input.nextLine());
			System.out.println("Digite a nova data de nascimento (dd/MM/yyyy):");
			String dataS = input.nextLine();
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.set(Integer.parseInt(dataS.substring(6, 10)), Integer.parseInt(dataS.substring(3, 5)),
			Integer.parseInt(dataS.substring(0,2)));
			alteracao.setDataNascimento(dataNascimento);

			contatodao.altera(alteracao);

			contatos.set(indice, contatodao.getContatoById(alteracao.getId()));
		}

		System.out.println("Lista de contatos após alteração:");
		imprimeListaDeContatos(contatos);

		System.out.printf("Excluindo o contato de id %d.%n", contatos.get(indice).getId());

		contatodao.remove(contatos.get(indice));
		System.out.println("Função remove executada. \nLimpando a lista da ram " +
			"e acessando o banco para pegar a lista atualizada para imprimir:");
		contatos.clear();
		contatos = contatodao.getLista();
		imprimeListaDeContatos(contatos);
	}

	public static void imprimeListaDeContatos(ArrayList<Contato> contatos)
	{
		for(Contato contato: contatos)
		{
			System.out.println(contato);
		}
	}

}