import java.util.Calendar;


/*
Para saber: para que serve
funções getInstance
como representar uma data específica

*/
public class MeuCalendario
{
	public static void main(String [] args)
	{
		Calendar rightNow = Calendar.getInstance();
		System.out.println(rightNow.get(Calendar.ALL_STYLES));
		/*rightNow.set(Calendar.MONTH, Calendar.JANUARY);
		rightNow.set(Calendar.YEAR, 1990);
		rightNow.set(Calendar.DAY_OF_MONTH, 21);
		System.out.printf("%02d/%02d/%4d", rightNow.get(Calendar.DAY_OF_MONTH), 
			rightNow.get(Calendar.MONTH), rightNow.get(Calendar.YEAR));*/
	}	
}