package is.ru.hbfraedi.TTT;
import is.ru.hbfraedi.TTT.Exception.XOException;

public class TTT 
{
	public static void main(String[] args) 
	{

        System.out.println("Welcom to Tic Tac Toe");

        Board board = new Board();
		System.out.println(board);


        board.setCell(2,'x');
        System.out.println(board);

        board.setCell(2,'o');
        System.out.println(board);


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
