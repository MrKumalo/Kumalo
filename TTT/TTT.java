public class TTT 
{
	public static void main(String[] args) 
	{
		Player arnar = null;
		Player solberg = null;
		try
		{
			arnar = new Player('x', "Arnar");
			solberg = new Player('o', "Solberg");
		}
		catch(XOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		Board game = new Board();
	}	
}