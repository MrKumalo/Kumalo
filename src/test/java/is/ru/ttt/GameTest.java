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

		game.setTurn(2);

		assertEquals(2, game.getTurn());
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
}