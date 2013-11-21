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
		try
		{
			Game game = new Game(player1, player2, t, 1);
		}
		catch(IllegalTurnException e)
		{
			System.out.println("Svona a thetta ekki ad vera!");
		}

		Player p1 = game.getP1();
		assertEquals(player1.toJson(), p1.toJson());
		//assertEquals(player2, game.getP2());
		//assertEquals(t, game.getTable());
		//assertEquals(1, game.getTurn());
	}
}