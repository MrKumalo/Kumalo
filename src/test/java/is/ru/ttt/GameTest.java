package is.ru.ttt;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class GameTest
{

	@Test
	public void CreateGameTest()
	{
		Player player1 = new Player("p1", true);
		Player player2 = new Player("p2", false);
		Table t = new Table();
		
		Game game = null;
		try
		{
			game = new Game(player1, player2, t, 1);
		}
		catch(IllegalTurnException e)
		{
			System.out.println("Svona a thetta ekki ad vera!");
		}

		Player p1 = new Player();
		p1 = game.getP1();
		assertEquals(player1, p1);

		Player p2 = new Player();
		p2 = game.getP2();
		assertEquals(player2, game.getP2());
		
		assertEquals(t, game.getTable());

		assertEquals(1, game.getTurn());
	}

	@Test
	public void defaultConsTest()
	{
		Game g = new Game();
		assertEquals(null, g.getP1());
		assertEquals(null, g.getP2());
		assertEquals(null, g.getTable());
		assertEquals(-1, g.getTurn());
	}

	@Test
	public void setTurnGameTest()
	{
		Player player1 = new Player("p1", true);
		Player player2 = new Player("p2", false);
		Table t = new Table();
		
		Game game = null;
		try
		{
			game = new Game(player1, player2, t, 1);
		}
		catch(IllegalTurnException e)
		{
			System.out.println("setTurnGameTest: OK");
		}

		try
		{
			game.setTurn(3);
		}
		catch(IllegalTurnException e)
		{
			System.out.println("status: OK");
		}
	}


	@Test
	public void setP1GameTest()
	{
		Player player1 = new Player("p1", true);
		Player player2 = new Player("p2", false);
		Table t = new Table();
		
		Game game = null;
		try
		{
			game = new Game(player1, player2, t, 1);
		}
		catch(IllegalTurnException e)
		{
			System.out.println("setP1GameTest: OK");
		}

		Player player3 = new Player("p3", true);
		game.setP1(player3);

		assertEquals(player3, game.getP1());
		

	}

	@Test
	public void setP2GameTest()
	{
		Player player1 = new Player("p1", true);
		Player player2 = new Player("p2", false);
		Table t = new Table();
		
		Game game = null;
		try
		{
			game = new Game(player1, player2, t, 1);
		}
		catch(IllegalTurnException e)
		{
			System.out.println("setP2GameTest: OK");
		}

		Player player3 = new Player("p3", true);
		game.setP2(player3);

		assertEquals(player3, game.getP2());
	}

	@Test
	public void CreateIllegalTurnGameTest()
	{
		Player player1 = new Player("p1", true);
		Player player2 = new Player("p2", false);
		Table t = new Table();
		
		Game game = null;
		try
		{
			game = new Game(player1, player2, t, 3);
		}
		catch(IllegalTurnException e)
		{
			System.out.println("CreateIllegalTurnGameTest: OK");
		}
	}



	@Test
	public void winningCombinationsGameTest()
	{
		Player player1 = new Player("p1", true);
		Player player2 = new Player("p2", false);
		Table t = new Table();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Game game = null;
		try
		{
			game = new Game(player1, player2, t, 1);
			assertEquals(false, game.winningCombinations(list));	
			
			/*	  x | x	| x
				-------------
				   	|   | 
				-------------
					|	| 		*/
			
			list.add(0);
			list.add(1);
			list.add(2);
			assertEquals(true, game.winningCombinations(list));

			/*	    | 	| 
				-------------
				  x	| x | x
				-------------
					|	| 		*/

			ArrayList<Integer> middle = new ArrayList<Integer>();
			assertEquals(false, game.winningCombinations(middle));
			middle.add(3);
			middle.add(4);
			middle.add(5);
			assertEquals(true, game.winningCombinations(middle));

			/*	    | 	| 
				-------------
				  	|   | 
				-------------
				  x	| x	| x 	*/

			ArrayList<Integer> lowest = new ArrayList<Integer>();
			assertEquals(false, game.winningCombinations(lowest));
			lowest.add(8);
			lowest.add(6);
			lowest.add(7);
			assertEquals(true, game.winningCombinations(lowest));


			/*	  x | 	| 
				-------------
				  x	|   |  
				-------------
				  x	|	| 		*/

			ArrayList<Integer> left = new ArrayList<Integer>();
			assertEquals(false, game.winningCombinations(left));
			left.add(0);
			left.add(6);
			left.add(3);
			assertEquals(true, game.winningCombinations(left));

			
			/*	    | x	| 
				-------------
				  	| x |  
				-------------
				  	| x	| 		*/

			ArrayList<Integer> center = new ArrayList<Integer>();
			assertEquals(false, game.winningCombinations(center));
			center.add(1);
			center.add(4);
			center.add(7);
			assertEquals(true, game.winningCombinations(center));


			/*	    | 	| x
				-------------
				  	|   | x
				-------------
					|	| x 	*/

			ArrayList<Integer> right = new ArrayList<Integer>();
			assertEquals(false, game.winningCombinations(right));
			right.add(8);
			right.add(2);
			right.add(5);
			assertEquals(true, game.winningCombinations(right));


			/*	  x | 	| 
				-------------
				  	| x |  
				-------------
				  	|	| x		*/

			ArrayList<Integer> diagonal1 = new ArrayList<Integer>();
			assertEquals(false, game.winningCombinations(diagonal1));
			diagonal1.add(0);
			diagonal1.add(4);
			diagonal1.add(8);
			assertEquals(true, game.winningCombinations(diagonal1));


			/*	    | 	| x
				-------------
				  	| x |  
				-------------
				  x	|	| 		*/

			ArrayList<Integer> diagonal2 = new ArrayList<Integer>();
			assertEquals(false, game.winningCombinations(diagonal2));
			diagonal2.add(6);
			diagonal2.add(4);
			diagonal2.add(2);
			assertEquals(true, game.winningCombinations(diagonal2));


		}
		catch(IllegalTurnException e)
		{
			System.out.println("winningCombinationsGameTest: error");
		}
	}

	@Test
	public void toJsonGameTest()
	{
		Player player1 = new Player("Mario", true);
		Player player2 = new Player("Dilbert", false);
		Table t = new Table();
		
		Game game = null;
		try
		{
			game = new Game(player1, player2, t, 1);
		}
		catch(IllegalTurnException e)
		{
			System.out.println("status: error");
		}

		String json = game.toJson();
		String tablejson = "{\"cell0\":\"E\"},{\"cell1\":\"E\"},{\"cell2\":\"E\"},{\"cell3\":\"E\"},{\"cell4\":\"E\"},{\"cell5\":\"E\"},{\"cell6\":\"E\"},{\"cell7\":\"E\"},{\"cell8\":\"E\"}";
		String p1json = ",{\"Player1\":\"Mario\"}";
		String p2json = ",{\"Player2\":\"Dilbert\"}";
		String turnjson =  ",{\"turn\":\"1\"}";
		String jsonTest = "[" + tablejson + p1json + p2json + turnjson + "]";
		assertEquals(game.toJson(), jsonTest);

	}
}