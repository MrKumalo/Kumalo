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

	}	
}