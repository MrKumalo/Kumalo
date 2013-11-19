package is.ru.ttt;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.junit.Test;

public class PlayerTest{

	@Test
	public void playerName()
	{
		Player player1 = new Player("Halli", true);
		 assertEquals("Halli", player1.getPlayer());
	}
	@Test
	public void isMyTurn()
	{
		Player player2 = new Player("Bull", true);
		assertEquals(true, player2.getTurn());
	}
	@Test
	public void TurnTest()
	{
		Player player1 = new Player("p1", true);
		Player player2 = new Player("p2", false);
		assertTrue(player1.getTurn());
		assertFalse(player2.getTurn());
	}
}