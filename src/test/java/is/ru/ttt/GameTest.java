package is.ru.ttt;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;

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
			System.out.println("status: OK");
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
			System.out.println("status: OK");
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
			System.out.println("status: OK");
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
			System.out.println("status: OK");
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